package com.salud.sistema.entidades;


import com.salud.sistema.enums.Dia;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Dia dias;

    private Date horario;

    private Boolean disponible;

}
