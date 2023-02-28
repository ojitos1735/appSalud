package com.salud.sistema.controladores;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.MiExcepcion;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salud.sistema.repositorios.ObraSocialRepositorio;
import java.time.LocalTime;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

    
    @Autowired
    ObraSocialRepositorio obraSocialRepository;

    @GetMapping("/listarProfesionales") //localhost:8080/profesional/listarProfesionales
    public ResponseEntity<Object> listaProfesionales(@RequestParam(("especialidad")) Especialidad especialidad, @RequestParam(required = false) String obraSocial) throws MiExcepcion {
        List<Profesional> profesionales = new ArrayList<>();
        try {
            profesionales = profesionalServicio.buscarProfesionalPorEspecialidad(especialidad, obraSocial);
        } catch (Exception e) {
            e.getMessage();
        }

        return  new ResponseEntity<>(profesionales,HttpStatus.OK);
    }

    @PostMapping("/registro")
    public String createdProfesional(@RequestBody Profesional profesional,ModelMap modelo) {
       
      try {
          profesionalServicio.crearProfesional(profesional);
            modelo.put("exito", "El Profesional fue registrado exitosamente");
            return "redirect:/";
    }catch(Exception e){
    
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
