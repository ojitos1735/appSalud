package com.salud.sistema.entidades;


import com.salud.sistema.enums.Rol;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class Usuario {
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

    @NotEmpty
    protected Imagen imagen;

    @NotEmpty
    protected Boolean alta;

    @NotEmpty
    protected Rol rol;
}
