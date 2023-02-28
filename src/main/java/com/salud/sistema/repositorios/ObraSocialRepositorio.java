
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ObraSocialRepositorio extends JpaRepository<ObraSocial,Long>{
    ObraSocial  findById(int id);

    @Query("SELECT o FROM ObraSocial o WHERE o.nombreOS = :nombre")
    public ObraSocial buscarPorNombre(@Param("nombre") String nombre);
    
    
    
    public List<ObraSocial> findByIdIn(Long[] obraSocialId);
    
    
}
