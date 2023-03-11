package com.salud.sistema.entidades;

import com.salud.sistema.enums.Rol;
import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Admin extends Usuario implements Serializable {

    public Admin() {
        super();
        rol = Rol.ADMIN;
        alta = true;
    }
}
