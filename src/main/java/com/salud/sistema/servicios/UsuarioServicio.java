package com.salud.sistema.servicios;

import com.salud.sistema.entidades.Admin;
import com.salud.sistema.entidades.Imagen;
import com.salud.sistema.entidades.Usuario;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.repositorios.AdminRepositorio;
import com.salud.sistema.repositorios.ImagenRepositorio;
import com.salud.sistema.repositorios.PacienteRepositorio;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private AdminRepositorio adminRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;
    
    @Transactional
    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MiExcepcion {

        validar(nombre, email, password, password2);

        Admin admin = new Admin();

        admin.setNombre(nombre);
        admin.setEmail(email);
        
        admin.setContrasenia(new BCryptPasswordEncoder().encode(password));

        Imagen imagen = imagenServicio.guardar(archivo);
                
        admin.setImagen(imagen);

        admin.setRol(Rol.ADMIN);

        adminRepositorio.save(admin);
    }
    
    @Transactional
    public void actualizar(MultipartFile archivo, String idUsuario, String nombre, String email, String contrasenia, String contrasenia2) throws MiExcepcion {

        validar(nombre, email, contrasenia, contrasenia2);

        Usuario respuesta = buscarUsuarioPorEmail(email);
        if (respuesta !=null) {

            Usuario usuario = respuesta;
            usuario.setNombre(nombre);
            usuario.setEmail(email);

            usuario.setContrasenia(new BCryptPasswordEncoder().encode(contrasenia));
            
            usuario.setRol(Rol.ADMIN);
         
            String idImagen = null;
            
            if (usuario.getImagen() != null) {
                idImagen = usuario.getImagen().getId();
            }
            
            Imagen imagen = imagenServicio.actualizar(archivo, idImagen);
            
            usuario.setImagen(imagen);
            
            usuarioRepositorio.save(usuario);
        }

    }
    
    
    private void validar(String nombre, String email, String password, String password2) throws MiExcepcion {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiExcepcion("Las contraseñas ingresadas deben ser iguales");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = buscarUsuarioPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getContrasenia(), permisos);
        } else {
            return null;
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        Usuario usuario = pacienteRepositorio.buscarPorEmail(email);
        if (usuario == null) {
            usuario = profesionalRepositorio.buscarPorEmail(email);
            if (usuario == null) {
                usuario = adminRepositorio.buscarPorEmail(email);
            }
        } 
        return usuario;
    }
    
    public Usuario buscarUsuarioPorId(Long id) {
        Usuario usuario = pacienteRepositorio.buscarPorId(id);
        if (usuario == null) {
            usuario = profesionalRepositorio.buscarPorId(id);
            if (usuario == null) {
                usuario = adminRepositorio.buscarPorId(id);
            }
        } 
        return usuario;
    }
}
