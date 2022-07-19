
package dao.interfaces;
import Modelo.*;

public interface IOrdenCompraDao {
    
    public void registrar(Cliente c) throws Exception;
    public void modificar(OrdenCompra oc) throws Exception;
    public void eliminar(OrdenCompra oc) throws Exception;
    public OrdenCompra devolverOrdenParaUsuarioNuevo(Cliente c) throws Exception;
    public OrdenCompra devolverOrdenParaUsuarioExistente(Cliente c) throws Exception;
    public ListaEs<OrdenCompra> getListaOrdenes() throws Exception;
}
