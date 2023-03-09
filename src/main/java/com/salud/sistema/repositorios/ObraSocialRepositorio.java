
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
<<<<<<< HEAD
=======

import java.util.List;

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepositorio extends JpaRepository<ObraSocial, Long>{

    @Query("SELECT o FROM ObraSocial o WHERE o.nombreOS = :nombre")
    public ObraSocial buscarPorNombre(@Param("nombre") String nombre);
    
<<<<<<< HEAD
=======

      
    
    public List<ObraSocial> findByIdIn(Long[] obraSocialId);
    

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
}
