/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql.Impl;

import Modelo.OrdenCompra;
import Modelo.Pago;
import Modelo.TicketVirtual;
import dao.interfaces.ITicketVirtualDao;
import dao.mysql.conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Frank Pizarro
 */
public class TicketVirtualMysqlDao extends ConexionMysql implements ITicketVirtualDao{

    @Override
    public void registrarTicket(OrdenCompra oc, Pago pago,float montoAPagar) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO TicketVirtual(idOrdenCompra,idCliente,idPago,montoAPagar) VALUES(?,?,?,?)");
            st.setInt(1, oc.getIdOrdenCompra());
            st.setInt(2, oc.getIdCliente());
            st.setInt(3, pago.getIdPago());
            st.setFloat(4, montoAPagar);
            st.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }

    @Override
    public TicketVirtual devolverTicket(OrdenCompra oc, Pago pago) throws Exception {
        TicketVirtual ticket = new TicketVirtual(0,0,0);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM TicketVirtual where idOrdenCompra =(?) and idCliente =(?) and idPago =(?)");
            st.setInt(1, oc.getIdOrdenCompra());
            st.setInt(2, oc.getIdCliente());
            st.setInt(3, pago.getIdPago());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                ticket.setIdTicketVirtual(rs.getInt("idTicketVirtual"));
                ticket.setMontoAPagar(rs.getFloat("montoAPagar"));
                ticket.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                ticket.setIdCliente(rs.getInt("idCliente"));
                ticket.setIdPago(rs.getInt("idPago"));
            }
            st.close();
            rs.close();
            
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return ticket;
    }
    
    @Override
    public void eliminarTicket(OrdenCompra oc,int idPago) throws Exception
    {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM TicketVirtual where idPago = ? and idOrdenCompra = ? and idCliente = ?");
            st.setInt(1, idPago);
            st.setInt(2, oc.getIdOrdenCompra());
            st.setInt(3, oc.getIdCliente());
            st.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            desconectar();
        }
    }
    
}
