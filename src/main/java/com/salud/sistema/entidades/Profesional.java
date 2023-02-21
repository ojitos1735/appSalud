package com.salud.sistema.entidades;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;




@Entity
@Data
public class Profesional extends Usuario  {
 //  @Column(name= "Especialidad")
    private Especialidad especialidad;
  
    @ManyToOne

    private Horario horarios;

   
    private Float valorConsulta;

    @Column(name= "Tipo_Consulta")
    private TipoConsulta tipoConsulta;
    
  @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="profesional_cubreos",joinColumns=
    @JoinColumn(name="profesional_id"),
    inverseJoinColumns=@JoinColumn(name="cubreos_id"))
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
