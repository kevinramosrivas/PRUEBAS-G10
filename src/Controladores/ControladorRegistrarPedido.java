/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import Vista.Ventanas.VistaTicketVirtual;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistrarPedido;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Principal.ListaDeDatos;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.Interfaces.InterfazRegistrarTicket;

/**
 *
 * @author Lenovo
 */
public class ControladorRegistrarPedido implements ActionListener{

    private ListaDeDatos modelo;
    private VistaRegistrarPedido vista;

    public ControladorRegistrarPedido(ListaDeDatos modelo, VistaRegistrarPedido vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        vista.txtMontoTotal.setText(String.valueOf(calcularMontoTotal()));
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getActionCommand().equals(InterfazRegistrarTicket.INICIO))
        {
            vista.setVisible(false);
            VistaMenuInicio vistaInicio = new VistaMenuInicio();
            ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo,vistaInicio);
            vistaInicio.setControlador(control);
            vistaInicio.arranca();
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazRegistrarTicket.VerYModificarOrden))
            {
                try
                {
                    vista.setVisible(false);
                    VistaVerYModificarOrden vistaVYM = new VistaVerYModificarOrden();
                    ControladorVerYModificarOrden control = new ControladorVerYModificarOrden(modelo, vistaVYM);
                    vistaVYM.setControlador(control);
                    vistaVYM.arranca();
                }
                catch(Exception e )
                {
                    System.out.println(e.getMessage());
                }
                        
            }
            else
            {
                if(ev.getActionCommand().equals(InterfazRegistrarTicket.PORTARJETA))
                {
                    if(vista.rbtnTarjeta.isSelected())
                    {
                        vista.rbtnPlantilla.setSelected(false);
                    }
                }
                else
                {
                    if(ev.getActionCommand().equals(InterfazRegistrarTicket.PORPLANTILLA))
                    {
                        if(vista.rbtnPlantilla.isSelected())
                        {
                            vista.rbtnTarjeta.setSelected(false);
                        }
                    }
                    else
                    {
                        if(ev.getActionCommand().equals(InterfazRegistrarTicket.VISA))
                        {
                            if(vista.rbtnVisa.isSelected())
                            {
                                vista.rbtnAmericanExpress.setSelected(false);
                                vista.rbtnMasterCard.setSelected(false);
                            }
                        }
                        else
                        {
                            if(ev.getActionCommand().equals(InterfazRegistrarTicket.MASTERCARD))
                            {
                                if(vista.rbtnMasterCard.isSelected())
                                {
                                    vista.rbtnAmericanExpress.setSelected(false);
                                    vista.rbtnVisa.setSelected(false);
                                }
                            }
                            else
                            {
                                if(ev.getActionCommand().equals(InterfazRegistrarTicket.AMERICANEXPRESS))
                                {
                                    if(vista.rbtnAmericanExpress.isSelected())
                                    {
                                        vista.rbtnVisa.setSelected(false);
                                        vista.rbtnMasterCard.setSelected(false);
                                    }
                                }
                                else
                                {
                                    if(ev.getActionCommand().equals(InterfazRegistrarTicket.REGISTRARTICKET))
                                    {
                                        //any
                                    }
                                    else // efectuar pago
                                    {
                                        if(ev.getActionCommand().equals(InterfazRegistrarTicket.EFECTUARREGISTRO))
                                        {
                                            if(vista.faltanLlenarDatos())
                                            {
                                                vista.lblFaltanDatos.setText("¡rellene los campos faltantes!");
                                            }
                                            else
                                            {
                                                String formaPago=null;
                                                String tipoTarjeta=null;
                                                vista.lblFaltanDatos.setText(" ");
                                                if(vista.rbtnPlantilla.isSelected())
                                                {
                                                    formaPago = "plantilla";
                                                }
                                                if(vista.rbtnTarjeta.isSelected())
                                                {
                                                    formaPago = "por tarjeta";                  
                                                }
                                                if(vista.rbtnAmericanExpress.isSelected())
                                                {
                                                    tipoTarjeta = "American Express";                            
                                                }
                                                if(vista.rbtnMasterCard.isSelected())
                                                {
                                                    tipoTarjeta = "MasterCard";
                                                }
                                                if(vista.rbtnVisa.isSelected())
                                                {
                                                    tipoTarjeta = "Visa";
                                                }
                                                try
                                                {
                                                    Pago pago = new Pago(formaPago,tipoTarjeta);
                                                    modelo.pagoDao.registrar(pago);
                                                    pago = modelo.pagoDao.devolverUltimoPago();
                                                    modelo.ticketDao.registrarTicket(modelo.cliente.getOrden(), pago, calcularMontoTotal());
                                                    TicketVirtual ticket = modelo.ticketDao.devolverTicket(modelo.cliente.getOrden(), pago);
                                                    modelo.cliente.getOrden().setTicketVirtual(ticket);
                                                    modelo.cliente.getOrden().setEstado("cancelado");
                                                    modelo.ordenCompraDao.modificar(modelo.cliente.getOrden());
                                                    JOptionPane.showMessageDialog(null, "Ticket generado con exito");
                                                    vista.setVisible(false);
                                                    VistaTicketVirtual vistaTicketVirtual = new VistaTicketVirtual();
                                                    ControladorTicketVirtual control = new ControladorTicketVirtual(modelo, vistaTicketVirtual);
                                                    vistaTicketVirtual.setControlador(control);
                                                    vistaTicketVirtual.arranca();
                                                }
                                                catch(Exception e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }
                                                
                                            }
                                        }
                                        else // cerrar sesion
                                        {
                                            try {
                                                modelo.ordenCompraDao.modificar(modelo.cliente.getOrden());
                                            } catch (Exception ex) {
                                                Logger.getLogger(ControladorMenuInicio2.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            modelo.cliente = null;
                                            vista.setVisible(false);
                                            VistaInicioSesionDeReserva vistaInicio = new VistaInicioSesionDeReserva();
                                            ControladorInicioDeSesionDeReserva control = new ControladorInicioDeSesionDeReserva(modelo, vistaInicio);
                                            vistaInicio.setControlador(control);
                                            vistaInicio.arranca();
                                            
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
        }
    }
    
    public float calcularMontoTotal() throws Exception
    {
        float monto = 0;
        ListaEs.Nodo nodo = modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).padre;
        Producto producto;
        while(nodo!=null)
        {
            producto = (Producto)nodo.elemento;
            monto = monto + modelo.productoDao.devolverPrecio(producto.getNombre(), modelo.cliente.getOrden());
            nodo = nodo.sgte;
        }
        return monto;
    }
    
}
