/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.LoginExcepcion;
//import Entidades.;
import Entidades.Usuarios;

/**
 *
 * @author Usuario
 */
public class LoginData implements ILoginData {

    private Usuarios mapearLineaLogin(String listaLinea) {
        Usuarios login = new Usuarios();
        String[] loginEncontrado = listaLinea.split(UtilidadesArchivos.TOKEN);
        login.setUsuario(loginEncontrado[6]);
        login.setPassword(loginEncontrado[7]);

        return login;
    }   
    public Boolean Validar(Usuarios login) {
        try {
            String lineaLogin = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, login.getUsuario());
            Usuarios loginBuscado = mapearLineaLogin(lineaLogin);
            if (loginBuscado.getPassword().equals(login.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
 @Override
    public Usuarios consultar(String user) throws LoginExcepcion, Exception {
        try {
            String lineaLogin = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, user);
            return mapeaLineaLogin(lineaLogin);
        } catch (Exception e) {

        }
        return null;
    }

    private Usuarios mapeaLineaLogin(String lineaLinea) {
        Usuarios login = new Usuarios();
        String[] datosLogin = lineaLinea.split(UtilidadesArchivos.TOKEN);        
        login.setNombre(datosLogin[0]);
        login.setTipoUsuario(datosLogin[4]);
        login.setUsuario(datosLogin[6]);
        return login;
    }

}
