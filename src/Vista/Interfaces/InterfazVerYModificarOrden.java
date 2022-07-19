/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Interfaces;

import Controladores.ControladorVerYModificarOrden;

/**
 *
 * @author Lenovo
 */
public interface InterfazVerYModificarOrden {
    
    void setControlador(ControladorVerYModificarOrden c);
    
    void arranca();
    
    static final String INICIO = "Inicio";
    static final String VerYModificarOrden = "Ver y Modificar Orden";
    static final String PAGARORDEN = "Pagar orden";
    static final String CERRRARSESION = "Cerrar Sesión";
    
    
    
}
