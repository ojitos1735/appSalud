package com.salud.sistema.entidades;


import com.salud.sistema.enums.Dia;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Horario {

    @Id
    private Long id;

    private Dia dias;

    private Date horario;

    private Boolean disponible;
}
