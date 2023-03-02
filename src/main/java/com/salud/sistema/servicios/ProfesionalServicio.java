package com.salud.sistema.servicios;




import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;

import com.salud.sistema.excepciones.MiExcepcion;

import com.salud.sistema.repositorios.ObraSocialRepositorio;


import com.salud.sistema.repositorios.ProfesionalRepositorio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    @Autowired
    private ObraSocialRepositorio obraSocialRepositorio;
    

  
    @Transactional
    public Profesional crearProfesional(Profesional profesional){
    
            
    Profesional medico = new Profesional();
    medico.setNombre(profesional.getNombre());
    medico.setApellido(profesional.getApellido());
    medico.setDni(profesional.getDni());
    medico.setEmail(profesional.getEmail());
    medico.setMatricula(profesional.getMatricula());
    medico.setTelefono(profesional.getTelefono());
    medico.setRol(Rol.PROFESIONAL);
    medico.setAlta(true);
    medico.setEspecialidad(profesional.getEspecialidad());
   // medico.setContrasenia(new BCryptPasswordEncoder().encode(Contrasenia));
    profesionalRepositorio.save(medico);
    return medico;
    }

  
    //buscar profesionales segun especialidad
    public List<Profesional> buscarProfesionalPorEspecialidad(Especialidad especialidad, String obraSocial) throws MiExcepcion  {

        List<Profesional> profesionales = new ArrayList();
        try {
            if (obraSocial == null && especialidad != null) {
                profesionales = profesionalRepositorio.findByEspecialidad(especialidad);
            }
            if (especialidad != null && obraSocial != null) {
                profesionales = profesionalRepositorio.findByCubreOSNombreOSAndEspecialidad(obraSocial, especialidad);
            }
            if(profesionales.isEmpty()){
                return null;
            }
        } catch (Exception e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");
           
        }
        

        return profesionales;

    }
    @Transactional
    public String bajaProfesional(Long id)throws MiExcepcion{
        Profesional profesional = profesionalRepositorio.findFirstById(id);
        profesional.setAlta(Boolean.FALSE);
        profesionalRepositorio.save(profesional);
        
        return "el profesional fue dado de baja exitosamente";
        
    }
    
    public Profesional modificarProfesional(Long id,String descripcion,Long[]obraSocialId,
            float valorConsulta)throws MiExcepcion{
        Profesional profesional = profesionalRepositorio.findFirstById(id);
       
        
        profesional.setDescripcion(descripcion);
        List<ObraSocial> listaObraSocial = obraSocialRepositorio.findByIdIn(obraSocialId);    
        if (!listaObraSocial.isEmpty()){
            profesional.setCubreOS(listaObraSocial);
        }else{
            profesional.setValorConsulta(valorConsulta);
        }
       
         
         profesionalRepositorio.save(profesional);


        return profesional;
    }
    
  
}
/*if (contrasenia.isEmpty() || contrasenia == null || contrasenia.length() <= 5) {
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
*/