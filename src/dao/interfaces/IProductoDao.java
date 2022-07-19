
package dao.interfaces;
import Modelo.*;

public interface IProductoDao {
    
    public void registrarProductoNuevo(OrdenCompra oc,String nombre,float precio,Categoria categoria,int cantidad) throws Exception;
    public void modificar(String nombre,int opc, float precioun,OrdenCompra oc) throws Exception;
    public void eliminar(Producto p,OrdenCompra oc) throws Exception;
    public void eliminarTodo(OrdenCompra oc) throws Exception;
    public float devolverPrecio(String nombre,OrdenCompra oc) throws Exception;
    public ListaEs<Producto> getListaProductos(OrdenCompra oc) throws Exception;
    
}
