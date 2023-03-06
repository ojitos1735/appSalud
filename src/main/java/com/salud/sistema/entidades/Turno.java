package com.salud.sistema.entidades;
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.EstadoTurno;
import com.salud.sistema.enums.TipoConsulta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.ManyToOne;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Profesional profesional;
    
    private Dia dia;
    
     private LocalTime horainicio;
     
     private LocalTime horaFin;
   
     @Column(name= "Tipo_Consulta")
    private TipoConsulta tipoConsulta;
     
     
    private boolean disponibilidad;
     
    private EstadoTurno estadoTurno;
    
    
}
