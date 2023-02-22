/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        return "paciente_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, 
            /*@RequestParam String contrasenia,*/
            @RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam Long idOS, ModelMap modelo) {
        try {
            System.out.println("X");
            pacienteServicio.crearPaciente(nombre, apellido, email, /*contrasenia,*/ dni, telefono, idOS);
            System.out.println("Y");
            modelo.put("exito", "El paciente fue registrado exitosamente");
            return "redirect:/";
        } catch (MiExcepcion ex) {
            modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
            System.out.println("Z");
            modelo.put("error", ex.getMessage());
            return "paciente_form.html";
        }
    }
    
    @GetMapping("/listar") // localhost:8080/paciente/listar
    public String listar(ModelMap modelo) {
        List<Paciente> pacientes = pacienteServicio.listarPacientes();
        modelo.addAttribute("pacientes", pacientes);
        return "paciente_lista.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("paciente", pacienteServicio.getOne(id));

        return "paciente_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String nombre, String apellido, String email,
            Integer telefono, Long idObraSocial, ModelMap modelo) {
        try {
            pacienteServicio.modificarPaciente(id, nombre, apellido, email, telefono, idObraSocial);
            return "redirect:../listar";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "paciente_modificar.html";
        }
    }
}
