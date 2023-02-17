package com.salud.sistema.entidades;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ObraSocial {

    private Long id;

    private String nombreOS;
}
