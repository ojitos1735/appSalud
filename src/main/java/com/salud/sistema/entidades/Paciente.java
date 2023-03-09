package com.salud.sistema.entidades;

import com.salud.sistema.enums.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "Paciente")
public class Paciente extends Usuario implements Serializable {

    @OneToOne
    private HistoriaClinica historiaClinica;
    
    @OneToOne
    private ObraSocial obraSocial;
    /*
    @OneToMany
    private List<Profesional> profesionales;
*/
    public Paciente(){
        super();
        rol = Rol.PACIENTE;
        alta = true;
    }
    
    public Paciente(String nombre, String apellido, String email, String contrasenia, Integer dni, Integer telefono){
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
<<<<<<< HEAD
        this.contrasenia = contrasenia;
=======
        //this.contrasenia = contrasenia;
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        this.dni = dni;
        this.telefono = telefono;
        this.alta = true;
    }
    
}
