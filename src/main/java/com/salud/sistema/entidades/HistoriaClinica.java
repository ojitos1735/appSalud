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
<<<<<<< HEAD
=======


>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import lombok.Data;

@Data
@Entity
@Table (name = "HistoriaClinica")
public class HistoriaClinica implements Serializable {
<<<<<<< HEAD
=======

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Paciente paciente;

<<<<<<< HEAD
=======
   // private List<DetalleHC> detalles;
    //habra un profesional de cabecera en la historia clinica lo cual en el detalles otros profesionales iran agregando informacion.

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    @OneToMany
    private List<DetalleHC> detalles;
    
    @OneToMany
<<<<<<< HEAD
=======

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
    private List<Profesional> profesionales;
    
}
