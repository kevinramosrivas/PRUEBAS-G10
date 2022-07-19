
package dao.sqlserver.Impl;
import Modelo.Cliente;
import Modelo.ListaEs;
import Modelo.Pago;
import Modelo.TicketVirtual;
import dao.sqlserver.conexion.ConexionSQLSERVER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.interfaces.IPagoDao;

public class PagoTarjetaSQLSERVERDao extends ConexionSQLSERVER implements IPagoDao {

    @Override
    public void registrar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pago devolverUltimoPago() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaEs<Pago> getListaPagoOrdenes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    @Override
    public void registrar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pago devolverPagoTarjeta(Pago pago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaEs<Pago> getListaPagoOrdenes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    @Override
    public void registrar(Cliente c) throws Exception {
        float monto = c.getOrden().getMontoAPagar();
        int idCliente = c.getId();
        int idOrdenCompra = c.getOrden().getIdOrdenCompra();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("insert into PagoTarjeta(idOrdenCompra,idCliente,montoAPagar,numTarjeta) values(?,?,?,?)");
            st.setInt(1, idOrdenCompra);
            st.setInt(2, idCliente);
            st.setFloat(3, monto);
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
    public void modificar(PagoTarjeta pt) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(PagoTarjeta pt) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM PagoTarjeta where idCliente = "+pt.getIdCliente());
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

    @Override
    public PagoTarjeta devolverPagoTarjeta(Cliente c) throws Exception {
        PagoTarjeta pago = new PagoTarjeta(0, 0, 0);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from PagoTarjeta where idCliente = (?)");
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                pago.setId(rs.getInt("idPagoTarjeta"));
                pago.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                pago.setIdCliente(rs.getInt("idCliente"));
                pago.setMonto(rs.getFloat("montoAPagar"));
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
    public ListaEs<PagoTarjeta> getListaPagoOrdenes() throws Exception {
        ListaEs<PagoTarjeta> listaPagoTarjeta = new ListaEs<PagoTarjeta>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from PagoTarjeta");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                PagoTarjeta pago = new PagoTarjeta(0, 0, 0);
                pago.setId(rs.getInt("idPagoTarjeta"));
                pago.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                pago.setIdCliente(rs.getInt("idCliente"));
                pago.setMonto(rs.getFloat("montoAPagar"));
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
    */

    @Override
    public Pago devolverPagoPorId(TicketVirtual ticket) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(int idPago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
