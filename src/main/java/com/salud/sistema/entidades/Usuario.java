package com.salud.sistema.entidades;

import com.salud.sistema.enums.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@MappedSuperclass
@Data


public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    protected Long id;

    @NotEmpty
    protected String nombre;
     @NotEmpty
    protected String apellido;

    @NotEmpty
    @Email
    protected String email;

    @NotEmpty
    protected String contrasenia;

    @NotEmpty
    protected Integer dni;

    @NotEmpty
    protected Integer telefono;
   /* @NotEmpty
    protected Imagen imagen;  
    */
    protected Boolean alta;
    
    @NotNull
    protected Rol rol;
}

