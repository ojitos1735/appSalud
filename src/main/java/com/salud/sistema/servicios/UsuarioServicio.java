package com.salud.sistema.servicios;

<<<<<<< HEAD

=======
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import com.salud.sistema.entidades.Admin;
import com.salud.sistema.entidades.Usuario;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.excepciones.MiExcepcion;
<<<<<<< HEAD
import com.salud.sistema.repositorios.UsuarioRepositorio;

=======
import com.salud.sistema.repositorios.AdminRepositorio;
import com.salud.sistema.repositorios.PacienteRepositorio;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import com.salud.sistema.repositorios.UsuarioRepositorio;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import java.util.ArrayList;
import java.util.List;
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
<<<<<<< HEAD
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Transactional
    public Admin registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MiExcepcion {
        validar(nombre, email, password, password2);
        
        Admin admin = new Admin();
        admin.setNombre(nombre);
        admin.setEmail(email);
        admin.setPassword(new BCryptPasswordEncoder().encode(password));
        admin.setRol(Rol.ADMIN);
        usuarioRepositorio.save(admin);
        return admin;
=======
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private AdminRepositorio adminRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Transactional
    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MiExcepcion {

        validar(nombre, email, password, password2);

        Admin admin = new Admin();

        admin.setNombre(nombre);
        admin.setEmail(email);

        admin.setContrasenia(new BCryptPasswordEncoder().encode(password));

        admin.setRol(Rol.ADMIN);

        usuarioRepositorio.save(admin);
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    }

    private void validar(String nombre, String email, String password, String password2) throws MiExcepcion {

<<<<<<< HEAD
        if (nombre.isEmpty()) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty()) {
            throw new MiExcepcion("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password.length() <= 5) {
=======
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiExcepcion("Las contraseñas ingresadas deben ser iguales");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
<<<<<<< HEAD
        
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        
        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().toString());
            
            permisos.add(p);
   
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getContrasenia(),permisos);
        }else{
            return null;
        }

    }
    
=======

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
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
}
