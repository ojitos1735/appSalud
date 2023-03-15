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
import org.springframework.web.multipart.MultipartFile;

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
        return "registro_paciente.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, 
            @RequestParam String contrasenia,@RequestParam Integer dni, @RequestParam Integer telefono, 
            @RequestParam Long idOS, ModelMap modelo, MultipartFile archivo) {
        try {
            pacienteServicio.crearPaciente(nombre, apellido, email, contrasenia, contrasenia, dni, telefono, idOS, archivo);
            System.out.println("Paciente controlador");
            modelo.put("exito", "El paciente fue registrado exitosamente");
            return "redirect:/";
        } catch (MiExcepcion ex) {
            modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
            modelo.put("error", ex.getMessage());
            return "registro_paciente.html";
        }
    }
    
    @GetMapping("/listar") // localhost:8080/paciente/listar
    public String listar(ModelMap modelo) {
        List<Paciente> pacientes = pacienteServicio.listarPacientesporApellido();
        modelo.addAttribute("pacientes", pacientes);
        return "registro_paciente_listar.html";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrar(@PathVariable Long id, ModelMap modelo) {
        try {
            Paciente paciente = pacienteServicio.mostrarPaciente(id);
            modelo.put("paciente", paciente);
            return "page_paciente.html";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "registro_paciente_listar.html";
        }  
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {
        modelo.addAttribute("obrasSociales", obraSocialServicio.listarObrasSociales());
        modelo.put("paciente", pacienteServicio.getOne(id));

        return "registro_paciente_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String nombre, String apellido, String email,
            Integer telefono, MultipartFile archivo/*, Long idObraSocial*/, ModelMap modelo) {
        try {
            pacienteServicio.modificarPaciente(id, nombre, apellido, email, telefono/*, idObraSocial*/, archivo) ;

            return "redirect:../listar";

        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "registro_paciente_modificar.html";
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
