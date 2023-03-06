package com.salud.sistema.entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table (name = "HistoriaClinica")
public class HistoriaClinica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Paciente paciente;

   // private List<DetalleHC> detalles;
    //habra un profesional de cabecera en la historia clinica lo cual en el detalles otros profesionales iran agregando informacion.

    @OneToMany
    private List<DetalleHC> detalles;
    
    @OneToMany

    private List<Profesional> profesionales;
    
}
