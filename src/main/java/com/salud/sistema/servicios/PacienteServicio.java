<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
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
<<<<<<< HEAD
    
    @Transactional
    public void crearPaciente(String nombre, String apellido, String email, /*String contrasenia,*/ Integer dni, Integer telefono, Long idObraSocial) throws MiExcepcion {
        validarDatos(nombre, apellido, email, dni, telefono);
=======

    @Transactional

    public void crearPaciente(String nombre, String apellido, String email,
            String contrasenia,String contrasenia2, Integer dni,
            Integer telefono, Long idObraSocial) throws MiExcepcion {

        validarDatos(nombre, apellido, email, contrasenia, contrasenia2, dni, telefono);

<<<<<<< HEAD
 
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
=======
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
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
    public void modificarPaciente(Long id, String nombre, String apellido, String email, Integer telefono/*, Long idObraSocial*/) throws MiExcepcion{

        Paciente paciente = repoPaciente.findById(id).get();
<<<<<<< HEAD
        if (paciente == null){
            throw new MiExcepcion("No se pudo encontrar el paciente");
        } else{
=======
        if (paciente == null) {
            throw new MiExcepcion("No se pudo encontrar el paciente");
        } else {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setEmail(email);
            paciente.setTelefono(telefono);
           
<<<<<<< HEAD
           // ObraSocial obraSocial = repoObraSocial.findById(idObraSocial).get();
           // paciente.setObraSocial(obraSocial);
            
            repoPaciente.save(paciente);
        }
    }
    
    public Paciente getOne(Long id){
=======
            //ObraSocial obraSocial = repoObraSocial.findById(idObraSocial).get();
            //paciente.setObraSocial(obraSocial);
            

            repoPaciente.save(paciente);
        }
    }

    public Paciente getOne(Long id) {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        return repoPaciente.getOne(id);
    }

    @Transactional
<<<<<<< HEAD
    public void borrarPaciente(Long id) throws MiExcepcion{
=======
    public void borrarPaciente(Long id) throws MiExcepcion {
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        Paciente paciente = repoPaciente.getById(id);
        paciente.setAlta(Boolean.FALSE);
        repoPaciente.save(paciente);
    }
<<<<<<< HEAD
    
    private void validarDatos(String nombre, String apellido, String email, Integer dni, Integer telefono) throws MiExcepcion {
=======


    private void validarDatos(String nombre, String apellido, String email, String contrasenia,
            String contrasenia2, Integer dni, Integer telefono) throws MiExcepcion {


    

>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("El nombre no puede estar vacio ni ser nulo");
        } else if (nombre.length() < 3) {
            throw new MiExcepcion("El nombre no puede tener menos de 3 letras");
        }
<<<<<<< HEAD
=======



>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        if (apellido.isEmpty() || apellido == null) {
            throw new MiExcepcion("El apellido no puede estar vacio ni ser nulo");
        } else if (apellido.length() < 3) {
            throw new MiExcepcion("El apellido no puede tener menos de 3 letras");
        }
<<<<<<< HEAD
        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("El email no puede estar vacio ni ser nulo");
        }
        if(dni == null || dni < 1000000) {
            throw new MiExcepcion("Ingrese un número de dni válido");
        }
=======


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
        
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
        if(telefono == null || telefono < 1000000000) {
            throw new MiExcepcion("Ingrese un número de teléfono válido");
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
}
=======

    }
}
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
=======
    }
>>>>>>> 6d43cf9c990a78d865ca2a56aaf185c8eca189d1
