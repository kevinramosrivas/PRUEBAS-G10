/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Interfaces;

import Controladores.ControladorEntradas;

/**
 *
 * @author Lenovo
 */
public interface InterfazEntradas {
    
    void setControlador(ControladorEntradas c);
    
    void arranca();
    
    
    
    public static final String INICIO = "Inicio";
    public static final String VerYModificarOrden = "Ver y Modificar Orden";
    public static final String PAGARORDEN = "Pagar orden";
    public static final String ATRAS = "Atrás";
    public static final String MICOMPRA = "Mi Compra";
    public static final String CERRARSESION = "Cerrar Sesión";
}
