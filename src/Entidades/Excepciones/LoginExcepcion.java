/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.Excepciones;

/**
 *
 * @author Usuario
 */
public class LoginExcepcion  extends Exception{
    public LoginExcepcion(String mensaje){
    super(mensaje);
    }
}
