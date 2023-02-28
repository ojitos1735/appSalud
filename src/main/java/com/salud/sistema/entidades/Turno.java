package com.salud.sistema.entidades;
import com.salud.sistema.enums.Dia;
import com.salud.sistema.enums.TipoConsulta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Profesional profesional;
    
    private LocalDate dia;
    
     private LocalTime hora;
   
     @Column(name= "Tipo_Consulta")
    private TipoConsulta tipoConsulta;

}