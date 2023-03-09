package com.salud.sistema.entidades;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "ObraSocial")
public class ObraSocial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @NotEmpty
    private String nombreOS;
=======

    //@NotEmpty
     private String nombreOS;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cubreOS")
    private Set<Profesional> profesionales;

    @Override
    public String toString() {
        return "ObraSocial{" + "id=" + id + ", nombreOS=" + nombreOS + '}';
    }

}
