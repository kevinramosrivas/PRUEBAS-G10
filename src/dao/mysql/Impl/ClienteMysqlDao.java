
package dao.mysql.Impl;
import Modelo.Cliente;
import Modelo.ListaEs;
import dao.mysql.conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.interfaces.IClienteDao;



public class ClienteMysqlDao extends ConexionMysql implements IClienteDao {

    @Override
    public void registrar(String nombres,String usuario,String contraseña) throws Exception {
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
        
        
    }

    @Override
    public void eliminar(Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Cliente where idCliente = "+c.getIdCliente());
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
                c.setIdCliente(rs.getInt("idCliente"));
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
                c.setIdCliente(rs.getInt("idCliente"));
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

   
    
}
