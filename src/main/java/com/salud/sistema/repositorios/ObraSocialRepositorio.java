
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepositorio extends JpaRepository<ObraSocial, Long>{

    @Query("SELECT o FROM ObraSocial o WHERE o.nombreOS = :nombre")
    public ObraSocial buscarPorNombre(@Param("nombre") String nombre);
    
}
