/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.Paciente;
import com.salud.sistema.repositorios.PacienteRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio repoPaciente;

    @Transactional
    public void crearPaciente(String nombre, String email) {
        Paciente paciente = new Paciente();
        paciente.setEmail(email);
        paciente.setNombre(nombre);

        repoPaciente.save(paciente);
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarAutores() {
        List<Paciente> pacientes = new ArrayList();
        pacientes = repoPaciente.findAll();
        return pacientes;
    }
}
