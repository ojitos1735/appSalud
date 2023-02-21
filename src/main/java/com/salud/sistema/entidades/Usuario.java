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
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;
import lombok.Data;
@Entity
@Data
//Con esto hago un join sin necesidad de generar ids en las entidades profesionales y pacientes,directamente cuando instancio 
//un objeto profesional o pacientes,seteo sus atributos(nombre apellid,etc)y a la hora de hacer un save se me genera un id que correspondera al objeto seteado
@Inheritance(strategy= InheritanceType.JOINED)
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    protected Rol rol;
}
