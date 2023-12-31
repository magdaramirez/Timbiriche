/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import javax.swing.JPanel;
import org.itson.Dominio.Jugador;
import org.itson.Dominio.Marcador;
import org.itson.DominioSTK.MsjSocket;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.Interfaces.IActu;
import org.itson.SocketCliente.ClienteJugador;
import org.itson.Interfaces.IJugador;
import org.itson.Utils.FormUtils;

/**
 *
 * @author march
 */
public class FrmSalaJuego extends javax.swing.JFrame implements IActu {

    private Jugador jugador;
    private String ip;
    private int port;
    private static FrmSalaJuego instance;

    private IJugador sck;

    private int jugadoresDibujados = 0;

    /**
     * Creates new form FrmSalaJuego
     */
    public FrmSalaJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Sala de espera. Un momento");
        this.sck = new ClienteJugador(jugador, this);
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
     * Método que despliega FrmAvatars
     */
    public void abrirVentanaAvatars() {
        FrmAvatars frmAvatars = new FrmAvatars(this.jugador, this);
        FormUtils.cargarFormSinDispose(frmAvatars);
    }

    /**
     * Método que despliega FrmColor
     */
    public void abrirVentanaColores() {
        FrmColor frmColor = new FrmColor(this.jugador, this);
        FormUtils.cargarFormSinDispose(frmColor);
    }

    /**
     * Metodo para obtener una instancia única de SalaEspera, si la instancia no
     * ha sido creada, la instancia y la retorna.
     *
     * @return SalaEspera
     */
    public static FrmSalaJuego getInstance() {
        if (instance == null) {
            instance = new FrmSalaJuego();
        }
        return instance;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
        sck.enviarAlServidor(this.jugador);
    }

    public boolean ejecutarConexion(Jugador jugador, String ip, int port) {
        this.jugador = jugador;

        this.ip = ip;
        this.port = port;

        if (sck.conectarAlServidor(this.ip, this.port)) {
            System.out.println("Conectado con exito");
            sck.enviarAlServidor(this.jugador);
            sck.escucharAlServidor();
            return true;
        } else {
            System.out.println("No se pudo conectar con el servidor");
            return false;
        }
    }

    public void recibirMensaje(String mensaje) {
        lblMensajes.setText(mensaje);
        lblMensajes.revalidate();
        validate();
    }

    public void recibirJugadores(List<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            switch (i) {
                case 0:
                    this.lblAvatarJugador1.setIcon(new ImageIcon("src\\main\\resources\\img\\" + jugadores.get(i).getRutaAvatar()));
                    jugadores.get(i).setNombre("Jugador 1");
                    this.lblJugador1.setText(jugadores.get(i).getNombre());
                    break;
                case 1:
                    this.lblAvatarJugador2.setIcon(new ImageIcon("src\\main\\resources\\img\\" + jugadores.get(i).getRutaAvatar()));
                    jugadores.get(i).setNombre("Jugador 2");
                    this.lblJugador2.setText(jugadores.get(i).getNombre());
                    break;
                case 2:
                    this.lblAvatarJugador3.setIcon(new ImageIcon("src\\main\\resources\\img\\" + jugadores.get(i).getRutaAvatar()));
                    jugadores.get(i).setNombre("Jugador 3");
                    this.lblJugador3.setText(jugadores.get(i).getNombre());
                    break;
                case 3:
                    this.lblAvatarJugador4.setIcon(new ImageIcon("src\\main\\resources\\img\\" + jugadores.get(i).getRutaAvatar()));
                    jugadores.get(i).setNombre("Jugador 4");
                    this.lblJugador4.setText(jugadores.get(i).getNombre());
                    break;
                default:
                    break;
            }
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

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        pnlSalir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        pnlJugador1 = new javax.swing.JPanel();
        lblAvatarJugador1 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        pnlJugador4 = new javax.swing.JPanel();
        lblAvatarJugador4 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();
        pnlJugador3 = new javax.swing.JPanel();
        lblAvatarJugador3 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        pnlJugador2 = new javax.swing.JPanel();
        lblAvatarJugador2 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblMensajes = new javax.swing.JLabel();
        btnListo = new javax.swing.JButton();
        btnAvatars = new javax.swing.JButton();
        btnColores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(922, 582));
        setMinimumSize(new java.awt.Dimension(922, 582));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(922, 582));

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
                .addContainerGap()
                .addComponent(lblRegresar)
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        pnlSalirLayout.setVerticalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SalaJuego.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setText("Código:");

        lblCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N

        pnlJugador1.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador1.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlJugador1.setMinimumSize(new java.awt.Dimension(240, 80));

        lblAvatarJugador1.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatarJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblJugador1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlJugador4.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador4.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlJugador4.setMinimumSize(new java.awt.Dimension(240, 80));

        lblAvatarJugador4.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatarJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblJugador4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlJugador4Layout = new javax.swing.GroupLayout(pnlJugador4);
        pnlJugador4.setLayout(pnlJugador4Layout);
        pnlJugador4Layout.setHorizontalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador4Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
        pnlJugador4Layout.setVerticalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlJugador3.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador3.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlJugador3.setMinimumSize(new java.awt.Dimension(240, 80));

        lblAvatarJugador3.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatarJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblJugador3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlJugador3Layout = new javax.swing.GroupLayout(pnlJugador3);
        pnlJugador3.setLayout(pnlJugador3Layout);
        pnlJugador3Layout.setHorizontalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador3Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
        pnlJugador3Layout.setVerticalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlJugador2.setBackground(new java.awt.Color(255, 255, 255));
        pnlJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador2.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlJugador2.setMinimumSize(new java.awt.Dimension(240, 80));

        lblAvatarJugador2.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatarJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblJugador2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJugador2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlJugador2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAvatarJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        lblMensajes.setBackground(new java.awt.Color(255, 255, 255));
        lblMensajes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnListo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnListo.setText("Listo");
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoActionPerformed(evt);
            }
        });

        btnAvatars.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAvatars.setText("Avatars");
        btnAvatars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatarsActionPerformed(evt);
            }
        });

        btnColores.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnColores.setText("Colores");
        btnColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAvatars, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnColores, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnListo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnListo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvatars, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseClicked
        regresarVentanaInicio();
    }//GEN-LAST:event_pnlRegresarMouseClicked

    private void pnlRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseEntered
        cambiarColorPanel(pnlRegresar, Color.BLUE);
    }//GEN-LAST:event_pnlRegresarMouseEntered

    private void pnlRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseExited
        cambiarColorPanel(pnlRegresar, Color.WHITE);
    }//GEN-LAST:event_pnlRegresarMouseExited

    private void pnlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseClicked
        salirDelPrograma();
    }//GEN-LAST:event_pnlSalirMouseClicked

    private void pnlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseEntered
        cambiarColorPanel(pnlSalir, Color.RED);
    }//GEN-LAST:event_pnlSalirMouseEntered

    private void pnlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseExited
        cambiarColorPanel(pnlSalir, Color.WHITE);
    }//GEN-LAST:event_pnlSalirMouseExited

    private void btnAvatarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatarsActionPerformed
        abrirVentanaAvatars();
    }//GEN-LAST:event_btnAvatarsActionPerformed

    private void btnColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColoresActionPerformed
        abrirVentanaColores();
    }//GEN-LAST:event_btnColoresActionPerformed

    private void btnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoActionPerformed
        if (sck.enviarAlServidor(MsjSocket.VOTO)) {

            //Cambiar texto del boton de votar
            if (this.btnListo.getText().equals("Listo")) {
                this.btnListo.setText("Cancelar");
            } else if (this.btnListo.getText().equals("Cancelar")) {
                this.btnListo.setText("Listo");
            }

        } else {
            System.out.println("No sé :(");
        }
    }//GEN-LAST:event_btnListoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvatars;
    private javax.swing.JButton btnColores;
    private javax.swing.JButton btnListo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatarJugador1;
    private javax.swing.JLabel lblAvatarJugador2;
    private javax.swing.JLabel lblAvatarJugador3;
    private javax.swing.JLabel lblAvatarJugador4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JPanel pnlJugador3;
    private javax.swing.JPanel pnlJugador4;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    // End of variables declaration//GEN-END:variables
    @Override
    public void actualizaSocket(Object mensaje) {
        if (mensaje instanceof String) {
            recibirMensaje((String) mensaje);
        } else if (mensaje instanceof List) {
            recibirJugadores((List<Jugador>) mensaje);
        } else if (mensaje instanceof Marcador) {
            FrmTablero frmTablero = new FrmTablero((Marcador) mensaje, this.jugador);
            FormUtils.cargarForm(frmTablero, this);
        }
    }

}
