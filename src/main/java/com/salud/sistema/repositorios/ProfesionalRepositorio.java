
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepositorio extends JpaRepository<Profesional, Long> {
    
}
