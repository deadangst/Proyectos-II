/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.*;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ITipoUsuarioData {

    Boolean Validar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception;

    String Ingresar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception;

    String actualizar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception;

    String eliminar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception;

    TipoUsuario consultar(String tpUsuario) throws TipoUsuarioExcepcion, Exception;

    List<TipoUsuario> consultarTodosLosTipoUsuario() throws TipoUsuarioExcepcion, Exception;

    TipoUsuario consultarTpUsuario(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception;
    
}
