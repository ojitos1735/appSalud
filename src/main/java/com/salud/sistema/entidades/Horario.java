/*package com.salud.sistema.entidades;


import com.salud.sistema.enums.Dia;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
@Data
@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Dia dias;

    private LocalTime horarioInicio;
    
    private LocalTime horarioFin;
    
    private Boolean disponible;
    
    @OneToOne
    private Profesional profesional;
    
}
*/