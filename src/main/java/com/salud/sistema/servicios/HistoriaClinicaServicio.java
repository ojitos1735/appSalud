/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.HistoriaClinica;
import com.salud.sistema.repositorios.HistoriaClinicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaClinicaServicio {
    @Autowired
    private HistoriaClinicaRepositorio repoHistoriaClinica;
    
    public HistoriaClinica crearHistoriaClinica(){
        HistoriaClinica historia = new HistoriaClinica();
        repoHistoriaClinica.save(historia);
        return historia;
    }
}
