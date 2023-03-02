/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.repositorios;


import com.salud.sistema.entidades.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gusta
 */
public interface TurnoRepositorio extends JpaRepository<Turno,Long> {
    
}
