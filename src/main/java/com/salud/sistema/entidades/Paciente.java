package com.salud.sistema.entidades;

import com.salud.sistema.enums.Rol;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "paciente")
public final class Paciente extends Usuario {

    @NotEmpty
    private HistoriaClinica historiaClinica;
    
    @NotEmpty
    private ObraSocial obraSocial;
    
    @NotEmpty
    private List<Profesional> profesionales;
    
    public Paciente(){
        super();
        rol = Rol.PACIENTE;
    }
    
}
