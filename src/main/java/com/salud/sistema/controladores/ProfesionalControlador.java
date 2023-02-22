package com.salud.sistema.controladores;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.ProfesionalException;
import com.salud.sistema.repositorios.ObraSocialRepository;
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

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    @Autowired
    ObraSocialRepository obraSocialRepository;

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

}
