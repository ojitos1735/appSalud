package com.salud.sistema.entidades;



import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
public class Profesional extends Usuario  {
   @Column(name= "Especialidad")
    private Especialidad especialidad;
    @ManyToOne
    private Horario horarios;

   
    private Float valorConsulta;

    @Column(name= "Tipo_Consulta")
    private TipoConsulta tipoConsulta;
    
    @ManyToMany
    //esto generara una tabla intermedia en la cual tendra el nombre que se observa en el jointable
    @JoinTable(name="profesional_cubreos",joinColumns=
    @JoinColumn(name="profesioanl_id"),
    inverseJoinColumns=@JoinColumn(name="cubreos_id"))
            
    private List<ObraSocial> cubreOS;

    private Integer matricula;

    private Double calificacion;
   

    public Horario getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario horarios) {
        this.horarios = horarios;
    }

    public Float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public List<ObraSocial> getCubreOS() {
        return cubreOS;
    }

    public void setCubreOS(List<ObraSocial> cubreOS) {
        this.cubreOS = cubreOS;
    }



    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
     public Especialidad getEspecialidad() {
        return especialidad;
    }

    
}
