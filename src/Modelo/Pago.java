package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Pago {
    private int idPago;
    private String formaPago;//por tarjeta o planilla
    private String tipoTarjeta;//si es por planilla es null

    public Pago(String formaPago, String tipoTarjeta) {
        this.formaPago = formaPago;
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", formaPago=" + formaPago + ", tipoTarjeta=" + tipoTarjeta + '}';
    }

    
}
