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
<<<<<<< HEAD
    return "index.html";
=======

        return "index.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    @GetMapping("/registrar")
    public String registrar() {
<<<<<<< HEAD
    return "registrarse.html";
=======
        return "registro.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
<<<<<<< HEAD
        @RequestParam String password2, ModelMap modelo, MultipartFile archivo) throws MiExcepcion {

        usuarioServicio.registrar(archivo,nombre, email, password, password2);
        modelo.put("exito", "Usuario registrado correctamente!");
        return "index.html";

    }

    @GetMapping("/login") //@RequestParam(required = false)
    public String login(@RequestParam String email, @RequestParam String contraseña, String error, ModelMap modelo ) {
=======
            String password2, ModelMap modelo, MultipartFile archivo) {

        try {
            
            usuarioServicio.registrar(archivo,nombre, email, password, password2);
            modelo.put("exito", "Usuario registrado correctamente!");
            
            return "index.html";
        } catch (MiExcepcion ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);

            return "registro.html";
        }

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo ) {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

        if (error != null) {
            modelo.put("error", "Usuario o Contraseña invalidos!");
        }

<<<<<<< HEAD
        return "ingresar.html";
=======
        return "login.html";
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
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
