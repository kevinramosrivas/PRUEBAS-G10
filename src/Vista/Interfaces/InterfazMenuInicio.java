/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Interfaces;

import Controladores.ControladorMenuInicio2;

/**
 *
 * @author Lenovo
 */
public interface InterfazMenuInicio {
    
    
    void establecerImagenes();
    
    void setControlador(ControladorMenuInicio2 c);
    
    void arranca();
    
    static final String INICIO = "Inicio";
    static final String VerYModificarOrden = "Ver y Modificar Orden";
    static final String PagarOrden = "Pagar orden";
    static final String CerrarSesion = "Cerrar Sesión";
    static final String BEBIDAS = "Bebidas";
    static final String ENSALADAS = "Ensaladas";
    static final String ENTRADAS = "Entradas";
    static final String COMIDAS = "Comidas";
    static final String MENUESPECIAL = "Menu Especial";
    static final String MICOMPRA = "Mi Compra";
}
