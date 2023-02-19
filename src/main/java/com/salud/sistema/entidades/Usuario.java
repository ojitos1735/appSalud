package com.salud.sistema.entidades;


import com.salud.sistema.enums.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
@Inheritance(strategy= InheritanceType.JOINED)
public class Usuario {
@Id
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String contrasenia;

    private Integer dni;

    private Integer telefono;
   @OneToOne
    private Imagen imagen;

    private Boolean alta;

    private Rol rol;
}
