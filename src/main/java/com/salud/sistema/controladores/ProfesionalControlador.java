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

       return "profesional_lista.html";
    }

    @PostMapping("/registro")
    public String createdProfesional(@RequestParam String nombre,@RequestParam String apellido,@RequestParam Integer dni,@RequestParam String email,@RequestParam Integer matricula,@RequestParam Integer telefono,@RequestParam Especialidad especialidad,@RequestParam String contrasenia,ModelMap modelo) {
       
      try {
          profesionalServicio.crearProfesional(nombre, apellido, dni, email, matricula, telefono, especialidad, contrasenia);
            modelo.put("exito", "El Profesional fue registrado exitosamente");
            return "redirect:/";
    }catch( MiExcepcion ex){
       modelo.put("error", ex.getMessage());
        return "profesional_form.html";
    }
    }
      @RequestMapping(value="/eliminar/{id}",method={RequestMethod.GET,RequestMethod.DELETE})
    public String eliminar(@PathVariable("id") Long id, ModelMap modelo) {
        try {
            profesionalServicio.bajaProfesional(id);
            modelo.put("exito", "El profesional fue eliminado exitosamente");
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
        }
        return "redirect:/";
    }
    
    @PutMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id,String descripcion,@RequestParam(required = false) Long[]obraSocialId,
            float valorConsulta, ModelMap modelo) {
        try {
            profesionalServicio.modificarProfesional(id,descripcion, obraSocialId,valorConsulta);
            return "redirect:../listar";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "profesional_modificar.html";
        }
    }
}
