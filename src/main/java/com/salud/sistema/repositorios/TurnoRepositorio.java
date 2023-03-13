/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.repositorios;


import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Dia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gusta
 */
@Repository
public interface TurnoRepositorio extends JpaRepository<Turno,Long> {
    
      public  Turno findFirstById(long id);
        
    
    public List<Turno> findByProfesionalId(long profesionalId);
    
    public List<Turno> findByProfesionalIdAndDia(long profesionalId,Dia dia);
    
     public List<Turno> findByPacienteId(long pacienteId);
    
     
     public List<Turno> findByProfesionalIdAndPuntajeIsNotNull(long profesionalId);
}
