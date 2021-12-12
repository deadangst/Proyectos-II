/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.*;
import Entidades.*;

/**
 *
 * @author Usuario
 */
public interface ILoginData {
    Boolean Validar(Usuarios login) throws LoginExcepcion, Exception;
    Usuarios consultar(String user) throws LoginExcepcion, Exception;

}
