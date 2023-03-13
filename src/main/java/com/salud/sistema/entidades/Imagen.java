package com.salud.sistema.entidades;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import javax.persistence.Entity;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

=======


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import lombok.Data;


@Entity
@Data
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

=======
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;

@Entity
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
public class Imagen {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String mime;
    
    private String nombre;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;

    public Imagen() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
    
}