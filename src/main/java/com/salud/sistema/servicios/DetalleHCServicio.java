package com.salud.sistema.servicios;

import com.salud.sistema.entidades.DetalleHC;
import com.salud.sistema.entidades.HistoriaClinica;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.EstadoTurno;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.repositorios.DetalleHCRepositorio;
import com.salud.sistema.repositorios.HistoriaClinicaRepositorio;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.repositorios.TurnoRepositorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleHCServicio {

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Autowired
    private TurnoRepositorio turnoRepositorio;

    @Autowired
    private HistoriaClinicaRepositorio historiaClinicaRepositorio;
    @Autowired
    private DetalleHCRepositorio detalleHCRepositorio;

    public void crearDetalle(long profesionalId, long turnoId, String descripcion) throws MiExcepcion {

        Profesional profesional = profesionalRepositorio.findFirstById(profesionalId);
        try {
            if (profesional == null) {
                throw new MiExcepcion("No se pudo encontrar el profesional");
            }
        } catch (MiExcepcion e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
        }

        Turno turno = turnoRepositorio.findFirstById(turnoId);
           try {
            if (turno == null) {
                throw new MiExcepcion("No se pudo encontrar el turno");
            }
        } catch (MiExcepcion e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
        }

        
        
        HistoriaClinica historiaClinica = historiaClinicaRepositorio.findByPacienteId(turno.getPaciente().getId());

        List<DetalleHC> listaDetalleHC = new ArrayList<>();

        DetalleHC detalleHC = new DetalleHC();
        detalleHC.setDescripcion(descripcion);
        detalleHC.setFecha(LocalDate.now());
        detalleHC.setProfesional(profesional);
        detalleHCRepositorio.save(detalleHC);
        listaDetalleHC.add(detalleHC);
        historiaClinica.setDetalles(listaDetalleHC);
        historiaClinicaRepositorio.save(historiaClinica);

        turno.setEstadoTurno(EstadoTurno.FINALIZADO);
        turnoRepositorio.save(turno);

    }

}
