<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
package com.salud.sistema.controladores;

import com.salud.sistema.entidades.Paciente;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.servicios.ObraSocialServicio;
import com.salud.sistema.servicios.PacienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")      //localhost:8080/paciente
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;
    
    @Autowired
    private ObraSocialServicio obraSocialServicio;

    @GetMapping("/registrar")  //localhost:8080/paciente/registrar
    public String registrar(ModelMap modelo) {
        modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
<<<<<<< HEAD
        return "paciente_form.html";
=======
        return "registro_paciente.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, 
<<<<<<< HEAD
<<<<<<< HEAD
            /*@RequestParam String contrasenia,*/
            @RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam Long idOS, ModelMap modelo) {
        try {
            pacienteServicio.crearPaciente(nombre, apellido, email, /*contrasenia,*/ dni, telefono, idOS);
=======
            @RequestParam String contrasenia,@RequestParam String contrasenia2,
            @RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam Long idOS, ModelMap modelo) {
        try {
            pacienteServicio.crearPaciente(nombre, apellido, email, contrasenia,contrasenia2, dni, telefono, idOS);
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
=======
            @RequestParam String contrasenia,@RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam Long idOS, ModelMap modelo) {
        try {pacienteServicio.crearPaciente(nombre, apellido, email, contrasenia, contrasenia, dni, telefono, idOS);

>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
            modelo.put("exito", "El paciente fue registrado exitosamente");
            return "redirect:/";
        } catch (MiExcepcion ex) {
            modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
            modelo.put("error", ex.getMessage());
<<<<<<< HEAD
            return "paciente_form.html";
=======
            return "registro_paciente.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        }
    }
    
    @GetMapping("/listar") // localhost:8080/paciente/listar
    public String listar(ModelMap modelo) {
        List<Paciente> pacientes = pacienteServicio.listarPacientes();
        modelo.addAttribute("pacientes", pacientes);
<<<<<<< HEAD
        return "paciente_lista.html";
=======
        return "registro_paciente_listar.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {
<<<<<<< HEAD
        modelo.put("paciente", pacienteServicio.getOne(id));

        return "paciente_modificar.html";
=======
        modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
        modelo.put("paciente", pacienteServicio.getOne(id));

        return "registro_paciente_modificar.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String nombre, String apellido, String email,
<<<<<<< HEAD
            Integer telefono, Long idObraSocial, ModelMap modelo) {
        try {
            pacienteServicio.modificarPaciente(id, nombre, apellido, email, telefono/*, idObraSocial*/);
            return "redirect:../listar";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "paciente_modificar.html";
=======
            Integer telefono/*, Long idObraSocial*/, ModelMap modelo) {
        try {
            pacienteServicio.modificarPaciente(id, nombre, apellido, email, telefono/*, idObraSocial*/) ;

            return "redirect:../listar";

        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "registro_paciente_modificar.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        }
    }
    

    @RequestMapping(value="/eliminar/{id}",method={RequestMethod.GET,RequestMethod.DELETE})
    public String eliminar(@PathVariable("id") Long id, ModelMap modelo) {
        try {
            pacienteServicio.borrarPaciente(id);
            modelo.put("exito", "El paciente fue eliminado exitosamente");
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
        }
        return "redirect:/";
    }
}
