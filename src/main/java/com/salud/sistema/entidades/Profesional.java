package com.salud.sistema.entidades;

import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profesional extends Usuario {

    //  @Column(name= "Especialidad")
    private Especialidad especialidad;

    private Float valorConsulta;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "profesional_cubreos", joinColumns
            = @JoinColumn(name = "profesional_id"),
            inverseJoinColumns = @JoinColumn(name = "cubreos_id"))

    private List<ObraSocial> cubreOS;
    @Column(name = "Tipo_Consulta")
    private TipoConsulta tipoConsulta;

    private Integer matricula;

    private Double calificacion;

    private String descripcion;

    public Profesional() {
       
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Profesional(String nombre, String apellido, String email, String contrasenia, Integer dni, Integer telefono) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.telefono = telefono;
        this.alta = true;
    }

    public Profesional(Especialidad especialidad, Float valorConsulta, List<ObraSocial> cubreOS, TipoConsulta tipoConsulta, Integer matricula, Double calificacion, String descripcion) {
        this.especialidad = especialidad;
        this.valorConsulta = valorConsulta;
        this.cubreOS = cubreOS;
        this.tipoConsulta = tipoConsulta;
        this.matricula = matricula;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
    }

}
