package com.salud.sistema.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class ObraSocial {
@Id
    private Long id;

    private String nombreOS;
@ManyToMany(mappedBy="cubreOS")
private List<Profesional> profesionales;
}
