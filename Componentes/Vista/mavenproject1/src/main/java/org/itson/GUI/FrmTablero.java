/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import org.itson.Dominio.Cuadro;
import org.itson.Dominio.CasillaJugador;
import org.itson.Dominio.Jugador;
import org.itson.Dominio.Linea;
import org.itson.Dominio.Marcador;
import org.itson.Dominio.Partida;
import org.itson.Dominio.Tablero;
import java.util.List;
import org.itson.Interfaces.IActu;
import org.itson.SocketCliente.ClienteJugador;
import org.itson.Interfaces.IJugador;
import org.itson.Interfaces.PnlObservador;
import org.itson.Utils.FormUtils;

/**
 *
 * @author march
 */
public class FrmTablero extends javax.swing.JFrame implements PnlObservador, IActu {

    /**
     * Instancia de partida que cambia dentro de un hilo.
     */
    private Partida partida;

    private Jugador jugador;

    private IJugador sck;

    private PnlTablero pnlTablero;

    /**
     * Creates new form FrmTablero
     */
    public FrmTablero(Marcador marcador, Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        this.setTitle("Sala de juego - " + jugador.getNombre());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.sck = new ClienteJugador(this.jugador, this);

        //Inicializar Sala
        Tablero tablero = new Tablero(marcador.getJugadores().size());
        this.partida = new Partida(marcador, tablero, marcador.getJugadores().size());
        System.out.println(this.partida.toString());
        
        establecerColores();
//        establecerNombres();
        establecerMarcador();
        establecerTablero();
    }

//    private void establecerNombres() {
//        int numeroJugador = 1;
//        for (int i = 0; i < this.partida.getMarcador().getJugadores().size(); i++) {
//            this.partida.getMarcador().getJugadores().get(i).setNombre("Jugador "+numeroJugador);
//            numeroJugador += 1;
//        }
//    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        sck.enviarAlServidor(this.jugador);
        this.establecerColores();
        this.establecerMarcador();
    }
    
    private void establecerColores() {
        int index = this.partida.getMarcador().getJugadores().indexOf(this.jugador);
        this.partida.getMarcador().getJugadores().get(index).setColor(this.jugador.getColor());

        int indicador = 0;
        for (int i = 0; i < this.partida.getMarcador().getJugadores().size(); i++) {
            if (!this.partida.getMarcador().getJugadores().get(i).equals(this.jugador)) {
                if(indicador==0){
                    this.partida.getMarcador().getJugadores().get(i).setColor(this.jugador.getPreferencia().getColores().get(indicador));
                }
                indicador++;
            }
        }
    }

    private void establecerMarcador() {
        for (int i = 0; i < this.partida.getMarcador().getJugadores().size(); i++) {
            switch (i) {
                case 0:
                    pnlJugador1.add(new PnlJugador(this.partida.getMarcador().getJugadores().get(i)));
                    pnlJugador1.revalidate();
                    break;
                case 1:
                    pnlJugador2.add(new PnlJugador(this.partida.getMarcador().getJugadores().get(i)));
                    pnlJugador2.revalidate();
                    break;
                case 2:
                    pnlJugador3.add(new PnlJugador(this.partida.getMarcador().getJugadores().get(i)));
                    pnlJugador3.revalidate();
                    break;
                case 3:
                    pnlJugador4.add(new PnlJugador(this.partida.getMarcador().getJugadores().get(i)));
                    pnlJugador4.revalidate();
                    break;
                default:
                    break;
            }

            this.validate();

        }
    }

    private void actualizarMarcador(Marcador marcador) {
        for (int i = 0; i < this.partida.getMarcador().getJugadores().size(); i++) {
            switch (i) {
                case 0:
                    ((PnlJugador)pnlJugador1.getComponent(0)).setPuntaje(marcador.getJugadores().get(i).getPuntaje()+1);
                    pnlJugador1.revalidate();
                    break;
                case 1:
                    ((PnlJugador) pnlJugador2.getComponent(0)).setPuntaje(marcador.getJugadores().get(i).getPuntaje()+1);
                    pnlJugador2.revalidate();
                    break;
                case 2:
                    ((PnlJugador) pnlJugador3.getComponent(0)).setPuntaje(marcador.getJugadores().get(i).getPuntaje()+1);
                    pnlJugador3.revalidate();
                    break;
                case 3:
                    ((PnlJugador) pnlJugador4.getComponent(0)).setPuntaje(marcador.getJugadores().get(i).getPuntaje()+1);
                    pnlJugador4.revalidate();
                    break;
                default:
                    break;
            }

            this.validate();
        }
    }

    private void establecerTablero() {
        this.pnlTablero = new PnlTablero(this.partida.getTablero(), jugador);
        pnlTablero.agrega(this);

        pnlTablero.setSize(this.pnlFondoTablero.getSize());
        pnlTablero.setBorder(this.pnlFondoTablero.getBorder());
        this.pnlFondoTablero.add(pnlTablero);
        pnlTablero.estableceTablero();
        pnlTablero.setVisible(true);
        pnlTablero.repaint();
    }

    /**
     * Retorna la partida que se esta trabajando.
     *
     * @return
     */
    public Partida getSala() {
        return partida;
    }

    /**
     * Establece la partida de trabajo.
     *
     * @param partida
     */
    public void setSala(Partida partida) {
        this.partida = partida;
    }
    
    /**
     * Método que despliega FrmColor
     */
    public void abrirVentanaColores() {
        FrmColorPartida frmColor = new FrmColorPartida(this.jugador, this);
        FormUtils.cargarFormSinDispose(frmColor);
    }
    
    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
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
        pnlFondoTablero = new javax.swing.JPanel();
        pnlJugador1 = new javax.swing.JPanel();
        lblPuntaje = new javax.swing.JLabel();
        pnlJugador2 = new javax.swing.JPanel();
        pnlJugador4 = new javax.swing.JPanel();
        pnlJugador3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnColores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(988, 660));
        setMinimumSize(new java.awt.Dimension(988, 660));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(980, 660));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 660));
        jPanel1.setPreferredSize(new java.awt.Dimension(988, 660));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoTablero.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoTablero.setMaximumSize(new java.awt.Dimension(650, 650));
        pnlFondoTablero.setMinimumSize(new java.awt.Dimension(650, 650));
        pnlFondoTablero.setPreferredSize(new java.awt.Dimension(650, 650));

        javax.swing.GroupLayout pnlFondoTableroLayout = new javax.swing.GroupLayout(pnlFondoTablero);
        pnlFondoTablero.setLayout(pnlFondoTableroLayout);
        pnlFondoTableroLayout.setHorizontalGroup(
            pnlFondoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        pnlFondoTableroLayout.setVerticalGroup(
            pnlFondoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        jPanel1.add(pnlFondoTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 6, -1, -1));

        pnlJugador1.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador1.setMaximumSize(new java.awt.Dimension(150, 142));
        pnlJugador1.setMinimumSize(new java.awt.Dimension(150, 142));
        pnlJugador1.setPreferredSize(new java.awt.Dimension(150, 142));

        lblPuntaje.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(pnlJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pnlJugador2.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador2.setMaximumSize(new java.awt.Dimension(150, 142));
        pnlJugador2.setMinimumSize(new java.awt.Dimension(150, 142));

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(pnlJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 514, -1, -1));

        pnlJugador4.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador4.setMaximumSize(new java.awt.Dimension(150, 142));
        pnlJugador4.setMinimumSize(new java.awt.Dimension(150, 142));

        javax.swing.GroupLayout pnlJugador4Layout = new javax.swing.GroupLayout(pnlJugador4);
        pnlJugador4.setLayout(pnlJugador4Layout);
        pnlJugador4Layout.setHorizontalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        pnlJugador4Layout.setVerticalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(pnlJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 514, -1, -1));

        pnlJugador3.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador3.setMaximumSize(new java.awt.Dimension(150, 142));
        pnlJugador3.setMinimumSize(new java.awt.Dimension(150, 142));
        pnlJugador3.setPreferredSize(new java.awt.Dimension(150, 142));

        javax.swing.GroupLayout pnlJugador3Layout = new javax.swing.GroupLayout(pnlJugador3);
        pnlJugador3.setLayout(pnlJugador3Layout);
        pnlJugador3Layout.setHorizontalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlJugador3Layout.setVerticalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(pnlJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 6, -1, -1));

        btnSalir.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 99, 57));

        btnColores.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnColores.setText("Colores");
        btnColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColoresActionPerformed(evt);
            }
        });
        jPanel1.add(btnColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 99, 55));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColoresActionPerformed
        abrirVentanaColores();
    }//GEN-LAST:event_btnColoresActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salirDelPrograma();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JPanel pnlFondoTablero;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JPanel pnlJugador3;
    private javax.swing.JPanel pnlJugador4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizaSocket(Object mensaje) {
        if (mensaje instanceof Marcador) {
            System.out.println("Actualizando marcador");
            Marcador marcador = (Marcador) mensaje;
            actualizarMarcador((Marcador) mensaje);

            for (int i = 0; i < marcador.getJugadores().size(); i++) {
                if (marcador.getJugadores().indexOf(this.jugador) == marcador.getSiguiente()) {
                    this.pnlTablero.actualizaTurno(true);
                }
            }
        } else if (mensaje instanceof List) {
            List<CasillaJugador> formas = (List<CasillaJugador>) mensaje;

            for (int i = 0; i < formas.size(); i++) {
                for (Jugador jugador : this.partida.getMarcador().getJugadores()) {
                    if (jugador.equals(formas.get(i).getJugador())) {
                        formas.get(i).setJugador(jugador);
                        if (i == 0) {
                            this.pnlTablero.actualizaLineaTablero((Linea) formas.get(i));
                        } else {
                            this.pnlTablero.actualizaCuadroTablero((Cuadro) formas.get(i));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void actualiza(List<CasillaJugador> movimiento) {
        sck.enviarAlServidor(movimiento);
    }
}
