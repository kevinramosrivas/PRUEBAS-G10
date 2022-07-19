/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Interfaces;

import Controladores.ControladorTicketVirtual;
import Controladores.ControladorEntradas;

/**
 *
 * @author Lenovo
 */
public interface InterfazTicketVirtual {
    
    
    void setControlador(ControladorTicketVirtual c);
    
    void arranca();
    
    public static final String INICIO = "Inicio";
    public static final String CANCELAR = "Cancelar Orden";
    public static final String CERRARSESION = "Cerrar Sesión";
    
    
}
