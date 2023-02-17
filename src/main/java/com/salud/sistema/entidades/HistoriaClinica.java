package com.salud.sistema.entidades;

import java.util.List;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class HistoriaClinica {

    private Long id;

    private Paciente paciente;

    private List<DetalleHC> detalles;

    private List<Profesional> profesionales;
}
