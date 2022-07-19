package Vista.Interfaces;

import Controladores.ControladorComidas;

public interface InterfazComidas {
    
    
    void setControlador(ControladorComidas c);
    
    void arranca();
    
    static final String INICIO = "Inicio";
    static final String VerYModificarOrden = "Ver y Modificar Orden";
    static final String PAGARORDEN = "Pagar orden";
    static final String ATRAS = "Atrás";
    static final String MICOMPRA = "Mi Compra";
    static final String CERRARSESION = "Cerrar Sesión";
    
    
}
