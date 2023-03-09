
package com.salud.sistema.repositorios;

//@author jmerc

import com.salud.sistema.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
   /* public void crearUsuario();
    public void listarUsuarios();
    public void modificarUsuario();
    public void eliminarUsuario();
*/
}
