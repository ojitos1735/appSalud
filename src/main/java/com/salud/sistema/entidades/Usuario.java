package com.salud.sistema.entidades;

<<<<<<< HEAD

import com.salud.sistema.enums.Rol;
=======
import com.salud.sistema.enums.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
<<<<<<< HEAD
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@MappedSuperclass
@Data


public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    protected Long id;

    //@NotEmpty
    protected String nombre;
<<<<<<< HEAD

   // @NotEmpty
=======
    // @NotEmpty
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    protected String apellido;

    //@NotEmpty
    //@Email
    protected String email;

<<<<<<< HEAD
<<<<<<< HEAD
    
    protected String contrasenia;
    

    protected Integer dni;

    protected Integer telefono;
/*
    @NotEmpty
    protected Imagen imagen;  
*/
   // @NotNull
=======

=======
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
    protected String contrasenia;
    
    protected Integer dni;

    protected Integer telefono;
    
    @OneToOne
    protected Imagen imagen;
    
     
//    private Imagen imagen;
//
//    public Imagen getImagen() {
//        return imagen;
//    }
//
//    public void setImagen(Imagen imagen) {
//        this.imagen = imagen;
//    }
 
    // @NotNull
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    protected Boolean alta;

    protected Rol rol;
<<<<<<< HEAD
}
<<<<<<< HEAD
=======

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
=======
}
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
