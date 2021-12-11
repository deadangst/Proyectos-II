/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class Usuarios {

   
    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String correoElectronico;
    private int numeroTelefonico;
    private String calle;
    private String ciudad;
    private String pais;
    private String provincia;
    private String usuario;
    private String password;

    public Usuarios() {
    }

    @Override
    public String toString() {
        return "Usuarios{" + "tipoUsuario=" + tipoUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion + ", correoElectronico=" + correoElectronico + ", numeroTelefonico=" + numeroTelefonico + ", calle=" + calle + ", ciudad=" + ciudad + ", pais=" + pais + ", provincia=" + provincia + ", usuario=" + usuario + ", password=" + password + '}';
    }

    public Usuarios(String tipoUsuario, String nombre, String apellido, String identificacion, String correoElectronico, int numeroTelefonico, String calle, String ciudad, String pais, String provincia, String usuario, String password) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
        this.numeroTelefonico = numeroTelefonico;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.provincia = provincia;
        this.usuario = usuario;
        this.password = password;
    }

    

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
