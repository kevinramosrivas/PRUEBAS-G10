/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Principal.ListaDeDatos;
import Modelo.Cliente;
import Modelo.ListaEs;
import Modelo.OrdenCompra;
import Vista.Interfaces.InterfazInicioSesion;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistroDeReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ControladorInicioDeSesionDeReserva implements ActionListener{

    private ListaDeDatos modelo;
    private VistaInicioSesionDeReserva vista;
    
    public ControladorInicioDeSesionDeReserva(ListaDeDatos modelo,VistaInicioSesionDeReserva vista)
    {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getActionCommand().equals(InterfazInicioSesion.INGRESAR)) // se presiona el boton ingresar
        {
            vista.ocultarLbls();
            if(vista.faltanLlenarDatos())
            {
                vista.lblRelleneCamposFaltantes.setVisible(true);
                if(vista.txtUsuarioInicio.getText().isEmpty())
                {
                    vista.lblast1.setVisible(true);
                }
                if(vista.pfContraseña.getText().isEmpty())
                {
                    vista.lblast2.setVisible(true);
                }
            }
            else
            {
                vista.ocultarLbls();
                String usuario = vista.txtUsuarioInicio.getText();
                String password = vista.pfContraseña.getText();
                try {
                    VerificarInicio(usuario, password);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorInicioDeSesionDeReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazInicioSesion.mostrarContraseña))// se presiona el radioboton mostrar contraseña
            {
                char echoChar = vista.rbtnMostrarContraseña.isSelected() ? (char)0 : '*';
                vista.pfContraseña.setEchoChar(echoChar);
            }
            else
            {
                if(ev.getActionCommand().equals(InterfazInicioSesion.REGISTRATE))// se presiona el boton registrate
                {
                    vista.setVisible(false);
                    VistaRegistroDeReserva vistaRegistro = new VistaRegistroDeReserva();
                    ControladorRegistroDeReserva control = new ControladorRegistroDeReserva(modelo,vistaRegistro);
                    vistaRegistro.setControlador(control);
                    vistaRegistro.arranca();
                }
                else // se presiona el boton salir
                {
                    System.exit(0);
                }
            }
        }
        
    }
    
    public void VerificarInicio(String usuario,String password) throws Exception {
        
       
        if(modelo.clienteDao.getListaClientes().existeElemento(new Cliente(" ",usuario," ")))
        {
            
            Cliente cliente = modelo.clienteDao.devolverClientePorNombreUsuario(usuario);
            
            if(cliente.getPassword().equals(password))
            {
                
                if(modelo.ordenCompraDao.getListaOrdenes().existeElemento(new OrdenCompra(cliente.getIdCliente())))
                {
                    cliente.setOrden(modelo.ordenCompraDao.devolverOrdenParaUsuarioExistente(cliente));
                }
                else
                {
                    System.out.println("holassss");
                    modelo.ordenCompraDao.registrar(cliente);
                    OrdenCompra oc = modelo.ordenCompraDao.devolverOrdenParaUsuarioNuevo(cliente);
                    cliente.setOrden(oc);
                }
                
                vista.lblResultadoInicio.setText("datos correctos");
                vista.setVisible(false);
                modelo.cliente = cliente;
                VistaMenuInicio vistaMenuInicio = new VistaMenuInicio();
                ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo,vistaMenuInicio);
                vistaMenuInicio.setControlador(control);
                vistaMenuInicio.arranca();
                
            }
            else
            {
                vista.lblResultadoInicio.setVisible(true);
            }
        }
        else
        {
            vista.lblResultadoInicio.setVisible(true);
        }
        
        
    
    }
    
}
