
package dao.mysql.Impl;
import dao.mysql.conexion.ConexionMysql;
import Modelo.*;
import dao.factory.DaoFactory;
import dao.interfaces.IProductoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoMysqlDao extends ConexionMysql implements IProductoDao {

    @Override
    public void registrarProductoNuevo(OrdenCompra oc,String nombre,float precio,Categoria categoria,int cantidad) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("insert into Producto(idOrdenCompra,idCliente,nombre,precio,idCategoria,cantidad) values (?,?,?,?,?,?)");
            st.setInt(1, oc.getIdOrdenCompra());
            st.setInt(2, oc.getIdCliente());
            st.setString(3, nombre);
            st.setFloat(4, precio);
            st.setInt(5, categoria.getIdCategoria());
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
    public void modificar(String nombre,int opc,float precioun,OrdenCompra oc) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("update Producto set cantidad = cantidad + ? where nombre = ? and idCliente = ?");
            st.setInt(1, opc);
            st.setString(2, nombre);
            st.setInt(3, oc.getIdCliente());
            st.executeUpdate();
            
            PreparedStatement st2 = this.conexion.prepareStatement
            ("update Producto set precio = cantidad * ? where nombre = ? and idCliente = ?");
            st2.setFloat(1, precioun);
            st2.setString(2, nombre);
            st2.setInt(3, oc.getIdCliente());
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
    public void eliminar(Producto p,OrdenCompra oc) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("delete from producto where nombre = ? and idCliente = ? and idOrdenCompra = ?");
            st.setString(1, p.getNombre());
            st.setInt(2, oc.getIdCliente());
            st.setInt(3, oc.getIdOrdenCompra());
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
    public void eliminarTodo(OrdenCompra oc) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("delete from Producto where idCliente = ?");
            st.setInt(1, oc.getIdCliente());
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
    public ListaEs<Producto> getListaProductos(OrdenCompra oc) throws Exception {
        ListaEs<Producto> listaProductos = new ListaEs<Producto>();
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Producto where idCliente = ?");
            st.setInt(1, oc.getIdCliente());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            { 
                Producto p = null;
                int idCategoria = rs.getInt("idCategoria");
                int cantidad = rs.getInt("cantidad");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                
                if(idCategoria==1)//bebidas
                {
                    Bebida bbda = new Bebida(nombre,precio);
                    bbda.setCantidad(cantidad);
                    bbda.setIdCategoria(DaoFactory.getinstance().getCategoriaDao("mysql").devolverCategoria("Bebidas").getIdCategoria());
                    bbda.setIdCliente(oc.getIdCliente());
                    bbda.setIdOrdenCompra(oc.getIdOrdenCompra());
                    p = bbda;
                }
                if(idCategoria==4)//entrada
                {
                    Entrada entrd = new Entrada(nombre,precio);
                    entrd.setCantidad(cantidad);
                    entrd.setIdCategoria(DaoFactory.getinstance().getCategoriaDao("mysql").devolverCategoria("Entradas").getIdCategoria());
                    entrd.setIdCliente(oc.getIdCliente());
                    entrd.setIdOrdenCompra(oc.getIdOrdenCompra());
                    p = entrd;
                }
                if(idCategoria==3)//ensalada
                {
                    Ensalada ensalada = new Ensalada(nombre,precio);
                    ensalada.setCantidad(cantidad);
                    ensalada.setIdCategoria(DaoFactory.getinstance().getCategoriaDao("mysql").devolverCategoria("Ensaladas").getIdCategoria());
                    ensalada.setIdCliente(oc.getIdCliente());
                    ensalada.setIdOrdenCompra(oc.getIdOrdenCompra());
                    p = ensalada;
                }
                if(idCategoria==2)//comida
                {
                    Comida comida = new Comida(nombre,precio);
                    comida.setCantidad(cantidad);
                    comida.setIdCategoria(DaoFactory.getinstance().getCategoriaDao("mysql").devolverCategoria("comidas").getIdCategoria());
                    comida.setIdCliente(oc.getIdCliente());
                    comida.setIdOrdenCompra(oc.getIdOrdenCompra());
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

    @Override
    public float devolverPrecio(String nombre,OrdenCompra oc) throws Exception {
        float precio = 0;
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement
            ("select * from Producto where nombre = ? and idCliente = ? and idOrdenCompra = ?");
            st.setString(1, nombre);
            st.setInt(2, oc.getIdCliente());
            st.setInt(3, oc.getIdOrdenCompra());
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

    

    
    
    
}
