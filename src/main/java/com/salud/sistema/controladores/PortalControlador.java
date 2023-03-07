package com.salud.sistema.controladores;


import com.salud.sistema.entidades.Usuario;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index() {

        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
            String password2, ModelMap modelo, MultipartFile archivo) throws MiExcepcion {

        usuarioServicio.registrar(archivo,nombre, email, password, password2);
        modelo.put("exito", "Usuario registrado correctamente!");
        return "index.html";

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo ) {

        if (error != null) {
            modelo.put("error", "Usuario o Contraseña invalidos!");
        }

        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {
        
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        
        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        
           return "inicio.html";
    }

}