
package Controladores;

import Principal.ListaDeDatos;
import Vista.Interfaces.InterfazMenuInicio;
import static Vista.Interfaces.InterfazMenuInicio.BEBIDAS;
import static Vista.Interfaces.InterfazMenuInicio.COMIDAS;
import static Vista.Interfaces.InterfazMenuInicio.ENSALADAS;
import static Vista.Interfaces.InterfazMenuInicio.ENTRADAS;
import Vista.Ventanas.VistaBebidas;
import Vista.Ventanas.VistaTicketVirtual;
import Vista.Ventanas.VistaComidas;
import Vista.Ventanas.VistaEnsaladas;
import Vista.Ventanas.VistaEntradas;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import Vista.Ventanas.VistaMenuDelDia;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistrarPedido;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class ControladorMenuInicio2 implements ActionListener {

    private ListaDeDatos modelo;
    private VistaMenuInicio vista;
    
    public ControladorMenuInicio2(ListaDeDatos modelo,VistaMenuInicio vista)
    {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        posicionBotones();
    }
   
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getActionCommand().equals(BEBIDAS))
        {
            try
            {
                vista.setVisible(false);
                VistaBebidas vistaBebidas = new VistaBebidas();
                ControladorBebidas control = new ControladorBebidas(modelo,vistaBebidas);
                vistaBebidas.setControlador(control);
                vistaBebidas.arranca();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            
        }
        else
        {
            if(ev.getActionCommand().equals(ENSALADAS))
            {
                try
                {
                    vista.setVisible(false);
                VistaEnsaladas vistaEnsaladas = new VistaEnsaladas();
                ControladorEnsaladas control = new ControladorEnsaladas(modelo,vistaEnsaladas);
                vistaEnsaladas.setControlador(control);
                vistaEnsaladas.arranca();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else
            {
                if(ev.getActionCommand().equals(ENTRADAS))
                {
                    try
                    {
                        vista.setVisible(false);
                    VistaEntradas vistaEntradas = new VistaEntradas();
                    ControladorEntradas control = new ControladorEntradas(modelo, vistaEntradas);
                    vistaEntradas.setControlador(control);
                    vistaEntradas.arranca();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else
                {
                    if(ev.getActionCommand().equals(COMIDAS))
                    {
                        try
                        {
                            vista.setVisible(false);
                        VistaComidas vistaComidas = new VistaComidas();
                        ControladorComidas control = new ControladorComidas(modelo,vistaComidas);
                        vistaComidas.setControlador(control);
                        vistaComidas.arranca();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        if(ev.getActionCommand().equals(InterfazMenuInicio.VerYModificarOrden))
                        {
                            try
                            {
                                vista.setVisible(false);
                            VistaVerYModificarOrden vistaVYM = new VistaVerYModificarOrden();
                            ControladorVerYModificarOrden control = new ControladorVerYModificarOrden(modelo, vistaVYM);
                            vistaVYM.setControlador(control);
                            vistaVYM.arranca();
                            }
                            catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                        else
                        {
                            if(ev.getActionCommand().equals(InterfazMenuInicio.PagarOrden))
                            {
                                try {
                                    if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).cantidad==0)
                                    {
                                        JOptionPane.showMessageDialog(null, "No tiene ningún producto en su orden");
                                    }
                                    else
                                    {
                                        vista.setVisible(false);
                                        VistaRegistrarPedido vistaPagar = new VistaRegistrarPedido();
                                        ControladorRegistrarPedido control = new ControladorRegistrarPedido(modelo, vistaPagar);
                                        vistaPagar.setControlador(control);
                                        vistaPagar.arranca();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(ControladorMenuInicio2.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else 
                            {
                                if(ev.getActionCommand().equals(InterfazMenuInicio.MICOMPRA))
                                {
                                   if(modelo.cliente.getOrden().getEstado().equals("por cancelar"))
                                   {
                                       JOptionPane.showMessageDialog(null, "No tiene ninguna compra finalizada");
                                   }
                                   else
                                   {
                                        try
                                        {
                                            vista.setVisible(false);
                                            VistaTicketVirtual vistaBoleta = new VistaTicketVirtual();
                                            ControladorTicketVirtual control = new ControladorTicketVirtual(modelo, vistaBoleta);
                                            vistaBoleta.setControlador(control);
                                            vistaBoleta.arranca();
                                        }
                                        catch(Exception e)
                                        {
                                            System.out.println(e.getMessage());
                                        }
                                   }
                                }
                                else 
                                {
                                    if(ev.getActionCommand().equals(InterfazMenuInicio.CerrarSesion))
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
                                    else
                                    {
                                        if(ev.getActionCommand().equals(InterfazMenuInicio.INICIO))
                                        {
                                            
                                        }
                                        else
                                        {
                                            try
                                            {
                                                vista.setVisible(false);
                                                VistaMenuDelDia vistaMenuDelDia = new VistaMenuDelDia();
                                                ControladorMenuDelDia control = new ControladorMenuDelDia(modelo, vistaMenuDelDia);
                                                vistaMenuDelDia.setControlador(control);
                                                vistaMenuDelDia.arranca();
                                            }
                                            catch(Exception e)
                                            {
                                                System.out.println(e.getMessage());
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
    }
    
    public void posicionBotones()
    {
        if(modelo.cliente.getOrden().getEstado().equals("cancelado"))
        {
            Point pVYM = vista.btnVerYModificarOrden.getLocation();
            Point pPagarOrden = vista.btnRegistrarTicket.getLocation();
            Point pmiCompra = vista.btnMiCompra.getLocation();
            Point pCS = vista.btnCerrarSesion.getLocation();
            Point aux1,aux2;
            aux1 = pmiCompra;
            aux2 = pCS;
            vista.btnVerYModificarOrden.setVisible(false);
            vista.btnRegistrarTicket.setVisible(false);
            vista.btnMiCompra.setLocation(pVYM);
            vista.btnCerrarSesion.setLocation(pPagarOrden);
            vista.btnVerYModificarOrden.setLocation(aux1);
            vista.btnRegistrarTicket.setLocation(aux2);
            
        }
        else
        {
            
            if(vista.btnVerYModificarOrden.isVisible()==false &&
                    vista.btnRegistrarTicket.isVisible()==false)
            {
                Point pVYM = vista.btnVerYModificarOrden.getLocation();
                Point pPagarOrden = vista.btnRegistrarTicket.getLocation();
                Point pmiCompra = vista.btnMiCompra.getLocation();
                Point pCS = vista.btnCerrarSesion.getLocation();
                Point aux1=pmiCompra,aux2=pCS;
                
                vista.btnMiCompra.setLocation(pVYM);
                vista.btnCerrarSesion.setLocation(pPagarOrden);
                vista.btnVerYModificarOrden.setLocation(aux1);
                vista.btnRegistrarTicket.setLocation(aux2);
            
            }
        }
    }
    
}
