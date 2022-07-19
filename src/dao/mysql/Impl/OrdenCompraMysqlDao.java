/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql.Impl;
import Modelo.Cliente;
import Modelo.ListaEs;
import Modelo.OrdenCompra;
import dao.interfaces.IOrdenCompraDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.mysql.conexion.ConexionMysql;

/**
 *
 * @author Lenovo
 */
public class OrdenCompraMysqlDao extends ConexionMysql implements IOrdenCompraDao {

    @Override
    public void registrar(Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("INSERT INTO OrdenCompra(idCliente,estado)VALUES(?,?)");
            st.setInt(1, c.getIdCliente());
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
            st.setInt(1, c.getIdCliente());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                oc.setIdCliente(rs.getInt("idCliente"));
                oc.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                oc.setEstado("por cancelar");
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
            st.setInt(1, c.getIdCliente());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                oc.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
                oc.setIdCliente(rs.getInt("idCliente"));
                oc.setEstado(rs.getString("estado"));
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

    
    
}
