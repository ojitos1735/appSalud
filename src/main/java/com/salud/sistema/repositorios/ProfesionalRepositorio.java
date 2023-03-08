
package com.salud.sistema.repositorios;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesionalRepositorio extends JpaRepository<Profesional,Long> {
//query nativa para buscar profesional segun especialidad
 // @Query("SELECT p FROM  Profesional p WHERE p.especialidad = :especialidad")
 //   public List<Profesional> buscarPorEspecialidad(@Param("especialidad")String especialidad);
    
    //query jpa para buscar profesional segun especialidad con findby
    public List<Profesional> findByEspecialidad(Especialidad especialidad);
     
     //query que busca profesionales segun obra social y especialidad
    //@Query("SELECT p FROM Profesional p JOIN p.cubreOS os WHERE os.nombreOS = :obraSocial AND p.especialidad= :especialidad")
   // public List<Profesional> buscarPorObraSocialYEspecialidad(@Param("obraSocial")String obraSocial,@Param("especialidad")Especialidad especialidad);
    
    
    
    //query jpa que busca profesionales segun obra social y especialidad
  public List<Profesional>findByCubreOSNombreOSAndEspecialidad(String obrasocial,Especialidad especialidad);
    
  //query jpa para buscar profesional segun nombre
  public List<Profesional>findByNombreLike(String nombre);
  
  
  //query para buscar profesional segun nombre
  @Query("SELECT p FROM  Profesional p WHERE p.nombre = :nombre")
   public List<Profesional> buscarPorNombre(@Param("nombre")String nombre);
   
   @Query("SELECT p FROM Profesional p WHERE p.email = :email")
    public Profesional buscarPorEmail(@Param("email") String email);
}
