package com.salud.sistema.servicios;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Profesional;
<<<<<<< HEAD
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.excepciones.ProfesionalException;
import com.salud.sistema.repositorios.ProfesionalRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.salud.sistema.entidades.Turno;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.Rol;

import com.salud.sistema.excepciones.MiExcepcion;

import com.salud.sistema.repositorios.ObraSocialRepositorio;

import com.salud.sistema.repositorios.ProfesionalRepositorio;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
<<<<<<< HEAD

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
=======
    @Autowired
    private ObraSocialRepositorio obraSocialRepositorio;


    @Transactional
    public Profesional crearProfesional(String nombre, String apellido, Integer dni, String email, Integer matricula, Integer telefono, Especialidad especialidad, String contrasenia) throws MiExcepcion {
        validar(nombre, apellido, email, dni, telefono, matricula, especialidad, contrasenia);
        Profesional medico = new Profesional();
        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setDni(dni);
        medico.setEmail(email);
        medico.setMatricula(matricula);
        medico.setTelefono(telefono);
        medico.setRol(Rol.PROFESIONAL);
        medico.setAlta(true);
        medico.setEspecialidad(especialidad);
        medico.setContrasenia(new BCryptPasswordEncoder().encode(contrasenia));
        profesionalRepositorio.save(medico);
        return medico;
    }


    //buscar profesionales segun especialidad
    public List<Profesional> buscarProfesionalPorEspecialidad(Especialidad especialidad, String obraSocial) throws MiExcepcion {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

        List<Profesional> profesionales = new ArrayList();
        try {
            if (obraSocial == null && especialidad != null) {
<<<<<<< HEAD
                profesionales = profesionalRepositorio.findByEspecialidad(especialidad);
=======
                profesionales = profesionalRepositorio.findByEspecialidadOrderByValorConsultaAsc(especialidad);
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
            }
            if (especialidad != null && obraSocial != null) {
                profesionales = profesionalRepositorio.findByCubreOSNombreOSAndEspecialidad(obraSocial, especialidad);
            }
<<<<<<< HEAD
            if(profesionales.isEmpty()){
                return null;
            }
        } catch (Exception e) {
            //throw new ProfesionalException("lo sentimos,ocurrio un error");
            e.getMessage();
        }
        
=======
            if (profesionales.isEmpty()) {
                return null;
            }
        } catch (Exception e) {
            throw new MiExcepcion("lo sentimos,ocurrio un error");

        }
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119

        return profesionales;

    }
<<<<<<< HEAD
=======

    @Transactional
    public String bajaProfesional(Long id) throws MiExcepcion {
        Profesional profesional = profesionalRepositorio.findFirstById(id);
        profesional.setAlta(Boolean.FALSE);
        profesionalRepositorio.save(profesional);

        return "el profesional fue dado de baja exitosamente";

    }

    public Profesional modificarProfesional(Long id, String descripcion, Long[] obraSocialId,
            float valorConsulta) throws MiExcepcion {
        Profesional profesional = profesionalRepositorio.findFirstById(id);

        profesional.setDescripcion(descripcion);
        List<ObraSocial> listaObraSocial = obraSocialRepositorio.findByIdIn(obraSocialId);

        profesional.setCubreOS(listaObraSocial);
        profesional.setValorConsulta(valorConsulta);
        profesionalRepositorio.save(profesional);

        return profesional;
    }

    private void validar(String nombre, String apellido, String email, Integer dni, Integer telefono, Integer matricula, Especialidad especialidad, String contrasenia) throws MiExcepcion {
        if (nombre.isEmpty()) {
            throw new MiExcepcion("El nombre no puede estar vacio ni ser nulo");
        } else if (nombre.length() < 3) {
            throw new MiExcepcion("El nombre no puede tener menos de 3 letras");
        }
        if (apellido.isEmpty()) {
            throw new MiExcepcion("El apellido no puede estar vacio ni ser nulo");
        } else if (apellido.length() < 3) {
            throw new MiExcepcion("El apellido no puede tener menos de 3 letras");
        }
        if (email.isEmpty()) {
            throw new MiExcepcion("El email no puede estar vacio ni ser nulo");
        }
        if (dni == null || dni < 1000000) {
            throw new MiExcepcion("Ingrese un número de dni válido");
        }
        if (telefono == null || telefono < 1000000000) {
            throw new MiExcepcion("Ingrese un número de teléfono válido");
        }
        if (matricula == null || matricula < 1000000) {
            throw new MiExcepcion("Ingrese un numero de matricula valido");
        }
        if (especialidad == null) {
            throw new MiExcepcion("Debe indicar su especialidad");
        }
        if (contrasenia.isEmpty() || contrasenia.length() <= 5) {
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
    }
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
}
