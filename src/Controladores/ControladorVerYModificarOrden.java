/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import Vista.Interfaces.InterfazVerYModificarOrden;
import Vista.Ventanas.Render;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistrarPedido;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Principal.ListaDeDatos;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lenovo
 */
public class ControladorVerYModificarOrden implements ActionListener,MouseListener{

    private ListaDeDatos modelo;
    private VistaVerYModificarOrden vista;

    public ControladorVerYModificarOrden(ListaDeDatos modelo, VistaVerYModificarOrden vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        vista.txtMontoTotal.setText(Float.toString(calcularMontoTotal())+" soles");
        llenarTablaOrden();
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getActionCommand().equals(InterfazVerYModificarOrden.INICIO))
        {
            vista.setVisible(false);
            VistaMenuInicio vistaInicio = new VistaMenuInicio();
            ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo,vistaInicio);
            vistaInicio.setControlador(control);
            vistaInicio.arranca();
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazVerYModificarOrden.PAGARORDEN))
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
                    Logger.getLogger(ControladorVerYModificarOrden.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else //cerrar sesion
            {
                if(ev.getActionCommand().equals(InterfazVerYModificarOrden.VerYModificarOrden))
                {
                    //any
                }
                else
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

    @Override
    public void mouseClicked(MouseEvent evt) {
        
        int column = vista.tblNuevaOrden.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / vista.tblNuevaOrden.getRowHeight();
        if(row < vista.tblNuevaOrden.getRowCount() && row >= 0 &&
            column < vista.tblNuevaOrden.getColumnCount() && column>=0)
        {

            Object value  = vista.tblNuevaOrden.getValueAt(row, column);
            if(value instanceof JButton)
            {
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(column==4) // aumentar cantidad(+)
                {
                    try {
                        agregarProductoTablaOrden(row, column);
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorVerYModificarOrden.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else // columns = 5 ( disminuir cantidad(-) )
                {
                    try {
                        disminuirCantidad(row, column);
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorVerYModificarOrden.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void limpiarTablaOrden()
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        
        for(int i=0;i<=dtmOrden.getRowCount()-1;i++)
        {
            dtmOrden.setValueAt(null, i, 0);
            dtmOrden.setValueAt(null, i, 1);
            dtmOrden.setValueAt(null, i, 2);
            dtmOrden.setValueAt(null, i, 3);
            dtmOrden.setValueAt(null, i, 4);
            dtmOrden.setValueAt(null, i, 5);
        }
    }
    
    public void llenarTablaOrden() throws Exception
    {
        limpiarTablaOrden();
        JButton btn1 = new JButton("+");
        JButton btn2 = new JButton("-");
        DefaultTableModel dtmDestino = (DefaultTableModel)vista.tblNuevaOrden.getModel();
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
                for(int j=0;j<=5;j++)
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
                    if(j==4) // + 
                    {
                        vista.tblNuevaOrden.setDefaultRenderer(Object.class, new Render());
                        dtmDestino.setValueAt(btn1, i, j);
                    }
                    if(j==5) // -
                    {
                        vista.tblNuevaOrden.setDefaultRenderer(Object.class, new Render());
                        dtmDestino.setValueAt(btn2, i, j);
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
    
    public void agregarProductoTablaOrden(int row,int column) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        String categoria = (String)dtmOrden.getValueAt(row, 1);
        String nombre = (String)dtmOrden.getValueAt(row, 0);
        Producto producto = devolverProducto(categoria, nombre);
        if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).existeElemento(producto))
        {
            modelo.productoDao.modificar(producto.getNombre(), +1, producto.getPrecio(),modelo.cliente.getOrden());
        }
        else
        {
            modelo.productoDao.registrarProductoNuevo
            (modelo.cliente.getOrden(), producto.getNombre(), producto.getPrecio(), 
                    modelo.categoriaDao.devolverCategoria(categoria), 1);
        }
        vista.txtMontoTotal.setText(Float.toString(calcularMontoTotal())+" soles");
        llenarTablaOrden();
    }
    
    public void disminuirCantidad(int row,int column) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        int cantidad = (int)dtmOrden.getValueAt(row, 3) - 1;
        String categoria = (String)dtmOrden.getValueAt(row, 1);
        String nombre = (String)dtmOrden.getValueAt(row, 0);
        Producto producto = devolverProducto(categoria, nombre);
        if(cantidadProductosRepetidos(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()), nombre)==1)
        {
            modelo.productoDao.eliminar(producto,modelo.cliente.getOrden());
        }
        else
        {
            modelo.productoDao.modificar(producto.getNombre(), -1, producto.getPrecio(),modelo.cliente.getOrden());    
        }
        vista.txtMontoTotal.setText(Float.toString(calcularMontoTotal())+" soles");
        llenarTablaOrden();
    }
    
    public Producto devolverProducto(String categoria,String nombre)
    {
        Producto producto = null;
        if(categoria.equals("bebida"))
        {
            ListaEs.Nodo nodo = modelo.listaBebidas.padre;
            Bebida bebida = null;
            while(nodo!=null)
            {
                Bebida auxBebida = (Bebida)nodo.elemento;
                if(auxBebida.getNombre().equals(nombre))
                {
                    bebida = auxBebida;
                    break;
                }
                nodo = nodo.sgte;
            }
            producto = bebida;
        }
        
        if(categoria.equals("ensalada"))
        {
            ListaEs.Nodo nodo = modelo.listaEnsaladas.padre;
            Ensalada ensalada = null;
            while(nodo!=null)
            {
                Ensalada auxEnsalada = (Ensalada)nodo.elemento;
                if(auxEnsalada.getNombre().equals(nombre))
                {
                    ensalada = auxEnsalada;
                    break;
                }
                nodo = nodo.sgte;
            }
            producto = ensalada;
        }
           
        if(categoria.equals("entrada"))
        {
            ListaEs.Nodo nodo = modelo.listaEntradas.padre;
            Entrada entrada = null;
            while(nodo!=null)
            {
                Entrada auxEntrada = (Entrada)nodo.elemento;
                if(auxEntrada.getNombre().equals(nombre))
                {
                    entrada = auxEntrada;
                    break;
                    }
                    nodo = nodo.sgte;
                }
                producto = entrada;
        }
        
        if(categoria.equals("comida"))
        {
            ListaEs.Nodo nodo = modelo.listaComidas.padre;
            Comida comida = null;
            while(nodo!=null)
            {
                Comida auxComida = (Comida)nodo.elemento;
                if(auxComida.getNombre().equals(nombre))
                {
                    comida = auxComida;
                    break;
                }
                nodo = nodo.sgte;
            }
            producto = comida;
        }
        return producto;
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
