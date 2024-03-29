package Vista.Ventanas;


import Controladores.ControladorComidas;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import Vista.Interfaces.InterfazComidas;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frank
 */
public class VistaComidas extends javax.swing.JFrame implements InterfazComidas {

    
     imagenFondo fondo = new imagenFondo();
    
    
    public VistaComidas() {
        this.setContentPane(fondo);
        initComponents();
        btnAtrás.setActionCommand(ATRAS);
        btnInicio.setActionCommand(INICIO);
        btnRegistrarTicket.setActionCommand(PAGARORDEN);
        btnVerYModificarOrden.setActionCommand(VerYModificarOrden);
        btnMiCompra.setActionCommand(MICOMPRA);
        btnCerrarSesion.setActionCommand(CERRARSESION);
        this.setResizable(false);
        
    }
    
    
     private class imagenFondo extends JPanel
    {
        private Image imagen;
        
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenesproyecto/MenuRustico.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new imagenFondo();
        lblNombreCliente = new javax.swing.JLabel();
        lblComidas = new javax.swing.JLabel();
        spnlBebidas = new javax.swing.JScrollPane();
        tblComidas = new javax.swing.JTable();
        lblOrdenCompra = new javax.swing.JLabel();
        spnlOrdenCompra = new javax.swing.JScrollPane();
        tblNuevaOrden = new javax.swing.JTable();
        btnInicio = new javax.swing.JButton();
        btnVerYModificarOrden = new javax.swing.JButton();
        btnRegistrarTicket = new javax.swing.JButton();
        btnAtrás = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMiCompra = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 550));

        lblNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(255, 255, 255));

        lblComidas.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblComidas.setForeground(new java.awt.Color(255, 255, 255));
        lblComidas.setText("Comidas");

        tblComidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COMIDAS", "PRECIO", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComidas.setRowHeight(30);
        spnlBebidas.setViewportView(tblComidas);
        if (tblComidas.getColumnModel().getColumnCount() > 0) {
            tblComidas.getColumnModel().getColumn(1).setPreferredWidth(1);
            tblComidas.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        lblOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrdenCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblOrdenCompra.setText("MiOrdenCompra");

        tblNuevaOrden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNuevaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCTO", "CATEGORIA", "PRECIO", "CANTIDAD", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNuevaOrden.setRowHeight(30);
        spnlOrdenCompra.setViewportView(tblNuevaOrden);
        if (tblNuevaOrden.getColumnModel().getColumnCount() > 0) {
            tblNuevaOrden.getColumnModel().getColumn(0).setPreferredWidth(160);
            tblNuevaOrden.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblNuevaOrden.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblNuevaOrden.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblNuevaOrden.getColumnModel().getColumn(4).setPreferredWidth(1);
            tblNuevaOrden.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        btnInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInicio.setText("Inicio");

        btnVerYModificarOrden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerYModificarOrden.setText("Ver y Modificar Orden");

        btnRegistrarTicket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarTicket.setText("Registrar Ticket");

        btnAtrás.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtrás.setText("Atrás");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesproyecto/INICIO SESION.JPG"))); // NOI18N

        btnMiCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMiCompra.setText("Mi Compra");

        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnInicio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnVerYModificarOrden)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(spnlBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lblComidas))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtrás)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrdenCompra)
                    .addComponent(spnlOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarTicket)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMiCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap(1104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(lblOrdenCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnlOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spnlBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtrás))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblComidas)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerYModificarOrden)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMiCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VistaComidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtrás;
    public javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnMiCompra;
    public javax.swing.JButton btnRegistrarTicket;
    public javax.swing.JButton btnVerYModificarOrden;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblComidas;
    public javax.swing.JLabel lblNombreCliente;
    public javax.swing.JLabel lblOrdenCompra;
    private javax.swing.JScrollPane spnlBebidas;
    public javax.swing.JScrollPane spnlOrdenCompra;
    public javax.swing.JTable tblComidas;
    public javax.swing.JTable tblNuevaOrden;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(ControladorComidas c) {
        btnAtrás.addActionListener(c);
        btnInicio.addActionListener(c);
        btnRegistrarTicket.addActionListener(c);
        btnVerYModificarOrden.addActionListener(c);
        btnMiCompra.addActionListener(c);
        btnCerrarSesion.addActionListener(c);
        
        ControladorComidas.ClickTablaComidas cComidas = c.new ClickTablaComidas();
        ControladorComidas.ClickTablaOrden cOrden = c.new ClickTablaOrden();
        tblComidas.addMouseListener(cComidas);
        tblNuevaOrden.addMouseListener(cOrden);
        
    }

    @Override
    public void arranca() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
