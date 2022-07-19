
package dao.sqlserver.Impl;

import Modelo.Cliente;
import Modelo.ListaEs;
import dao.interfaces.IClienteDao;
import dao.sqlserver.conexion.ConexionSQLSERVER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClienteSQLSERVERDao extends ConexionSQLSERVER implements IClienteDao{

    @Override
    public void registrar(String nombres, String usuario, String contraseña) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente devolverClientePorNombreUsuario(String usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaEs<Cliente> getListaClientes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    @Override
    public void registrar(String nombres, String usuario, String contraseña) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Cliente(nombres,usuario,contraseña) VALUES(?,?,?)");
            st.setString(1, nombres);
            st.setString(2, usuario);
            st.setString(3, contraseña);
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
    public void modificar(Cliente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Cliente where idCliente = "+c.getId());
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
    public Cliente devolverClientePorNombreUsuario(String usuario) throws Exception {
        Cliente c = new Cliente(null, null, null);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Cliente where usuario =(?)");
            st.setString(1, usuario);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                c.setId(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombres"));
                c.setUsuario(rs.getString("usuario"));
                c.setPassword(rs.getString("contraseña"));
                
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
        return c;
    }

    @Override
    public ListaEs<Cliente> getListaClientes() throws Exception {
        ListaEs<Cliente> listaClientes = new ListaEs<Cliente>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Cliente");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Cliente c = new Cliente(null,null,null);
                c.setId(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombres"));
                c.setUsuario(rs.getString("usuario"));
                c.setPassword(rs.getString("contraseña"));
                listaClientes.insertarFinal(c);
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
                
        
        return listaClientes;
    }
    */
    
}
