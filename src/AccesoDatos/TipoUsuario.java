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
public class TipoUsuario extends Persona {
      private String cliente;
      private String administrador;
      private String Gerente;
      private String empleado;

    public TipoUsuario() {
    }

    public TipoUsuario(String cliente, String administrador, String Gerente, String empleado, String nombres, String apellido, String identificacion, String Password) {
        super(nombres, apellido, identificacion, Password);
        this.cliente = cliente;
        this.administrador = administrador;
        this.Gerente = Gerente;
        this.empleado = empleado;
    }


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getGerente() {
        return Gerente;
    }

    public void setGerente(String Gerente) {
        this.Gerente = Gerente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
}
