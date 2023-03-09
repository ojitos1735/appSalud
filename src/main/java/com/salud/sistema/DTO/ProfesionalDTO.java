/*
package com.salud.sistema.DTO;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Data;

@Data
public class ProfesionalDTO {
  
    private float valorConsulta;
    private Especialidad especialidad;
    private List<ObraSocial> obraSocial;
    private LocalDate dia;
    private LocalTime hora;
    private TipoConsulta tipoConsulta;

    public ProfesionalDTO(Profesional profesional, Turno turno) {
        this.valorConsulta= profesional.getValorConsulta();
        this.especialidad= profesional.getEspecialidad();
        this.obraSocial= profesional.getCubreOS();
        this.dia= turno.getDia();
        this.hora= turno.getHora();
        this.tipoConsulta= turno.getTipoConsulta();
    }

    public ProfesionalDTO() {
    }
    
}
*/