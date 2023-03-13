package com.salud.sistema.controladores;

import com.salud.sistema.entidades.DetalleHC;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.servicios.DetalleHCServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/DetalleHC")
public class DetalleHCControlador {

    @Autowired
    private DetalleHCServicio detalleHCServicio;

    @PostMapping("/creacion/{id}")
    public String crearDetalle(@PathVariable long profesionalId, @RequestParam long turnoId, @RequestParam String descripcion, ModelMap modelo) {
        try {
            detalleHCServicio.crearDetalle(profesionalId, turnoId, descripcion);
            modelo.put("exito", "El detalle fue creado exitosamente");
            return "redirect:/";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "detalleHC_form.html";
        }
    }

}
