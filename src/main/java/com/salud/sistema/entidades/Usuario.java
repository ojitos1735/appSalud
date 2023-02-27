
package com.salud.sistema.entidades;

//@author jmerc

import java.awt.Image;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private Long Id;
    private String nombre;
    private String apellido;
    private String email;
    private String Contraseña;
    private Integer dni;
    private Integer telefono;
    private Image imagen;
    private boolean alta;

    public Usuario() {
    }

    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public Integer getDni() {
        return dni;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Image getImagen() {
        return imagen;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
  
}
