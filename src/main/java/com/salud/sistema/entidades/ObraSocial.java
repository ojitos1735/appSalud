package com.salud.sistema.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity

public class ObraSocial {
@Id
    private Long id;

    private String nombreOS;
@ManyToMany(fetch = FetchType.LAZY,mappedBy="cubreOS")
private Set<Profesional> profesionales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreOS() {
        return nombreOS;
    }

    public void setNombreOS(String nombreOS) {
        this.nombreOS = nombreOS;
    }



    @Override
    public String toString() {
        return "ObraSocial{" + "id=" + id + ", nombreOS=" + nombreOS +  '}';
    }


}
