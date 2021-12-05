/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

/**
 *
 * @author Usuario
 */
public class Persona {
      private String nombres;
    private String apellido;
    private String identificacion;
    private String Password;
   

    public Persona() {
    }

    public Persona(String nombres, String apellido, String identificacion, String Password) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.Password = Password;
      
    }
    
    

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
