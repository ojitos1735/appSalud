package com.salud.sistema.entidades;


import com.salud.sistema.enums.Rol;
import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Table(name = "usuario") 
@MappedSuperclass
public abstract class Usuario implements Serializable {
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

    /*@OneToOne
    protected Imagen imagen;*/ //Hay que agregar imagen

    @NotEmpty
    protected Boolean alta;

    @Enumerated(EnumType.STRING)
    protected Rol rol;
}