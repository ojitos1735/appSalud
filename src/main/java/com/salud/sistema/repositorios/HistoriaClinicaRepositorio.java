<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.HistoriaClinica;
import com.salud.sistema.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepositorio extends JpaRepository<HistoriaClinica, Long> {
    //Busca las historias clinicas por paciente
<<<<<<< HEAD
   /* @Query("SELECT h FROM HistoriaClinica h WHERE h.paciente.dni = :dni")
    public Paciente buscarPorPaciente (@Param ("dni") Integer dni);
*/
}
=======


    /* @Query("SELECT h FROM HistoriaClinica h WHERE h.paciente.dni = :dni")
    public Paciente buscarPorPaciente (@Param ("dni") Integer dni);
     */
}
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
