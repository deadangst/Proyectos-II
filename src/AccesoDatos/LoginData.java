/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Login;

/**
 *
 * @author Usuario
 */
public class LoginData implements ILoginData {

    private Login mapearLineaLogin(String listaLinea) {
        Login login = new Login();
        String[] loginEncontrado = listaLinea.split(UtilidadesArchivos.TOKEN);
        login.setUsuario(loginEncontrado[0]);
        login.setPassword(loginEncontrado[1]);

        return login;
    }

    @Override
    public Boolean Validar(Login login) {

        try {

            String lineaLogin = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_LOGINTIENDA, login.getUsuario());
            Login loginBuscado = mapearLineaLogin(lineaLogin);
            if (loginBuscado.getPassword().equals(login.getPassword())) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }
}
