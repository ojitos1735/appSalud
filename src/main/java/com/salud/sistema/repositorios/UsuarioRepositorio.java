
package com.salud.sistema.repositorios;

<<<<<<< HEAD
import com.salud.sistema.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.email = :email", nativeQuery = true)
    public Usuario buscarPorEmail(@Param("email")String email);
=======
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
>>>>>>> 3a9e5b14044bf48198cd917d55b2f11cccfac119
}
