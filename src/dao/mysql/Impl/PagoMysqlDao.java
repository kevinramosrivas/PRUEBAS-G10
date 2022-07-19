
package dao.mysql.Impl;

import dao.mysql.conexion.ConexionMysql;
import Modelo.Cliente;
import Modelo.ListaEs;
import Modelo.Pago;
import Modelo.TicketVirtual;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.interfaces.IPagoDao;



public class PagoMysqlDao extends ConexionMysql implements IPagoDao {

    @Override
    public void registrar(Pago pago) throws Exception {
        String formaPago = pago.getFormaPago();
        String tipoTarjeta = pago.getTipoTarjeta();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("insert into Pago(formaPago,tipoTarjeta) values(?,?)");
            st.setString(1, formaPago);
            st.setString(2, tipoTarjeta);
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
    public void modificar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(int idPago) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Pago where idPago = "+idPago);
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
    
    public Pago devolverPagoPorId(TicketVirtual ticket) throws Exception
    {
        Pago pago = new Pago(null,null);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from pago where idPago = ?");
            st.setInt(1, ticket.getIdPago());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                pago.setIdPago(rs.getInt("idPago"));
                pago.setFormaPago(rs.getString("formaPago"));
                pago.setTipoTarjeta(rs.getString("tipoTarjeta"));
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return pago;
    }
    
    @Override
    public Pago devolverUltimoPago() throws Exception
    {
        Pago finalPago = new Pago(null, null);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from pago order by idPago desc limit 1");
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                finalPago.setIdPago(rs.getInt("idPago"));
                finalPago.setFormaPago(rs.getString("formaPago"));
                finalPago.setTipoTarjeta(rs.getString("tipoTarjeta"));
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return finalPago;
    }

    @Override
    public ListaEs<Pago> getListaPagoOrdenes() throws Exception {
        ListaEs<Pago> listaPagoTarjeta = new ListaEs<Pago>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Pago");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Pago pago = new Pago(null,null);
                pago.setIdPago(rs.getInt("idPago"));
                pago.setFormaPago(rs.getString("formaPago"));
                pago.setTipoTarjeta(rs.getString("tipoTarjeta"));
                listaPagoTarjeta.insertarFinal(pago);
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaPagoTarjeta;
    }
    
    
}
