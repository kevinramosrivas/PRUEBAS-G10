/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import Modelo.OrdenCompra;
import Modelo.Pago;
import Modelo.TicketVirtual;

/**
 *
 * @author Frank Pizarro
 */
public interface ITicketVirtualDao {
    
    public void registrarTicket(OrdenCompra oc,Pago pago,float MontoAPagar)throws Exception;
    public TicketVirtual devolverTicket(OrdenCompra oc,Pago pago) throws Exception;
    public void eliminarTicket(OrdenCompra oc,int idPago) throws Exception;
}
