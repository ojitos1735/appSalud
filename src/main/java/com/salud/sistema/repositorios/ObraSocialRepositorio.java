
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepositorio extends JpaRepository<ObraSocial, Long> {
    
}
