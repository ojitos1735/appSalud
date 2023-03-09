<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long>{
    //Busca los pacientes por nombre
    @Query("SELECT p FROM Paciente p WHERE p.nombre = :nombre")
    public Paciente buscarPorNombre(@Param("nombre") String nombre);
    
    //Busca los pacientes por email
    @Query("SELECT p FROM Paciente p WHERE p.email = :email")
    public Paciente buscarPorEmail(@Param("email") String email);

}
