/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.repositorios.TurnoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServicio {
    
    @Autowired
    TurnoRepositorio turnoRepositorio;

     @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    
    public Turno crearTurno(Turno turno , long profesionalId){
        
        Profesional profesional = profesionalRepositorio.findFirstById(profesionalId);
        
        Turno turnos= new Turno();
        turnos.setDia(turno.getDia());
        turnos.setHora(turno.getHora());
        turnos.setDisponibilidad(true);
        turnos.setProfesional(profesional);
        turnos.setTipoConsulta(turno.getTipoConsulta());
        
        return turno;
        
    }
    

}
