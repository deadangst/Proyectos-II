/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.UsuariosExcepciones;
import Entidades.Usuarios;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUsuariosData {

    String insertar(Usuarios usuarios) throws UsuariosExcepciones, Exception;

    String eliminar(Usuarios usuarios) throws UsuariosExcepciones, Exception;

    String actualizar(Usuarios usuarios) throws UsuariosExcepciones, Exception;

    Usuarios consultar(String usuarios) throws UsuariosExcepciones, Exception;

    List<Usuarios> consultarTodosLosUsuarios() throws UsuariosExcepciones, Exception;

    Usuarios consultarUsuarios(Usuarios usuarios) throws UsuariosExcepciones, Exception;
}
