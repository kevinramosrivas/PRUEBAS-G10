
package Controladores;

import java.awt.event.ActionListener;
import Modelo.*;
import Vista.Ventanas.Render;
import Vista.Ventanas.VistaTicketVirtual;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Principal.ListaDeDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.Interfaces.InterfazTicketVirtual;

/**
 *
 * @author Lenovo
 */
public class ControladorTicketVirtual implements ActionListener {
    
    private ListaDeDatos modelo;
    private VistaTicketVirtual vista;

    public ControladorTicketVirtual(ListaDeDatos modelo, VistaTicketVirtual vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        llenarTablaOrden();
        llenarTxts();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ev) {
        vista.setVisible(false);
        if(ev.getActionCommand().equals(InterfazTicketVirtual.INICIO))
        {
            VistaMenuInicio vistaInicio = new VistaMenuInicio();
            ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo, vistaInicio);
            vistaInicio.setControlador(control);
            vistaInicio.arranca();
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazTicketVirtual.CANCELAR))
            {
                try
                {
                cancelarOrdenCompra();
                JOptionPane.showMessageDialog(null, "Ticket cancelado");
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
            else // cerrar sesión
            {
                try {
                    modelo.ordenCompraDao.modificar(modelo.cliente.getOrden());
                } catch (Exception ex) {
                    Logger.getLogger(ControladorTicketVirtual.class.getName()).log(Level.SEVERE, null, ex);
                }
                modelo.cliente = null;
                VistaInicioSesionDeReserva vistaInicio = new VistaInicioSesionDeReserva();
                ControladorInicioDeSesionDeReserva control = new ControladorInicioDeSesionDeReserva(modelo, vistaInicio);
                vistaInicio.setControlador(control);
                vistaInicio.arranca();
            }
        }
    }
    
    public void cancelarOrdenCompra() throws Exception
    {
        modelo.ticketDao.eliminarTicket(modelo.cliente.getOrden(), modelo.cliente.getOrden().getTicketVirtual().getIdPago());
        modelo.pagoDao.eliminarPorId(modelo.cliente.getOrden().getTicketVirtual().getIdPago());
        modelo.productoDao.eliminarTodo(modelo.cliente.getOrden());
        modelo.ordenCompraDao.eliminar(modelo.cliente.getOrden());
        
        modelo.cliente.setOrden(null);
        
        
        modelo.ordenCompraDao.registrar(modelo.cliente);
        OrdenCompra oc = modelo.ordenCompraDao.devolverOrdenParaUsuarioNuevo(modelo.cliente);
        modelo.cliente.setOrden(oc);
    }
    
    public void limpiarTablaOrden()
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblDetalles.getModel();
        
        for(int i=0;i<=dtmOrden.getRowCount()-1;i++)
        {
            dtmOrden.setValueAt(null, i, 0);
            dtmOrden.setValueAt(null, i, 1);
            dtmOrden.setValueAt(null, i, 2);
            dtmOrden.setValueAt(null, i, 3);
        }
    }
    
    public void llenarTablaOrden() throws Exception
    {
        limpiarTablaOrden();
        DefaultTableModel dtmDestino = (DefaultTableModel)vista.tblDetalles.getModel();
        ListaEs<Producto> listaTemp = new ListaEs<Producto>();
        ListaEs.Nodo nodoAux1 = modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).padre;

        
        while(nodoAux1!=null)
        {
            if(!listaTemp.existeElemento((Producto)nodoAux1.elemento))
            {
                listaTemp.insertarFinal((Producto)nodoAux1.elemento);
            }
            nodoAux1 = nodoAux1.sgte;
        }
        
        ListaEs.Nodo nodoAux2 = listaTemp.padre;
        
        if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).cantidad!=0)
        {
            for(int i=0;i<=listaTemp.cantidad-1;i++)
            {
                Producto producto = (Producto)nodoAux2.elemento;
                for(int j=0;j<=3;j++)
                {
                    if(j==0)//nombre
                    {
                        dtmDestino.setValueAt(producto.getNombre(), i, j);
                    }
                    if(j==1)//categoria
                    {
                        dtmDestino.setValueAt(devolverCategoria(producto), i, j);
                    }
                    if(j==2)//precio
                    {
                        dtmDestino.setValueAt
                        (modelo.productoDao.devolverPrecio(producto.getNombre(), modelo.cliente.getOrden()), i, j);
                    }
                    if(j==3) // cantidad
                    {
                        dtmDestino.setValueAt(cantidadProductosRepetidos
                            (modelo.productoDao.getListaProductos(modelo.cliente.getOrden()), producto.getNombre()), i, j);
                    }
                    
            }
            nodoAux2 = nodoAux2.sgte;
            }
        }
    }
    
    public String devolverCategoria(Producto producto)
    {
        String categoria = "";
        if(producto instanceof Bebida)
        {
            categoria = "bebida";
        }
        if(producto instanceof Ensalada)
        {
            categoria = "ensalada";
        }
        if(producto instanceof Entrada)
        {
            categoria = "entrada";
        }
        if(producto instanceof Comida)
        {
            categoria = "comida";
        }
        return categoria;
    }
    
    public int cantidadProductosRepetidos(ListaEs<Producto> lista,String nombre)
    {
        int cantidad = 0;
        ListaEs.Nodo nodo = lista.padre;
        while(nodo!=null)
        {
            Producto producto = (Producto)nodo.elemento;
            if(producto.getNombre().equals(nombre))
            {
                cantidad++;
            }
            nodo = nodo.sgte;
        }
        return cantidad;
    }
    
    public void llenarTxts() throws Exception
    {
        vista.txtNombresyApellidos.setText(modelo.cliente.getNombre());
        vista.txtUsuario.setText(String.valueOf(modelo.cliente.getUsuario()));
        vista.txtMontoAPagar.setText(String.valueOf(modelo.cliente.getOrden().getTicketVirtual().getMontoAPagar()));
        vista.txtFormaPago.setText(modelo.pagoDao.devolverPagoPorId(modelo.cliente.getOrden().getTicketVirtual()).getFormaPago());
        vista.txtTipoTarjeta.setText(modelo.pagoDao.devolverPagoPorId(modelo.cliente.getOrden().getTicketVirtual()).getTipoTarjeta());
    }
    
    
    
}
