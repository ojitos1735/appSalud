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

    @NotEmpty
    private String nombreOS;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cubreOS")
    private Set<Profesional> profesionales;

    @Override
    public String toString() {
        return "ObraSocial{" + "id=" + id + ", nombreOS=" + nombreOS + '}';
    }

}
