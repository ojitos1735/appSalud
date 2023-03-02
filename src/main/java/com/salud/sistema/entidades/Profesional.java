package com.salud.sistema.entidades;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;




@Entity
@Data
public class Profesional extends Usuario  {
 //  @Column(name= "Especialidad")
    private Especialidad especialidad;
  
   
    
    private Float valorConsulta;

  @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="profesional_cubreos",joinColumns=
    @JoinColumn(name="profesional_id"),
    inverseJoinColumns=@JoinColumn(name="cubreos_id"))
    private List<ObraSocial> cubreOS;

    private Integer matricula;

    private Double calificacion;
    
    private String descripcion;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

   public Profesional(String nombre, String apellido, String email, String contrasenia, Integer dni, Integer telefono){
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        //this.contrasenia = contrasenia;
        this.dni = dni;
        this.telefono = telefono;
        this.alta = true;
    }

    public Profesional() {
    }
   


}
