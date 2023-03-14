package com.salud.sistema.controladores;

import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.servicios.TurnoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/turno")
public class TurnoControlador {

    @Autowired
    private TurnoServicio turnoServicio;

    @GetMapping("/listarTurnos") //localhost:8080/turno/listarturnos
    public String listarTurno(@RequestParam long id, ModelMap modelo) throws MiExcepcion {

        List<Turno> turnos = turnoServicio.listarTurnoPorProfesional(id);
        modelo.addAttribute("turnos", turnos);
        return "turno_lista.html";
    }

    //esta lista es para la vista profesional donde puede ver los turnos que tiene en ese dia
    @GetMapping("/listarTurnosPorDia") //localhost:8080/turno/listarturnosPorDia
    public String listarTurnoPorDia(@RequestParam long id, @RequestParam Dia dia, ModelMap modelo) throws MiExcepcion {

        List<Turno> turnos = turnoServicio.turnosDelDia(id, dia);
        modelo.addAttribute("turnos", turnos);
        return "turno_listaPorDia.html";
    }
    
    @GetMapping("/turnosDelPaciente") //localhost:8080/turno/turnosDelPaciente
    public String turnosPorPaciente(@RequestParam long id, ModelMap modelo) throws MiExcepcion {

        List<Turno> turnos = turnoServicio.turnosPorPaciente(id);
        modelo.addAttribute("turnos", turnos);
        return "turno_paciente.html";
    }

    @PostMapping("/creacion/{id}")
    public String creacionTurno(@PathVariable Long id, @RequestParam Dia dia, @RequestParam String horaInicio, @RequestParam String horaFin,
            @RequestParam TipoConsulta tipoConsulta, ModelMap modelo) {
        try {
            turnoServicio.crearTurno(id, dia, horaInicio, horaFin, true, tipoConsulta);
            modelo.put("exito", "El turno fue creado exitosamente");
            return "redirect:/";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "turno_form.html";
        }
    }

    @RequestMapping(value = "/cancelar/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String cancelarTurno(@PathVariable("id") Long id, ModelMap modelo) {
        try {
            turnoServicio.cancelarTurno(id);
            modelo.put("exito", "El turno fue cancelado exitosamente");
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
        }
        return "redirect:/";
    }

    @PutMapping("/aceptacion/{id}")
    public String aceptacionTurno(@PathVariable Long id,@RequestParam String email, ModelMap modelo) {
        try {
            turnoServicio.turnoCreado(id, email);
            return "redirect:../listar";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "turno_aceptado.html";
        }
    }
    
   
    @PutMapping("/darPuntaje/{id}")
    public String calcularPuntajePorTurno(@PathVariable Long id,@RequestParam double puntaje,@RequestParam long profesionalId,ModelMap modelo){
         try {
            turnoServicio.calcularPuntajePorTurno(id, puntaje, profesionalId);
            return "redirect:../";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "darPuntaje.html";
        }
    }
}
