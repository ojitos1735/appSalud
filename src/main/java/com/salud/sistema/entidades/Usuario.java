package com.salud.sistema.entidades;


import com.salud.sistema.enums.Rol;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    //@NotEmpty
    protected String nombre;

   // @NotEmpty
    protected String apellido;

    //@NotEmpty
    //@Email
    protected String email;

    /*
    protected String contrasenia;
    */

    protected Integer dni;

    protected Integer telefono;
/*
    @NotEmpty
    protected Imagen imagen;  
*/
   // @NotNull
    protected Boolean alta;

    protected Rol rol;
}