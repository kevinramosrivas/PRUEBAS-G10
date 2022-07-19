package Vista.Ventanas;

import Controladores.ControladorInicioDeSesionDeReserva;
import Controladores.ControladorMenuInicio2;
import Modelo.*;
import Vista.Interfaces.InterfazInicioSesion;
import static Vista.Interfaces.InterfazInicioSesion.INGRESAR;
import static Vista.Interfaces.InterfazInicioSesion.REGISTRATE;
import static Vista.Interfaces.InterfazInicioSesion.mostrarContraseña;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class VistaInicioSesionDeReserva 
extends javax.swing.JFrame implements InterfazInicioSesion 
{

    imagenFondo fondo = new imagenFondo();
    
    public VistaInicioSesionDeReserva() {
        this.setContentPane(fondo);
        initComponents();
        btnIngresar.setActionCommand(INGRESAR);
        btnRegistrateInicio.setActionCommand(REGISTRATE);
        rbtnMostrarContraseña.setActionCommand(mostrarContraseña);
        this.ocultarLbls();
        this.setResizable(false);
    }
    
    private class imagenFondo extends JPanel
    {
        private Image imagen;
        
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenesproyecto/fondoLogin.jpg")).getImage();
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
        jLabel1 = new javax.swing.JLabel();
        txtUsuarioInicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrateInicio = new javax.swing.JButton();
        lblResultadoInicio = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        rbtnMostrarContraseña = new javax.swing.JRadioButton();
        pfContraseña = new javax.swing.JPasswordField();
        lblRelleneCamposFaltantes = new javax.swing.JLabel();
        lblast2 = new javax.swing.JLabel();
        lblast1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("INICIO DE SESION DE RESERVA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setText("Ingresar");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No tienes una cuenta?");

        btnRegistrateInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrateInicio.setText("Regístrate");

        lblResultadoInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResultadoInicio.setForeground(new java.awt.Color(255, 51, 51));
        lblResultadoInicio.setText("¡datos incorrectos!");

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("Salir");

        rbtnMostrarContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnMostrarContraseña.setText("Mostrar contraseña");

        lblRelleneCamposFaltantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRelleneCamposFaltantes.setForeground(new java.awt.Color(255, 51, 51));
        lblRelleneCamposFaltantes.setText("¡rellene los campos faltantes!(*)");

        lblast2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblast2.setForeground(new java.awt.Color(255, 51, 51));
        lblast2.setText("*");

        lblast1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblast1.setForeground(new java.awt.Color(255, 51, 51));
        lblast1.setText("*");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesproyecto/INICIO SESION.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(286, 286, 286))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(lblast1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblast2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRelleneCamposFaltantes))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(rbtnMostrarContraseña))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblResultadoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrateInicio))
                            .addComponent(jLabel2))
                        .addContainerGap(193, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblast1))
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnMostrarContraseña)
                    .addComponent(lblast2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(lblResultadoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrateInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(lblRelleneCamposFaltantes))
                .addGap(78, 78, 78))
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
            java.util.logging.Logger.getLogger(VistaInicioSesionDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesionDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesionDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesionDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /* */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIngresar;
    public javax.swing.JButton btnRegistrateInicio;
    public javax.swing.JButton btnSalir;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblRelleneCamposFaltantes;
    public javax.swing.JLabel lblResultadoInicio;
    public javax.swing.JLabel lblast1;
    public javax.swing.JLabel lblast2;
    public javax.swing.JPasswordField pfContraseña;
    public javax.swing.JRadioButton rbtnMostrarContraseña;
    public javax.swing.JTextField txtUsuarioInicio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(ControladorInicioDeSesionDeReserva c) {
        btnIngresar.addActionListener((ActionListener) c);
        btnRegistrateInicio.addActionListener((ActionListener) c);
        btnSalir.addActionListener((ActionListener) c);
        rbtnMostrarContraseña.addActionListener((ActionListener) c);
    }
    @Override
    public void arranca() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void ocultarLbls() {
        this.lblResultadoInicio.setVisible(false);
        this.lblast1.setVisible(false);
        this.lblast2.setVisible(false);
        this.lblRelleneCamposFaltantes.setVisible(false);
    }
    @Override
    public boolean faltanLlenarDatos() {
        boolean falta = false;
        if(this.txtUsuarioInicio.getText().isEmpty() || this.pfContraseña.getText().isEmpty())
        {
            falta = true;
        }
        return falta;
    }
}