/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Bebida;
import Modelo.Categoria;
import Modelo.Comida;
import Modelo.Ensalada;
import Modelo.Entrada;
import Modelo.ListaEs;
import Modelo.MenuDelDia;
import Modelo.Producto;
import Principal.ListaDeDatos;
import Vista.Interfaces.InterfazBebidas;
import Vista.Interfaces.InterfazMenuDelDia;
import Vista.Ventanas.Render;
import Vista.Ventanas.VistaTicketVirtual;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import Vista.Ventanas.VistaMenuDelDia;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistrarPedido;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ControladorMenuDelDia implements ActionListener{
    
    private ListaDeDatos modelo;
    private VistaMenuDelDia vista;
    
    public ControladorMenuDelDia(ListaDeDatos modelo, VistaMenuDelDia vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        llenarTablaMenuDelDia();
        posicionBotones();
    }
  
    
    public class ClickTablaOrden implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent ev) {
            
            
            int column = vista.tblNuevaOrden.getColumnModel().getColumnIndexAtX(ev.getX());
            int row = ev.getY() / vista.tblNuevaOrden.getRowHeight();
        
            if(row < vista.tblNuevaOrden.getRowCount() && row >= 0 &&
                column < vista.tblNuevaOrden.getColumnCount() && column>=0)
            {   
            
                Object value  = vista.tblNuevaOrden.getValueAt(row, column);
                if(value instanceof JButton)
                {
                    ((JButton)value).doClick();
                    JButton boton = (JButton) value;
                
                    try
                    {
                        if(column==4) // aumentar cantidad(+)
                        {
                            agregarBebidaTablaOrden(row, column, "orden");
                        }
                        else // columns = 5 ( disminuir cantidad(-) )
                        {
                            disminuirCantidad(row, column);
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
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
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getActionCommand().equals(InterfazBebidas.INICIO))
        {
            vista.setVisible(false);
            VistaMenuInicio vistaInicio = new VistaMenuInicio();
            ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo,vistaInicio);
            vistaInicio.setControlador(control);
            vistaInicio.arranca();
        }
        else
        {
            if(ev.getActionCommand().equals(InterfazBebidas.VerYModificarOrden))
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
                if(ev.getActionCommand().equals(InterfazBebidas.PAGARORDEN))
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
                        Logger.getLogger(ControladorBebidas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    if(ev.getActionCommand().equals(InterfazBebidas.ATRAS))
                    {
                        vista.setVisible(false);
                        VistaMenuInicio vistaInicio = new VistaMenuInicio();
                        ControladorMenuInicio2 control = new ControladorMenuInicio2(modelo,vistaInicio);
                        vistaInicio.setControlador(control);
                        vistaInicio.arranca();
                    }
                    else
                    {
                        if(ev.getActionCommand().equals(InterfazBebidas.MICOMPRA))
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
                            if(ev.getActionCommand().equals(InterfazMenuDelDia.AGREGAR))
                            {
                                ListaEs.Nodo nodo = MenuDelDia.getInstancia().getListaProductos().padre;
                                while(nodo!=null)
                                {
                                    Producto p = (Producto)nodo.elemento;
                                    try
                                    {    
                                        if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).existeElemento(p))
                                        {
                                            modelo.productoDao.modificar(p.getNombre(), +1, p.getPrecio(),modelo.cliente.getOrden());
                                        }
                                        else
                                        {
                                            modelo.productoDao.registrarProductoNuevo
                                            (modelo.cliente.getOrden(), p.getNombre(), p.getPrecio(), devolverCategoria(p), 1);
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println(e.getMessage());
                                    }
                                    nodo = nodo.sgte;
                                }
                                try {
                                    llenarTablaOrdenMenuDelDia();
                                } catch (Exception ex) {
                                    Logger.getLogger(ControladorMenuDelDia.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            else
                            {
                                if(ev.getActionCommand().equals(InterfazMenuDelDia.QUITAR))
                                {
                                    ListaEs.Nodo nodo = MenuDelDia.getInstancia().getListaProductos().padre;
                                    while(nodo!=null)
                                    {
                                        Producto p = (Producto)nodo.elemento;
                                        try {
                                            modelo.productoDao.eliminar(p, modelo.cliente.getOrden());
                                        } catch (Exception ex) {
                                            Logger.getLogger(ControladorMenuDelDia.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        nodo = nodo.sgte;
                                    }
                                    try {
                                        llenarTablaOrdenMenuDelDia();
                                    } catch (Exception ex) {
                                        Logger.getLogger(ControladorMenuDelDia.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void llenarTablaMenuDelDia()
    {
        ListaEs.Nodo nodo = MenuDelDia.getInstancia().getListaProductos().padre;
        DefaultTableModel dtm = (DefaultTableModel)vista.tblMenuDelDia.getModel();
        for(int i=0;i<=3;i++)
        {
            for(int j=0;j<=2;j++)
            {
                Producto p = (Producto)nodo.elemento;
                if(j==0)
                {
                    dtm.setValueAt(p.getNombre(), i, j);
                }
                if(j==1)
                {
                    dtm.setValueAt(devolverCategoria(p).getNombreCategoria(), i, j);
                }
                if(j==2)
                {
                    dtm.setValueAt(p.getPrecio(), i, j);
                }
            }
            nodo = nodo.sgte;
        }
        
    }
    
    public void llenarTablaOrdenMenuDelDia() throws Exception
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
                        dtmDestino.setValueAt(devolverCategoria(producto).getNombreCategoria(), i, j);
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
    
    public Categoria devolverCategoria(Producto producto)
    {
        Categoria categoria = null;
        if(producto instanceof Bebida)
        {
            categoria = new Categoria("Bebidas");
            categoria.setIdCategoria(1);
        }
        if(producto instanceof Ensalada)
        {
            categoria = new Categoria("Ensaladas");
            categoria.setIdCategoria(3);
        }
        if(producto instanceof Entrada)
        {
            categoria = new Categoria("Entradas");
            categoria.setIdCategoria(4);
        }
        if(producto instanceof Comida)
        {
            categoria = new Categoria("Comidas");
            categoria.setIdCategoria(2);
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
    
    public void agregarBebidaTablaOrden(int row,int column,String tabla) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        Producto producto;
        
        String nombre = (String)dtmOrden.getValueAt(row, 0);
        String categoria = (String)dtmOrden.getValueAt(row, 1);
        float precio = (float)dtmOrden.getValueAt(row, 2);
        int cantidad = (int)dtmOrden.getValueAt(row, 3);
        producto = devolverProducto(categoria,nombre,precio,cantidad);
    
        
        if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).existeElemento(producto))
        {
            System.out.println("hola mundo ctmre");
            modelo.productoDao.modificar(producto.getNombre(), +1, producto.getPrecio(),modelo.cliente.getOrden());
        }
        else
        {
            System.out.println("AJAJJAJA CTMRE");
            modelo.productoDao.registrarProductoNuevo
            (modelo.cliente.getOrden(), producto.getNombre(), producto.getPrecio(), devolverCategoria(producto), 1);
        }
        llenarTablaOrdenMenuDelDia();
        
    }
    
    public void disminuirCantidad(int row,int column) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        String nombre = (String)dtmOrden.getValueAt(row, 0);
        String categoria = (String)dtmOrden.getValueAt(row, 1);
        float precio = (float)dtmOrden.getValueAt(row, 2);
        int cantidad = (int)dtmOrden.getValueAt(row, 3);
        Producto producto = devolverProducto(categoria, nombre, precio, cantidad);
        if(cantidadProductosRepetidos(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()), nombre)==1)
        {
            modelo.productoDao.eliminar(producto,modelo.cliente.getOrden());
        }
        else
        {
            modelo.productoDao.modificar(producto.getNombre(), -1, producto.getPrecio(),modelo.cliente.getOrden());    
        }
        
        llenarTablaOrdenMenuDelDia();
    }
    
    public Producto devolverProducto(String categoria,String nombre,float precio,int cantidad)
    {
        Producto producto = null;
        if(categoria.equals("Bebidas"))
        {
            Bebida bbda = new Bebida(nombre,precio);
            bbda.setCantidad(cantidad);
            producto = bbda;
        }
        
        if(categoria.equals("Ensaladas"))
        {
            Ensalada ensalada = new Ensalada(nombre,precio);
            ensalada.setCantidad(cantidad);
            producto = ensalada;
        }
           
        if(categoria.equals("Entradas"))
        {
            Entrada entrada = new Entrada(nombre,precio);
            entrada.setCantidad(cantidad);
            producto = entrada;
        }
        
        if(categoria.equals("Comidas"))
        {
            Comida comida = new Comida(nombre,precio);
            comida.setCantidad(cantidad);
            producto = comida;
        }
        return producto;
    }
    
    public void posicionBotones() throws Exception
    {
        llenarTablaOrdenMenuDelDia();
        if(modelo.cliente.getOrden().getEstado().equals("cancelado"))
        {
            
            vista.spnlOrdenCompra.setVisible(false);
            vista.lblOrdenCompra.setVisible(false);
            vista.jPanel1.setSize(800, 550);
            vista.setSize(800,550);
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
            
                vista.jPanel1.setSize(1300, 550);
                vista.setSize(1300,550);
            }
        }
    }
    
    
    
    
    
    
    
}
