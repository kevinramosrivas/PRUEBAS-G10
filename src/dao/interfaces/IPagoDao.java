
package dao.interfaces;

import Modelo.*;


public interface IPagoDao {
    
    public void registrar(Pago pago) throws Exception;
    public void modificar(Pago pago) throws Exception;
    public void eliminarPorId(int idPago) throws Exception;
    public Pago devolverUltimoPago() throws Exception;
    public Pago devolverPagoPorId(TicketVirtual ticket) throws Exception;
    public ListaEs<Pago> getListaPagoOrdenes() throws Exception;
}
