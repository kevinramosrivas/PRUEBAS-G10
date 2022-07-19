
package Controladores;


import Vista.Ventanas.Render;
import Vista.Ventanas.VistaBebidas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import Vista.Interfaces.InterfazBebidas;
import Vista.Ventanas.VistaTicketVirtual;
import Vista.Ventanas.VistaMenuInicio;
import Vista.Ventanas.VistaRegistrarPedido;
import Vista.Ventanas.VistaVerYModificarOrden;
import java.awt.Point;
import javax.swing.JOptionPane;
import Principal.ListaDeDatos;
import Vista.Ventanas.VistaInicioSesionDeReserva;
import dao.factory.DaoFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ControladorBebidas implements ActionListener{

    private ListaDeDatos modelo;
    private VistaBebidas vista;

    public ControladorBebidas(ListaDeDatos modelo, VistaBebidas vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        vista.lblNombreCliente.setText("Hola, "+modelo.cliente.getNombre()+"!");
        vista.lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        llenarTablaBebidas();
        posicionBotones();
    }
    
    public class ClickTablaBebidas implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent ev) {
            int column = vista.tblBebidas.getColumnModel().getColumnIndexAtX(ev.getX());
            int row = ev.getY() / vista.tblBebidas.getRowHeight();
            
            
           
            if(row < vista.tblBebidas.getRowCount() && row >= 0 &&
                column < vista.tblBebidas.getColumnCount() && column>=0)
            {   
            
                Object value  = vista.tblBebidas.getValueAt(row, column);
                if(value instanceof JButton)
                {
                    try {
                        ((JButton)value).doClick();
                        JButton boton = (JButton) value;
                        agregarBebidaTablaOrden(row, column , "bebidas");
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorBebidas.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void llenarTablaBebidas()
    {
        ListaEs.Nodo nodo = modelo.listaBebidas.padre;
        DefaultTableModel dtm = (DefaultTableModel)vista.tblBebidas.getModel();
        int nfila=0,ncol=0;
        while(nodo!=null)
        {
            Bebida bd = (Bebida)nodo.elemento;
            dtm.setValueAt(bd.getNombre(), nfila, ncol);
            ncol++;
            dtm.setValueAt(bd.getPrecio(), nfila, ncol);
            ncol--;
            nfila++;
            nodo = nodo.sgte;
        }
        vista.tblBebidas.setDefaultRenderer(Object.class, new Render());
        JButton btn1 = new JButton("agregar");
        JButton btn2 = new JButton("agregar");
        JButton btn3 = new JButton("agregar");
        JButton btn4 = new JButton("agregar");
        JButton btn5 = new JButton("agregar");
        dtm.setValueAt(btn1, 0, 2);
        dtm.setValueAt(btn2, 1, 2);
        dtm.setValueAt(btn3, 2, 2);
        dtm.setValueAt(btn4, 3, 2);
        dtm.setValueAt(btn5, 4, 2);
    }
    
    public void llenarTablaOrdenBebidas() throws Exception
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
    
    public void agregarBebidaTablaOrden(int row,int column,String tabla) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        DefaultTableModel dtmBebidas = (DefaultTableModel)vista.tblBebidas.getModel();
        Producto producto;
        if(tabla.equals("bebidas"))
        {
            String nombre = (String)dtmBebidas.getValueAt(row, 0);
            producto = devolverBebida(nombre);
            
        }
        else
        {   
            String nombre = (String)dtmOrden.getValueAt(row, 0);
            String categoria = (String)dtmOrden.getValueAt(row, 1);
            producto = devolverProducto(categoria,nombre);
            
        }
        
        if(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()).existeElemento(producto))
        {
            modelo.productoDao.modificar(producto.getNombre(), +1, producto.getPrecio(),modelo.cliente.getOrden());
        }
        else
        {
            modelo.productoDao.registrarProductoNuevo
            (modelo.cliente.getOrden(), producto.getNombre(), producto.getPrecio(),
                    DaoFactory.getinstance().getCategoriaDao("mysql").devolverCategoria("Bebidas"), 1);
        }
        llenarTablaOrdenBebidas();
        
    }
    
    public void disminuirCantidad(int row,int column) throws Exception
    {
        DefaultTableModel dtmOrden = (DefaultTableModel)vista.tblNuevaOrden.getModel();
        String nombre = (String)dtmOrden.getValueAt(row, 0);
        String categoria = (String)dtmOrden.getValueAt(row, 1);
        Producto producto = devolverProducto(categoria, nombre);
        if(cantidadProductosRepetidos(modelo.productoDao.getListaProductos(modelo.cliente.getOrden()), nombre)==1)
        {
            modelo.productoDao.eliminar(producto,modelo.cliente.getOrden());
        }
        else
        {
            modelo.productoDao.modificar(producto.getNombre(), -1, producto.getPrecio(),modelo.cliente.getOrden());    
        }
        
        llenarTablaOrdenBebidas();
    }
    
    public Bebida devolverBebida(String nombreBebida)
    {
        
        ListaEs.Nodo nodo = modelo.listaBebidas.padre;
        Bebida bebida = null;
        while(nodo!=null)
        {
            Bebida bbda = (Bebida)nodo.elemento;
            if(bbda.getNombre().equals(nombreBebida))
            {
                bebida = bbda;
                break;
            }
            nodo = nodo.sgte;
        }
        return bebida;
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
    
    
    public void posicionBotones() throws Exception
    {
        llenarTablaOrdenBebidas();
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
