/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Cliente;
import Principal.ListaDeDatos;
import Vista.Interfaces.InterfazRegistro;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import Vista.Ventanas.VistaRegistroDeReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Lenovo
 */
public class ControladorRegistroDeReserva implements ActionListener {
    
    private ListaDeDatos modelo;
    private VistaRegistroDeReserva vista;
    
    public ControladorRegistroDeReserva(ListaDeDatos modelo,VistaRegistroDeReserva vista)
    {
        this.modelo = modelo;
        this.vista = vista;
        cambiosEnJTextField();
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getActionCommand().equals(InterfazRegistro.REGISTRARSE)) // si se presiona el botón registrarse
        {
            vista.ocultarLbls();
            Cliente cliente = vista.devolverCliente();
            if(vista.faltanLlenarDatos())
            {
                vista.lblRelleneCamposFaltantes.setVisible(true);
                if(vista.txtNombreYApellido.getText().isEmpty())
                {
                    vista.lblast1.setVisible(true);
                }
                if(vista.txtUsuarioRegistro.getText().isEmpty())
                {
                    vista.lblast2.setVisible(true);
                }
                if(vista.pfContraseña.getText().isEmpty())
                {
                    vista.lblast3.setVisible(true);
                }
            }
            else
            {
                vista.ocultarLbls();
                try
                {
                    if(!modelo.clienteDao.getListaClientes().existeElemento(cliente))
                    {
                        vista.lblRelleneCamposFaltantes.setText("¡Usuario registrado!");
                        vista.lblRelleneCamposFaltantes.setVisible(true);
                        modelo.clienteDao.registrar(cliente.getNombre(), cliente.getUsuario(), cliente.getPassword());
                        JOptionPane.showMessageDialog(null, "Usuario registrado");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazRegistro.mostrarContraseña)) // si se presiona el boton mostrar contraseña
            {
                char echoChar = vista.rbtnMostrarContraseña.isSelected() ? (char)0 : '*';
                vista.pfContraseña.setEchoChar(echoChar);
            }
            else // se presiona el boton atras
            {
                vista.setVisible(false);
                VistaInicioSesionDeReserva vistaInicio = new VistaInicioSesionDeReserva();
                ControladorInicioDeSesionDeReserva control = new ControladorInicioDeSesionDeReserva(modelo, vistaInicio);
                vistaInicio.setControlador(control);
                vistaInicio.arranca();
            }
        }
        
    }
    
    
    public void cambiosEnJTextField()
    {
        Document doc = vista.txtUsuarioRegistro.getDocument();//lo tomamos como si fuera
        // un nuevo componente(como jtextfield,jtextarea,jlabel, etc)
        
        doc.addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    cambio();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorRegistroDeReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    cambio();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorRegistroDeReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    cambio();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorRegistroDeReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            public void cambio() throws Exception
            {
                String usuario = vista.txtUsuarioRegistro.getText();
                Cliente cliente = new Cliente(" ",usuario," ");
                if(modelo.clienteDao.getListaClientes().existeElemento(cliente))
                {
                    vista.lblResultadoRegistro.setVisible(true);
                }
                else
                {
                    vista.lblResultadoRegistro.setVisible(false);
                }
            }
                    
        }
        );
    }
    
}
