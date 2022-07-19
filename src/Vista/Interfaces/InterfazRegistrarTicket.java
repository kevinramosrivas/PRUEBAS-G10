
package Vista.Interfaces;

import Controladores.ControladorRegistrarPedido;

/**
 *
 * @author Lenovo
 */
public interface InterfazRegistrarTicket {
    
    void setControlador(ControladorRegistrarPedido c);
    
    void arranca();
    
    boolean faltanLlenarDatos();
    
    boolean faltanLlenarRB();
    
    
    static final String INICIO = "Inicio";
    static final String VerYModificarOrden = "Ver y Modificar Orden";
    static final String REGISTRARTICKET = "Registrar Ticket";
    static final String EFECTUARREGISTRO = "Efectuar Registro";
    static final String CERRARSESION = "Cerrar Sesión";
    
    static final String PORTARJETA = "Por tarjeta";
    static final String PORPLANTILLA = "Por plantilla";
    static final String VISA = "Visa";
    static final String MASTERCARD = "Master Card";
    static final String AMERICANEXPRESS = "Amercian Express";
}
