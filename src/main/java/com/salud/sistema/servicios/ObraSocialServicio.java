
package com.salud.sistema.servicios;
import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.excepciones.MiExcepcion;
import com.salud.sistema.repositorios.ObraSocialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraSocialServicio {
    @Autowired
    private ObraSocialRepositorio repoObraSocial;
    
    @Transactional
    public void crearObraSocial(String nombre) throws MiExcepcion{
        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombreOS(nombre);
        
        repoObraSocial.save(obraSocial);
    }
    
    @Transactional(readOnly = true)
    public List<ObraSocial> listarObrasSociales(){
        List<ObraSocial> obrasSociales = new ArrayList();
        obrasSociales = repoObraSocial.findAll();
        return obrasSociales;
    }
    
    public ObraSocial buscarPorId (Long id){
        Optional<ObraSocial> respuesta = repoObraSocial.findById(id);
        if(respuesta.isPresent()){
            return respuesta.get();
        } else {
            return null;
        }
    }

}
