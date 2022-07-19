/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Frank Pizarro
 */
public class TicketVirtual {
    
    private int idTicketVirtual;
    private int idOrdenCompra;
    private int idCliente;
    private int idPago;
    private float montoAPagar;
    
    public TicketVirtual(int idOrdenCompra, int idCliente, int idPago)
    {
        this.idOrdenCompra = idOrdenCompra;
        this.idCliente = idCliente;
        this.idPago = idPago;
    }

    public float getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(float montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    
    public int getIdTicketVirtual() {
        return idTicketVirtual;
    }

    public void setIdTicketVirtual(int idTicketVirtual) {
        this.idTicketVirtual = idTicketVirtual;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    @Override
    public String toString() {
        return "TicketVirtual{" + "idTicketVirtual=" + idTicketVirtual + ", idOrdenCompra=" + idOrdenCompra + ", idCliente=" + idCliente + ", idPago=" + idPago + '}';
    }
    
    
    
}
