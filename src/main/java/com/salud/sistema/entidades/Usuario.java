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
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@MappedSuperclass
@Data


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

    protected String contrasenia;
    
    protected Integer dni;

    protected Integer telefono;
    
    @OneToOne
    @JoinColumn(name = "imagen_id")
    protected Imagen imagen;    
 
    // @NotNull
    protected Boolean alta;

    protected Rol rol;
}