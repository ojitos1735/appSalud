/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.Paciente;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.EstadoTurno;
import static com.salud.sistema.enums.EstadoTurno.CREADO;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.repositorios.PacienteRepositorio;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.repositorios.TurnoRepositorio;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurnoServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    TurnoRepositorio turnoRepositorio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Transactional
    public Turno crearTurno(long profesionalId, Dia dia, String horaInicio, String horaFin, boolean disponibilidad, TipoConsulta tipoConsulta) throws MiExcepcion {

        LocalTime horaInicio1 = null;
        LocalTime horaFin2 = null;

        try {
            if (horaInicio != null) {
                horaInicio1 = LocalTime.parse(horaInicio);
            }
            if (horaFin != null) {
                horaFin2 = LocalTime.parse(horaFin);
            }
        } catch (Exception e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");

        }

        Profesional profesional = new Profesional();
        try {
            profesional = profesionalRepositorio.findFirstById(profesionalId);
            if (profesional == null) {
                throw new MiExcepcion("No se pudo encontrar el profesional");
            }
        } catch (MiExcepcion e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
        }
        Turno turno = new Turno();

        turno.setDia(dia);

        turno.setHorainicio(horaInicio1);
        
        turno.setHoraFin(horaFin2);
        
        turno.setDisponibilidad(
                true);
        turno.setProfesional(profesional);

        turno.setTipoConsulta(tipoConsulta);

        turnoRepositorio.save(turno);
        return turno;

    }

    @Transactional
    public String cancelarTurno(long id) throws MiExcepcion {
        Turno turno = new Turno();

        try {
            turno = turnoRepositorio.findFirstById(id);
            if (turno == null) {
                throw new MiExcepcion("No se pudo encontrar el turno");
            }
        } catch (MiExcepcion e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
        }

        turno.setDisponibilidad(false);

        turno.setEstadoTurno(EstadoTurno.CANCELADO);

        turnoRepositorio.save(turno);
        return "El turno fue dado de baja exitosamente";
    }

    public List<Turno> listarTurnoPorProfesional(long id) {
        List<Turno> todosLosTurnos = new ArrayList();

        List<Turno> turnosDisponibles = turnoRepositorio.findByProfesionalId(id);
        turnosDisponibles.stream().forEach(turno -> {
            if (turno.isDisponibilidad() == true) {
                todosLosTurnos.add(turno);
            }
        });

        return todosLosTurnos;
    }

    @Transactional
    public Turno turnoCreado(long id, String email) throws MiExcepcion {
        Turno turno = new Turno();

        try {
            turno = turnoRepositorio.findFirstById(id);
            if (turno == null) {
                throw new MiExcepcion("No se pudo encontrar el turno");
            }
        } catch (MiExcepcion e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
        }

        Paciente paciente = pacienteRepositorio.buscarPorEmail(email);
        turno.setPaciente(paciente);
        turno.setEstadoTurno(CREADO);
        turno.setDisponibilidad(false);
        turnoRepositorio.save(turno);
        return turno;
    }

}
