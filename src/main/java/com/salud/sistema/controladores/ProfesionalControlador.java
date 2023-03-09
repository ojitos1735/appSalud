package com.salud.sistema.controladores;
<<<<<<< HEAD

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.ProfesionalException;
import com.salud.sistema.repositorios.ObraSocialRepositorio;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.servicios.ProfesionalServicio;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.coyote.http11.Http11AprProtocol;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.excepciones.MiExcepcion;

import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.servicios.ProfesionalServicio;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salud.sistema.repositorios.ObraSocialRepositorio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

<<<<<<< HEAD
    @Autowired
=======
   
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    private ProfesionalRepositorio profesionalRepositorio;
    @Autowired
    ObraSocialRepositorio obraSocialRepositorio;

<<<<<<< HEAD
    @GetMapping("/listarProfesionales") //localhost:8080/profesional/listarProfesionales
    public ResponseEntity<Object> listaProfesionales(@RequestParam(("especialidad")) Especialidad especialidad, @RequestParam(required = false) String obraSocial) throws ProfesionalException {
        List<Profesional> profesionales = new ArrayList<>();
        try {
            profesionales = profesionalServicio.buscarProfesionalPorEspecialidad(especialidad, obraSocial);
        } catch (Exception e) {
            e.getMessage();
        }

        return  new ResponseEntity<>(profesionales,HttpStatus.OK);
    }
/*
    @PostMapping("/created")
    public ResponseEntity<Object> createdProfesional(@RequestBody Profesional profesional) {
        Profesional profe = new Profesional();

        try {

            profe.setNombre(profesional.getNombre());
            profe.setApellido(profesional.getApellido());
            profe.setContrasenia(profesional.getContrasenia());
            profe.setCalificacion(profesional.getCalificacion());
            profe.setDni(profesional.getDni());
            profe.setEmail(profesional.getEmail());
            profe.setId(profesional.getId());
            profe.setMatricula(profesional.getMatricula());
            profe.setRol(Rol.PROFESIONAL);
            profe.setTelefono(profesional.getTelefono());
            profe.setTipoConsulta(TipoConsulta.PRESENCIAL);
            profe.setValorConsulta(profesional.getValorConsulta());
       
            Set<ObraSocial> obraSocial=  StreamSupport.stream(obraSocialRepository.findAll().spliterator(),false)
            .collect(Collectors.toSet());
            profe.setCubreOS( obraSocial);

            profe.setEspecialidad(Especialidad.GINECOLOGIA);
            profe.setAlta(true);
            profe.setHorarios(profesional.getHorarios());
            profesionalRepositorio.save(profe);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(profe, HttpStatus.CREATED);

    }*/

=======



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
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
}
