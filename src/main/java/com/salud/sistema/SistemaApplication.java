package com.salud.sistema;

import com.salud.sistema.entidades.ObraSocial;
import com.salud.sistema.enums.Especialidad;
import com.salud.sistema.enums.TipoConsulta;
import com.salud.sistema.servicios.ObraSocialServicio;
import com.salud.sistema.servicios.ProfesionalServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaApplication {

     @Autowired
     static ObraSocialServicio obraSocialServicio;
       
    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
        
        crearAlgo();
       
       
        
    }
    
    public static void crearAlgo(){
       
          List<ObraSocial> obrasSocialesAdmitidas = new ArrayList<>();
        
        ProfesionalServicio profesionalServicio = new ProfesionalServicio();
                
        
        System.out.println("Hola");
        
        obrasSocialesAdmitidas.add(obraSocialServicio.crear("Osep"));
        obrasSocialesAdmitidas.add(obraSocialServicio.crear("Meidfe"));
        obrasSocialesAdmitidas.add(obraSocialServicio.crear("OSDE"));
        
        
         profesionalServicio.crear("Sebastian", "Arce", "seba@hotmail", 1566566566, "123456", Especialidad.PEDIATRIA, 1235f, 123456, obrasSocialesAdmitidas, TipoConsulta.TELEMEDICINA);
    }
   
}
