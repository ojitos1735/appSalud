
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {
    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    
    @Transactional
    public void crear(
    String nombre,
    String apellido,
    String email,
    Integer telefono,
    String constrasenia,
    Especialidad especialidad,
    Float valorConsulta,
    Integer matricula,
    List<ObraSocial> obrasSocialesAdmitidas,
    TipoConsulta tipoConsulta
    ){
        Profesional profesional = new Profesional();
        profesional.setNombre(nombre);
        profesional.setApellido(apellido);
        profesional.setEmail(email);
        profesional.setTelefono(telefono);
        profesional.setContrasenia(constrasenia);
        profesional.setEspecialidad(especialidad);
        profesional.setValorConsulta(valorConsulta);
        profesional.setMatricula(matricula);
        profesional.setTipoConsulta(tipoConsulta);
        profesional.setRol(Rol.PROFESIONAL);
        profesional.setAlta(Boolean.TRUE);
        
        profesionalRepositorio.save(profesional);
    }
}
