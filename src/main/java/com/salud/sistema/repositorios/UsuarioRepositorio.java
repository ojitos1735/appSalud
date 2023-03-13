
package com.salud.sistema.repositorios;

//@author jmerc


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.salud.sistema.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
  /*  public void listarUsuarios();
    public void modificarUsuario();
    public void eliminarUsuario();
*/
}
