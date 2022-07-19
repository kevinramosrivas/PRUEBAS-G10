
package dao.sqlserver.Impl;
import Modelo.Cliente;
import Modelo.ListaEs;
import Modelo.OrdenCompra;
import dao.interfaces.IOrdenCompraDao;
import dao.sqlserver.conexion.ConexionSQLSERVER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdenCompraSQLSERVERDao extends ConexionSQLSERVER implements IOrdenCompraDao{

    @Override
    public void registrar(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdenCompra devolverOrdenParaUsuarioNuevo(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdenCompra devolverOrdenParaUsuarioExistente(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaEs<OrdenCompra> getListaOrdenes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public void registrar(Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("INSERT INTO OrdenCompra(idCliente,estado)VALUES(?,?)");
            st.setInt(1, c.getId());
            st.setString(2, "por cancelar");
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
    public void modificar(OrdenCompra oc) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st1 = this.conexion.prepareStatement
            ("update OrdenCompra set estado = ? where idCliente = ?");
            st1.setString(1, oc.getEstado());
            st1.setInt(2, oc.getIdCliente());
            st1.executeUpdate();
            
            PreparedStatement st2 = this.conexion.prepareStatement
            ("update OrdenCompra set montoAPagar = ? where idCliente = ?");
            st2.setFloat(1, oc.getMontoAPagar());
            st2.setInt(2, oc.getIdCliente());
            st2.executeUpdate();
            
            PreparedStatement st3 = this.conexion.prepareStatement
            ("update OrdenCompra set formaPago = ? where idCliente = ?");
            st3.setString(1, oc.getFormaPago());
            st3.setInt(2, oc.getIdCliente());
            st3.executeUpdate();
            
            PreparedStatement st8 = this.conexion.prepareStatement
            ("update OrdenCompra set tipoTarjeta = ? where idCliente = ?");
            st8.setString(1, oc.getFormaPago());
            st8.setInt(2, oc.getIdCliente());
            st8.executeUpdate();
            
            
            
            PreparedStatement st4 = this.conexion.prepareStatement
            ("update OrdenCompra set numTarjeta = ? where idCliente = ?");
            st4.setInt(2, oc.getIdCliente());
            st4.executeUpdate();
            
            PreparedStatement st5 = this.conexion.prepareStatement
            ("update OrdenCompra set numTelefono = ? where idCliente = ?");
            st5.setInt(2, oc.getIdCliente());
            st5.executeUpdate();
            
            PreparedStatement st6 = this.conexion.prepareStatement
            ("update OrdenCompra set correo = ? where idCliente = ?");
            st6.setInt(2, oc.getIdCliente());
            st6.executeUpdate();
            
            PreparedStatement st7 = this.conexion.prepareStatement
            ("update OrdenCompra set direccion = ? where idCliente = ?");
            st7.setInt(2, oc.getIdCliente());
            st7.executeUpdate();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    

    @Override
    public void eliminar(OrdenCompra oc) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM OrdenCompra where idOrdenCompra = "+oc.getIdOrdenCompra());
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
    public OrdenCompra devolverOrdenParaUsuarioNuevo(Cliente c) throws Exception {
        OrdenCompra oc = new OrdenCompra(0);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from OrdenCompra where idCliente = (?)");
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                oc.setIdCliente(rs.getInt("idCliente"));
                oc.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
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
        return oc;
    }

    @Override
    public OrdenCompra devolverOrdenParaUsuarioExistente(Cliente c) throws Exception {
        OrdenCompra oc = new OrdenCompra(0);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from OrdenCompra where idCliente = (?)");
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                oc.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                oc.setIdCliente(rs.getInt("idCliente"));
                oc.setEstado(rs.getString("estado"));
                oc.setMontoAPagar(rs.getFloat("montoAPagar"));
                oc.setFormaPago(rs.getString("formaPago"));
                oc.setTipoTarjeta(rs.getString("tipoTarjeta"));
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
        return oc;
    }

    @Override
    public ListaEs<OrdenCompra> getListaOrdenes() throws Exception {
        ListaEs<OrdenCompra> listaOrdenCompra = new ListaEs<OrdenCompra>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from OrdenCompra");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                OrdenCompra oc = new OrdenCompra(0);
                oc.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                oc.setIdCliente(rs.getInt("idCliente"));
                oc.setEstado(rs.getString("estado"));
                oc.setMontoAPagar(rs.getFloat("montoAPagar"));
                oc.setFormaPago(rs.getString("formaPago"));
                oc.setTipoTarjeta(rs.getString("tipoTarjeta"));
                listaOrdenCompra.insertarFinal(oc);
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
        
        return listaOrdenCompra;
    }
    */
}
