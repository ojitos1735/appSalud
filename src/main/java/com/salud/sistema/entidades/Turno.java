package com.salud.sistema.entidades;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Turno {
=======
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.EstadoTurno;
import com.salud.sistema.enums.TipoConsulta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Turno {

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @OneToOne
    private Paciente paciente;

    @OneToOne
    private Profesional profesional;

    @OneToOne
    private Horario horario;

=======
    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Profesional profesional;

    private Dia dia;

    private LocalTime horainicio;

    private LocalTime horaFin;

    @Column(name = "Tipo_Consulta")
    private TipoConsulta tipoConsulta;

    private boolean disponibilidad;

    private EstadoTurno estadoTurno;
<<<<<<< HEAD
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
=======
    
    private Double puntaje;
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
}
