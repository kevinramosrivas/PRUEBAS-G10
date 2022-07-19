/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Interfaces;

import Controladores.ControladorInicioDeSesionDeReserva;
import Controladores.ControladorRegistroDeReserva;
import Modelo.Cliente;


public interface InterfazRegistro {
    
    void setControlador(ControladorRegistroDeReserva c);
    
    void arranca();
    
    void ocultarLbls();
    
    boolean faltanLlenarDatos();
    
    Cliente devolverCliente();
    
    static final String REGISTRARSE = "Registrarse";
    
    static final String ATRAS = "Atrás";
    
    static final String mostrarContraseña = "Mostrar Contraseña"; 
}
