
package Principal;
import dao.factory.DaoFactory;
import dao.interfaces.*;
import Modelo.*;
import dao.mysql.conexion.ConexionMysql;
import Controladores.ControladorInicioDeSesionDeReserva;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainMysql {
    
    public static void main(String[] args) throws Exception {
        
        String nombreFuenteDatos = "mysql";
        IClienteDao clienteDao = DaoFactory.getinstance().getClienteDao(nombreFuenteDatos);
        IOrdenCompraDao ordenCompraDao = DaoFactory.getinstance().getOrdenCompraDao(nombreFuenteDatos);
        IPagoDao pagoDao = DaoFactory.getinstance().getPagoDao(nombreFuenteDatos);
        IProductoDao productoDao = DaoFactory.getinstance().getProductoDao(nombreFuenteDatos);
        ICategoriaDao categoriaDao = DaoFactory.getinstance().getCategoriaDao(nombreFuenteDatos);
        ITicketVirtualDao ticketDao = DaoFactory.getinstance().getTicketVirtualDao(nombreFuenteDatos);
        
        ListaEs<Bebida> listaBebidas = devolverListaBebidas();
        ListaEs<Entrada> listaEntradas = devolverListaEntradas();
        ListaEs<Ensalada> listaEnsaladas = devolverListaEnsaladas();
        ListaEs<Comida> listaComidas = devolverListaComidas();
        cargarMenuDelDia();
        
        ListaDeDatos modelo = new ListaDeDatos(listaBebidas,listaEnsaladas,
        listaEntradas,listaComidas,clienteDao,ordenCompraDao,pagoDao,productoDao,
        categoriaDao,ticketDao);
        
        
        VistaInicioSesionDeReserva vista = new VistaInicioSesionDeReserva();
        ControladorInicioDeSesionDeReserva control = new ControladorInicioDeSesionDeReserva(modelo, vista);
        vista.setControlador(control);
        vista.arranca();
        


        
        
    }

    private static ListaEs<Bebida> devolverListaBebidas() throws SQLException, Exception {
        ConexionMysql con = new ConexionMysql();
        ListaEs<Bebida> listaBebidas = new ListaEs<Bebida>();
        try
        {
            con.conectar();
            PreparedStatement st = con.getConexion().prepareStatement("select * from Bebidas");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Bebida bebida = new Bebida(null,0);
                bebida.setNombre(rs.getString("nombre"));
                bebida.setPrecio(rs.getFloat("precio"));
                listaBebidas.insertarFinal(bebida);
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
            con.desconectar();
        }
        return listaBebidas;
    }

    private static ListaEs<Entrada> devolverListaEntradas() throws Exception {
        ConexionMysql con = new ConexionMysql();
        ListaEs<Entrada> listaEntradas = new ListaEs<Entrada>();
        try
        {
            con.conectar();
            PreparedStatement st = con.getConexion().prepareStatement("select * from Entradas");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Entrada entrada = new Entrada(null,0);
                entrada.setNombre(rs.getString("nombre"));
                entrada.setPrecio(rs.getFloat("precio"));
                listaEntradas.insertarFinal(entrada);
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
            con.desconectar();
        }
        return listaEntradas;
        
    }

    private static ListaEs<Ensalada> devolverListaEnsaladas() throws Exception {
        
        ConexionMysql con = new ConexionMysql();
        ListaEs<Ensalada> listaEnsaladas = new ListaEs<Ensalada>();
        try
        {
            con.conectar();
            PreparedStatement st = con.getConexion().prepareStatement("select * from Ensaladas");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Ensalada ensalada = new Ensalada(null,0);
                ensalada.setNombre(rs.getString("nombre"));
                ensalada.setPrecio(rs.getFloat("precio"));
                listaEnsaladas.insertarFinal(ensalada);
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
            con.desconectar();
        }
        return listaEnsaladas;
    }

    private static ListaEs<Comida> devolverListaComidas() throws Exception {
        
        ConexionMysql con = new ConexionMysql();
        ListaEs<Comida> listaComidas = new ListaEs<Comida>();
        try
        {
            con.conectar();
            PreparedStatement st = con.getConexion().prepareStatement("select * from Comidas");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Comida comida = new Comida(null,0);
                comida.setNombre(rs.getString("nombre"));
                comida.setPrecio(rs.getFloat("precio"));
                listaComidas.insertarFinal(comida);
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
            con.desconectar();
        }
        return listaComidas;
    }

    private static void cargarMenuDelDia() throws SQLException, Exception {
        ConexionMysql con = new ConexionMysql();
        MenuDelDia.instancia();
        try
        {
            con.conectar();
            PreparedStatement st = con.getConexion().prepareStatement("select * from MenuDelDia");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                MenuDelDia.getInstancia().setIdMenuDelDia(rs.getInt("idMenuDelDia"));
                String categoria = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                if(categoria.equals("Bebida"))
                {
                    Bebida bebida = new Bebida(nombre,precio);
                    MenuDelDia.getInstancia().getListaProductos().insertarFinal(bebida);
                }
                if(categoria.equals("Entrada"))
                {
                    Entrada entrada = new Entrada(nombre,precio);
                    MenuDelDia.getInstancia().getListaProductos().insertarFinal(entrada);
                }
                if(categoria.equals("Ensaladas"))
                {
                    Ensalada ensalada = new Ensalada(nombre,precio);
                    MenuDelDia.getInstancia().getListaProductos().insertarFinal(ensalada);
                }
                if(categoria.equals("Comidas"))
                {
                    Comida comida = new Comida(nombre,precio);
                    MenuDelDia.getInstancia().getListaProductos().insertarFinal(comida);
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
            con.desconectar();
        }
        
        
        
        
    }
    
    
}
