package com.salud.sistema.entidades;
<<<<<<< HEAD
=======
import javax.persistence.Entity;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import lombok.Data;


@Entity
@Data
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String titulo;

    private String textoAlter;

}
