
package Principal;
import Modelo.*;
import dao.interfaces.*;

public class ListaDeDatos {
    
    public static ListaEs<Bebida> listaBebidas;
    public static ListaEs<Ensalada> listaEnsaladas;
    public static ListaEs<Entrada> listaEntradas;
    public static ListaEs<Comida> listaComidas;
    
    public static IClienteDao clienteDao;
    public static IOrdenCompraDao ordenCompraDao;
    public static IPagoDao pagoDao;
    public static IProductoDao productoDao;
    public static ICategoriaDao categoriaDao;
    public static ITicketVirtualDao ticketDao;
    
    public static Cliente cliente;
    
    public ListaDeDatos(ListaEs<Bebida> listaBebidas,ListaEs<Ensalada> listaEnsaladas,
                        ListaEs<Entrada> listaEntradas,ListaEs<Comida> listaComidas,
                        IClienteDao clienteDao,IOrdenCompraDao ordenCompraDao,
                        IPagoDao pagoTarjetaDao,IProductoDao productoDao,
                        ICategoriaDao categoriaDao,ITicketVirtualDao ticketDao
                        )
    {
        this.listaBebidas = listaBebidas;
        this.listaEnsaladas = listaEnsaladas;
        this.listaEntradas = listaEntradas;
        this.listaComidas = listaComidas;
        this.clienteDao = clienteDao;
        this.ordenCompraDao = ordenCompraDao;
        this.pagoDao = pagoTarjetaDao;
        this.productoDao = productoDao;
        this.categoriaDao = categoriaDao;
        this.ticketDao = ticketDao;
        this.cliente=null;
    }

    
    
    
}
