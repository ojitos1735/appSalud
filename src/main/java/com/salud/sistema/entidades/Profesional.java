package com.salud.sistema.entidades;


import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profesional extends Usuario {
    //  @Column(name= "Especialidad")
    private Especialidad especialidad;

    private Float valorConsulta;

    @Column(name = "Tipo_Consulta")
    private TipoConsulta tipoConsulta;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "profesional_cubreos", joinColumns
            = @JoinColumn(name = "profesional_id"),
            inverseJoinColumns = @JoinColumn(name = "cubreos_id"))
    private Set<ObraSocial> cubreOS;

    private Integer matricula;

    private Double calificacion;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

}
