package com.salud.sistema.entidades;

import com.salud.sistema.enums.Rol;
<<<<<<< HEAD
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

public class Admin extends Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

   
    public Admin() {
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Rol getRol() {
        return rol;
    }

    @Override
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    }
=======
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Admin extends Usuario implements Serializable {

    public Admin() {
        super();
        rol = Rol.ADMIN;
    }
}
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
