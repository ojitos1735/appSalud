package com.salud.sistema.controladores;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.excepciones.MiExcepcion;

import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.servicios.ProfesionalServicio;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salud.sistema.repositorios.ObraSocialRepositorio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

   
    private ProfesionalRepositorio profesionalRepositorio;
    @Autowired
    ObraSocialRepositorio obraSocialRepositorio;




    @GetMapping("/listarProfesionales") //localhost:8080/profesional/listarProfesionales
    public String listaProfesionales(@RequestParam(("especialidad")) Especialidad especialidad, @RequestParam(required = false) String obraSocial,ModelMap modelo) throws MiExcepcion {
        List<Profesional> profesionales = new ArrayList<>();
        try {
            profesionales = profesionalServicio.buscarProfesionalPorEspecialidad(especialidad, obraSocial);
       modelo.addAttribute("profesionales", profesionales);
        
        } catch (MiExcepcion e) {
            e.getMessage();
        }

       return "registro_profesional_listar.html";
    }
    
    
    
    
}

