/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import AccesoDatos.*;
import Entidades.Excepciones.*;
import Entidades.*;



/**
 *
 * @author Usuario
 */
public class LoginNegocio {
    private final ILoginData loginData;

    public LoginNegocio() {
        this.loginData = new LoginData();
    }
    public Boolean Validar (Login login) throws LoginExcepcion, Exception{
    return loginData.Validar(login);
    }
}
