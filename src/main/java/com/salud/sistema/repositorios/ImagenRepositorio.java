
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen,Long> {
    
    
    
    
}
