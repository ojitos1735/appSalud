package com.salud.sistema.entidades;

import java.util.List;

public class HistoriaClinica {

    private Long id;

    private Paciente paciente;

    private List<DetalleHC> detalles;

    private List<Profesional> profesionales;
}
