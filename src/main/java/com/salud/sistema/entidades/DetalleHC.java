package com.salud.sistema.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class DetalleHC {

    private Long id;

    private Date fecha;

    private String descripcion;

    private List<Profesional> profesionales;
}
