/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gusta
 */
public interface ObraSocialRepository extends JpaRepository<ObraSocial,Long>{
    ObraSocial  findById(int id);

}
