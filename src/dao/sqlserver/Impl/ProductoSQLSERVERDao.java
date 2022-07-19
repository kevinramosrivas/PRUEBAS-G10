
package dao.sqlserver.Impl;
import Modelo.Bebida;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Comida;
import Modelo.Ensalada;
import Modelo.Entrada;
import Modelo.ListaEs;
import Modelo.OrdenCompra;
import Modelo.Producto;
import dao.sqlserver.conexion.ConexionSQLSERVER;
import dao.interfaces.IProductoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProductoSQLSERVERDao extends ConexionSQLSERVER implements IProductoDao{

    @Override
    public void registrarProductoNuevo(OrdenCompra oc, String nombre, float precio, Categoria categoria, int cantidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(String nombre, int opc, float precioun, OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Producto p, OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTodo(OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float devolverPrecio(String nombre, OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaEs<Producto> getListaProductos(OrdenCompra oc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    @Override
    public void registrarProductoNuevo(Cliente c, String nombre, float precio, String categoria, int cantidad) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("insert into Producto(idOrdenCompra,idCliente,nombre,precio,categoria,cantidad) values (?,?,?,?,?,?)");
            st.setInt(1, c.getOrden().getIdOrdenCompra());
            st.setInt(2, c.getId());
            st.setString(3, nombre);
            st.setFloat(4, precio);
            st.setString(5, categoria);
            st.setInt(6, cantidad);
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
    public void modificar(String nombre, int opc, float precioun, Cliente c) throws Exception {
         try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("update Producto set cantidad = cantidad + ? where nombre = ? and idCliente = ?");
            st.setInt(1, opc);
            st.setString(2, nombre);
            st.setInt(3, c.getId());
            st.executeUpdate();
            
            PreparedStatement st2 = this.conexion.prepareStatement
            ("update Producto set precio = cantidad * ? where nombre = ? and idCliente = ?");
            st2.setFloat(1, precioun);
            st2.setString(2, nombre);
            st2.setInt(3, c.getId());
            st2.executeUpdate();
            
            
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
    public void eliminar(Producto p, Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("delete from producto where nombre = ? and idCliente = ?");
            st.setString(1, p.getNombre());
            st.setInt(2, c.getId());
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
    public void eliminarTodo(Cliente c) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("delete from Producto where idCliente = ?");
            st.setInt(1, c.getId());
            st.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public float devolverPrecio(String nombre, Cliente c) throws Exception {
        float precio = 0;
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("select * from Producto where nombre = ? and idCliente = ?");
            st.setString(1, nombre);
            st.setInt(2, c.getId());
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                precio = rs.getFloat("precio");
            }
            st.close();
            rs.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return precio;
    }

    @Override
    public ListaEs<Producto> getListaProductos(Cliente c) throws Exception {
        ListaEs<Producto> listaProductos = new ListaEs<Producto>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Producto where idCliente = ?");
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            { 
                Producto p = null;
                String categoria = rs.getString("categoria");
                int cantidad = rs.getInt("cantidad");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                if(categoria.equals("bebida"))
                {
                    Bebida bbda = new Bebida(nombre,precio);
                    p = bbda;
                }
                if(categoria.equals("entrada"))
                {
                    Entrada entrd = new Entrada(nombre,precio);
                    p = entrd;
                }
                if(categoria.equals("ensalada"))
                {
                    Ensalada ensalada = new Ensalada(nombre,precio);
                    p = ensalada;
                }
                if(categoria.equals("comida"))
                {
                    Comida comida = new Comida(nombre,precio);
                    p = comida;
                }
                if(cantidad>1)
                {
                    for(int i=1;i<=cantidad;i++)
                    {
                        listaProductos.insertarFinal(p);
                    }
                }
                else
                {
                    listaProductos.insertarFinal(p);
                }
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
        
        return listaProductos;
    }
    */
}
