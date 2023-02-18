package com.salud.sistema.entidades;


import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "profesional")
public class Profesional extends Usuario {
    
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    /*@NotEmpty
    private Horario horarios;*/ //Hay que colocar los horarios necesesarios de este doctor

    @NotEmpty
    private Float valorConsulta;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    @NotEmpty
    @OneToMany
    private List<ObraSocial> obrasSocialesAdmitidas;

    @NotEmpty
    private Integer matricula;

    private Double calificacion;
}
