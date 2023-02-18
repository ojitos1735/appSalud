
package com.salud.sistema.servicios;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.repositorios.ObraSocialRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraSocialServicio {
    
    @Autowired
    private ObraSocialRepositorio obraSocialRepositorio;
    
    @Transactional
    public ObraSocial crear (String nombre){
        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre(nombre);
        
        obraSocialRepositorio.save(obraSocial); //Persitir en la base de datos
        return obraSocial;
    }
}
