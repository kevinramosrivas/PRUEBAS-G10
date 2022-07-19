
package dao.interfaces;
import Modelo.*;

public interface IClienteDao {
    
    
    public void registrar(String nombres,String usuario,String contraseña) throws Exception;
    public void modificar(Cliente c) throws Exception;
    public void eliminar(Cliente c) throws Exception;
    public Cliente devolverClientePorNombreUsuario(String usuario) throws Exception;
    public ListaEs<Cliente> getListaClientes() throws Exception;
    
    
}
