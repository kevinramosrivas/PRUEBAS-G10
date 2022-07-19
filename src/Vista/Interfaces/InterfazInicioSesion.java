
package Vista.Interfaces;

import Controladores.ControladorInicioDeSesionDeReserva;
import Modelo.Cliente;

//metodos propios para la ventana inicio sesion
public interface InterfazInicioSesion {
    
    void setControlador(ControladorInicioDeSesionDeReserva c);
    
    void arranca();
    
    void ocultarLbls();
    
    boolean faltanLlenarDatos();
        
    static final String INGRESAR = "Ingresar";
    
    static final String REGISTRATE = "Regístrate";
    
    static final String mostrarContraseña = "Mostrar Contraseña";
    
}
