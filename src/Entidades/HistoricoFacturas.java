/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDateTime;


public class HistoricoFacturas {
    private String codigoFactura;
    private String usuario;
    private double total;
    private double costoEnvio;
    private double iva;
    private double totalFinal;
    private LocalDateTime horaCompra = LocalDateTime.now();
    

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public LocalDateTime getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(LocalDateTime horaCompra) {
        this.horaCompra = horaCompra;
    }

    public HistoricoFacturas() {
    }

    public HistoricoFacturas(String codigoFactura, String usuario, double total, double costoEnvio, double totalFinal) {
        this.codigoFactura = codigoFactura;
        this.usuario = usuario;
        this.total = total;
        this.costoEnvio = costoEnvio;
        this.totalFinal = totalFinal;
    }
    
    
}
