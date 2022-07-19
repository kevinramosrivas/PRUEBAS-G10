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
public class OrdenCompra {
    
    private int idOrdenCompra;
    private int idCliente;
    private String estado; // por cancelar o cancelado
    private TicketVirtual ticketVirtual;
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdenCompra other = (OrdenCompra) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    
    
    public OrdenCompra(int idCliente)
    {
        this.idCliente = idCliente;
        this.estado = "por cancelar";
    }

    public TicketVirtual getTicketVirtual() {
        return ticketVirtual;
    }

    public void setTicketVirtual(TicketVirtual ticketVirtual) {
        this.ticketVirtual = ticketVirtual;
    }

    

    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    public String toString()
    {
        return "idCliente: "+this.idCliente
                +"idOrdenCompra: "+this.idOrdenCompra;
    }

    
    
    
    
}
