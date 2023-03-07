package com.salud.sistema.controladores;

import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.servicios.ObraSocialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/obrasocial")
public class ObraSocialControlador {

    @Autowired
    private ObraSocialServicio obraSocialServicio;

    @GetMapping("/registrar")  //localhost:8080/obrasocial/registrar
    public String registrar() {
        return "obrasocial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombreOS, ModelMap modelo) throws MiExcepcion {
        try {
            obraSocialServicio.crearObraSocial(nombreOS);
            modelo.put("exito", "La obra social fue registrada exitosamente");
        } catch (MiExcepcion ex) {

            modelo.put("error", ex.getMessage());
            return "obrasocial_form.html";
        }

        return "index.html";
    }


}
