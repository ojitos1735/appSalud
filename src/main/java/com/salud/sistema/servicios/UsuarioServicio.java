package com.salud.sistema.servicios;

//@author jmerc

import com.salud.sistema.entidades.Usuario;
import com.salud.sistema.repositorios.UsuarioRepositorio;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void crearUsuario(String nombre,String apellido,String email,String Contraseña,Integer dni,Integer telefono,Image imagen,boolean alta){
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setContraseña(Contraseña);
        usuario.setDni(dni);
        usuario.setTelefono(telefono);
        usuario.setImagen(imagen);
        usuario.setAlta(alta);
        
        usuarioRepositorio.save(usuario);
    }
    
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios= new ArrayList();
        
        usuarios = usuarioRepositorio.findAll();
        
        return usuarios;
    }
    
    @Transactional
    public void modificarUsuario(Long id,String nombre,String apellido,String email,String Contraseña,Integer dni,Integer telefono,Image imagen,boolean alta){
        Optional<Usuario> respuesta= usuarioRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Usuario usuario =new Usuario();
            
            usuario= respuesta.get();
            
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setContraseña(Contraseña);
            usuario.setTelefono(telefono);
            usuario.setDni(dni);
            usuario.setImagen(imagen);
            usuario.setAlta(alta);
            
            usuarioRepositorio.save(usuario);
        }
        
    }
    
}
