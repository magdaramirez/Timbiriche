/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import javax.swing.JPanel;
import org.itson.Dominio.Jugador;
import org.itson.Utils.FormUtils;

/**
 *
 * @author magda
 */
public class FrmAvatars extends javax.swing.JFrame {

    private FrmSalaJuego sala;
    private Jugador jugador;

    /**
     * Creates new form FrmAvatars
     * @param jugador
     * @param sala
     */
    public FrmAvatars(Jugador jugador, FrmSalaJuego sala) {
        initComponents();
        this.jugador = jugador;
        this.sala = sala;
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
     * Método que despliega FrmSala
     */
    public void regresarVentanaSalaJuego() {
        FrmSalaJuego frmSalaJuego = new FrmSalaJuego();
        frmSalaJuego.setVisible(true);
        dispose();
    }

    /**
     * Metodo que establece el avatar del jugador.
     *
     * @param avatar
     * @param nombreAvatar
     */
    private void establecerAvatar(String nombreAvatar) {
        this.jugador.setRutaAvatar(nombreAvatar);
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
        btnCangrejo = new javax.swing.JButton();
        btnElefante = new javax.swing.JButton();
        btnHamster = new javax.swing.JButton();
        btnGato = new javax.swing.JButton();
        btnPerro = new javax.swing.JButton();
        btnPollo = new javax.swing.JButton();
        btnPulpo = new javax.swing.JButton();
        btnTortuga = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        pnlSalir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnListo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EligeAvatar.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        btnCangrejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cangrejo.png"))); // NOI18N
        btnCangrejo.setBorder(null);
        btnCangrejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCangrejoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCangrejo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 85, 85));

        btnElefante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/elefante.png"))); // NOI18N
        btnElefante.setToolTipText("");
        btnElefante.setBorder(null);
        btnElefante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElefanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnElefante, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 85, 85));

        btnHamster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hamster.png"))); // NOI18N
        btnHamster.setToolTipText("");
        btnHamster.setBorder(null);
        btnHamster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamsterActionPerformed(evt);
            }
        });
        jPanel1.add(btnHamster, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 85, 85));

        btnGato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gato.png"))); // NOI18N
        btnGato.setBorder(null);
        btnGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGatoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGato, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 85, 85));

        btnPerro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perro.png"))); // NOI18N
        btnPerro.setBorder(null);
        btnPerro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerroActionPerformed(evt);
            }
        });
        jPanel1.add(btnPerro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 85, 85));

        btnPollo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pollo.png"))); // NOI18N
        btnPollo.setBorder(null);
        btnPollo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPolloActionPerformed(evt);
            }
        });
        jPanel1.add(btnPollo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 85, 85));

        btnPulpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pulpo.png"))); // NOI18N
        btnPulpo.setBorder(null);
        btnPulpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulpoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPulpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 85, 85));

        btnTortuga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tortuga.png"))); // NOI18N
        btnTortuga.setBorder(null);
        btnTortuga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTortugaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTortuga, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 85, 85));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegresarLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lblRegresar)
                .addGap(14, 14, 14))
        );
        pnlRegresarLayout.setVerticalGroup(
            pnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegresarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(pnlRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalirLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
        );
        pnlSalirLayout.setVerticalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 50, -1));

        jPanel1.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        btnListo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnListo.setText("Listo");
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoActionPerformed(evt);
            }
        });
        jPanel1.add(btnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 510));

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
        regresarVentanaSalaJuego();
    }//GEN-LAST:event_pnlRegresarMouseClicked

    private void btnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoActionPerformed
        this.sala.setJugador(this.jugador);
        FormUtils.dispose( this);
    }//GEN-LAST:event_btnListoActionPerformed

    private void btnCangrejoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCangrejoActionPerformed
        this.establecerAvatar("cangrejo.png");
    }//GEN-LAST:event_btnCangrejoActionPerformed

    private void btnElefanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElefanteActionPerformed
        this.establecerAvatar("elefante.png");
    }//GEN-LAST:event_btnElefanteActionPerformed

    private void btnHamsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamsterActionPerformed
        this.establecerAvatar("hamster.png");
    }//GEN-LAST:event_btnHamsterActionPerformed

    private void btnGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGatoActionPerformed
        this.establecerAvatar("gato.png");
    }//GEN-LAST:event_btnGatoActionPerformed

    private void btnPerroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerroActionPerformed
        this.establecerAvatar("perro.png");
    }//GEN-LAST:event_btnPerroActionPerformed

    private void btnPolloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPolloActionPerformed
        this.establecerAvatar("pollo.png");
    }//GEN-LAST:event_btnPolloActionPerformed

    private void btnPulpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulpoActionPerformed
        this.establecerAvatar("pulpo.png");
    }//GEN-LAST:event_btnPulpoActionPerformed

    private void btnTortugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTortugaActionPerformed
        this.establecerAvatar("tortuga.png");
    }//GEN-LAST:event_btnTortugaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCangrejo;
    private javax.swing.JButton btnElefante;
    private javax.swing.JButton btnGato;
    private javax.swing.JButton btnHamster;
    private javax.swing.JButton btnListo;
    private javax.swing.JButton btnPerro;
    private javax.swing.JButton btnPollo;
    private javax.swing.JButton btnPulpo;
    private javax.swing.JButton btnTortuga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    // End of variables declaration//GEN-END:variables
}
