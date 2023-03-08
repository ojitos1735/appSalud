
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


    /* @Query("SELECT h FROM HistoriaClinica h WHERE h.paciente.dni = :dni")
    public Paciente buscarPorPaciente (@Param ("dni") Integer dni);
     */
}