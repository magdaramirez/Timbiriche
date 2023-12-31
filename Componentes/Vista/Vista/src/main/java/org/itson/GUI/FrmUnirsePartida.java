/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.itson.Dominio.Jugador;
import org.itson.Dominio.Preferencia;

/**
 *
 * @author magda
 */
public class FrmUnirsePartida extends javax.swing.JFrame {

    /**
     * Creates new form FrmUnirsePartida
     */
    public FrmUnirsePartida() {
        initComponents();
    }

    /**
     * Método que establece el color del fondo de un JPanel.
     *
     * @param panel JPanel cuyo color de fondo va a cambiar.
     * @param color Color a poner de fondo.
     */
    public void cambiarColorPanel(JPanel panel, Color color) {
        panel.setBackground(color);
    }

    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
    }
    
    /**
     * Método que despliega FrmInicio
     */
    public void regresarVentanaInicio() {
        FrmInicio frmInicio = new FrmInicio();
        frmInicio.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnUnirse = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        pnlSalir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblipSala = new javax.swing.JLabel();
        txtipSala = new javax.swing.JTextField();
        lblCodigo1 = new javax.swing.JLabel();
        cmbNombre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UnirsePartida.png"))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblCodigo.setText("Nombre:");

        txtCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N

        btnUnirse.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUnirse.setText("Unirse");
        btnUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirseActionPerformed(evt);
            }
        });

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRegresar.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseExited(evt);
            }
        });

        lblRegresar.setBackground(new java.awt.Color(255, 255, 255));
        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Regresar.png"))); // NOI18N

        javax.swing.GroupLayout pnlRegresarLayout = new javax.swing.GroupLayout(pnlRegresar);
        pnlRegresar.setLayout(pnlRegresarLayout);
        pnlRegresarLayout.setHorizontalGroup(
            pnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegresarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRegresar)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pnlRegresarLayout.setVerticalGroup(
            pnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegresarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(pnlRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 50, -1));

        pnlSalir.setBackground(new java.awt.Color(255, 255, 255));
        pnlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSalirMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salir.png"))); // NOI18N

        javax.swing.GroupLayout pnlSalirLayout = new javax.swing.GroupLayout(pnlSalir);
        pnlSalir.setLayout(pnlSalirLayout);
        pnlSalirLayout.setHorizontalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalirLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlSalirLayout.setVerticalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 60, -1));

        lblipSala.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblipSala.setText("IP sala:");

        txtipSala.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N

        lblCodigo1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblCodigo1.setText("Código:");

        cmbNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "jugador 2", "jugador 3", "jugador 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btnUnirse, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblipSala)
                                        .addComponent(lblCodigo1))
                                    .addComponent(lblCodigo))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtipSala, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(323, 323, 323))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(cmbNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtipSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblipSala))
                .addGap(27, 27, 27)
                .addComponent(btnUnirse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseClicked
        salirDelPrograma();
    }//GEN-LAST:event_pnlSalirMouseClicked

    private void pnlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseEntered
        cambiarColorPanel(pnlSalir, Color.RED);
    }//GEN-LAST:event_pnlSalirMouseEntered

    private void pnlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseExited
        cambiarColorPanel(pnlSalir, Color.WHITE);
    }//GEN-LAST:event_pnlSalirMouseExited

    private void pnlRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseEntered
        cambiarColorPanel(pnlRegresar, Color.BLUE);
    }//GEN-LAST:event_pnlRegresarMouseEntered

    private void pnlRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseExited
        cambiarColorPanel(pnlRegresar, Color.WHITE);
    }//GEN-LAST:event_pnlRegresarMouseExited

    private void pnlRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseClicked
        regresarVentanaInicio();
    }//GEN-LAST:event_pnlRegresarMouseClicked

    private void btnUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirseActionPerformed
        String ip = null, port = null, nombre="";
        
        nombre = this.cmbNombre.getSelectedItem().toString();
        port = this.txtCodigo.getText().toString();
        ip =  this.txtipSala.getText().toString();
        
        Jugador jugador = new Jugador(nombre, "perro.png",0);
        Preferencia pref = new Preferencia("#0099FF", "#FF3399", "#FFFF33");
        jugador.setPreferencia(pref);
        jugador.setColor("#33FF00");
        
        
        FrmSalaJuego salaJuego = FrmSalaJuego.getInstance();
        if(salaJuego.ejecutarConexion(jugador, ip, Integer.valueOf(port))){
            salaJuego.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo realizar la conexión con el servidor", "Fallo de Conexión", JOptionPane.ERROR_MESSAGE);
            salaJuego = null;
        }
    }//GEN-LAST:event_btnUnirseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUnirse;
    private javax.swing.JComboBox<String> cmbNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblipSala;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtipSala;
    // End of variables declaration//GEN-END:variables
}
