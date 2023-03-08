package com.salud.sistema.servicios;

import com.salud.sistema.entidades.HistoriaClinica;
import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.entidades.Paciente;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.repositorios.HistoriaClinicaRepositorio;
import com.salud.sistema.repositorios.ObraSocialRepositorio;
import com.salud.sistema.repositorios.PacienteRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio repoPaciente;
    @Autowired
    private ObraSocialRepositorio repoObraSocial;
    @Autowired
    private ObraSocialServicio servicioObraSocial;
    @Autowired
    private HistoriaClinicaRepositorio repoHistoriaClinica;
    @Autowired
    private HistoriaClinicaServicio servicioHC;

    @Transactional

    public void crearPaciente(String nombre, String apellido, String email,
            String contrasenia,String contrasenia2, Integer dni,
            Integer telefono, Long idObraSocial) throws MiExcepcion {

        validarDatos(nombre, apellido, email, contrasenia, contrasenia2, dni, telefono);

        Paciente paciente = new Paciente();

        HistoriaClinica historiaClinica = servicioHC.crearHistoriaClinica();

        ObraSocial obraSocial = servicioObraSocial.buscarPorId(idObraSocial);

        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setEmail(email);
        paciente.setContrasenia(contrasenia);
        paciente.setDni(dni);
        paciente.setTelefono(telefono);
        paciente.setHistoriaClinica(historiaClinica);
        paciente.setObraSocial(obraSocial);

        repoPaciente.save(paciente);
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList();
        pacientes = repoPaciente.findAll();
        return pacientes;
    }

    @Transactional

    public void modificarPaciente(Long id, String nombre, String apellido, String email, Integer telefono, Long idObraSocial) throws MiExcepcion {


        Paciente paciente = repoPaciente.findById(id).get();
        if (paciente == null) {
            throw new MiExcepcion("No se pudo encontrar el paciente");
        } else {
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setEmail(email);
            paciente.setTelefono(telefono);


            ObraSocial obraSocial = repoObraSocial.findById(idObraSocial).get();

            paciente.setObraSocial(obraSocial);

   
           // ObraSocial obraSocial = repoObraSocial.findById(idObraSocial).get();
           // paciente.setObraSocial(obraSocial);
            

            repoPaciente.save(paciente);
        }
    }

    public Paciente getOne(Long id) {
        return repoPaciente.getOne(id);
    }

    @Transactional
    public void borrarPaciente(Long id) throws MiExcepcion {
        Paciente paciente = repoPaciente.getById(id);
        paciente.setAlta(Boolean.FALSE);
        repoPaciente.save(paciente);
    }


    private void validarDatos(String nombre, String apellido, String email, String contrasenia,
            String contrasenia2, Integer dni, Integer telefono) throws MiExcepcion {


    

        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("El nombre no puede estar vacio ni ser nulo");
        } else if (nombre.length() < 3) {
            throw new MiExcepcion("El nombre no puede tener menos de 3 letras");
        }



        if (apellido.isEmpty() || apellido == null) {
            throw new MiExcepcion("El apellido no puede estar vacio ni ser nulo");
        } else if (apellido.length() < 3) {
            throw new MiExcepcion("El apellido no puede tener menos de 3 letras");
        }


        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("El email no puede estar vacio ni ser nulo");
        }

        if (contrasenia.isEmpty() || contrasenia == null || contrasenia.length() <= 5) {
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!contrasenia.equals(contrasenia2)) {
            throw new MiExcepcion("Las contraseñas ingresadas deben ser iguales");
        }

        if (dni == null || dni < 10000000 || dni > 100000000) {
            throw new MiExcepcion("Ingrese un número de dni válido");
        }

        if (telefono == null || telefono < 1000000000 || telefono.toString().length() > 11) {

        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("El email no puede estar vacio ni ser nulo");
        }
        if(dni == null || dni < 1000000) {
            throw new MiExcepcion("Ingrese un número de dni válido");
        }
        if(telefono == null || telefono < 1000000000) {

            throw new MiExcepcion("Ingrese un número de teléfono válido");
        }
    }
    }
}
