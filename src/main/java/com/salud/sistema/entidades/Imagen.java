package com.salud.sistema.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Imagen {
@Id
    private Long id;

    private String titulo;

    private String textoAlter;
}
