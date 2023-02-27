package com.salud.sistema.servicios;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.ProfesionalException;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

   /* @Transactional
    public void crear(
            String nombre,
            String apellido,
            String email,
            Integer telefono,
            String constrasenia,
            Especialidad especialidad,
            Float valorConsulta,
            Integer matricula,
            List<ObraSocial> cubreOS,
            TipoConsulta tipoConsulta
    ) {
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
    */

    //buscar profesionales segun especialidad
    public List<Profesional> buscarProfesionalPorEspecialidad(Especialidad especialidad, String obraSocial)  {

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
            //throw new ProfesionalException("lo sentimos,ocurrio un error");
            e.getMessage();
        }
        

        return profesionales;

    }
}
