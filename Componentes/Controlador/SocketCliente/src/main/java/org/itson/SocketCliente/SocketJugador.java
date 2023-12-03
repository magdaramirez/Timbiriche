/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.SocketCliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.itson.Dominio.CasillaJugador;
import org.itson.Dominio.Cuadro;
import org.itson.Dominio.Jugador;
import org.itson.Dominio.Linea;
import org.itson.Dominio.Marcador;
import org.itson.Dominio.Posicion;
import org.itson.DominioSTK.CuadroSTK;
import org.itson.DominioSTK.JugadorSTK;
import org.itson.DominioSTK.LineaSTK;
import org.itson.DominioSTK.MarcadorSTK;
import org.itson.DominioSTK.MovimientoSTK;
import org.itson.DominioSTK.RespuestaSTK;
import org.itson.Interfaces.IActu;

/**
 *
 * @author koine
 */
public class SocketJugador implements Runnable{
    
    private Jugador jugador;
    private Socket socket;
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;
    private IActu actualizable;
    private Object objeto;

    private static SocketJugador instance;

    private SocketJugador(Jugador jugador, IActu actualizable) {
        this.jugador = jugador;
        this.actualizable = actualizable;
    }

    public static SocketJugador getInstance(Jugador jugador, IActu actualizable) {
        if (instance == null) {
            instance = new SocketJugador(jugador, actualizable);
        } else {
            instance.actualizable = actualizable;
        }
        return instance;
    }

    public synchronized void conectarAlServidor(String address, int port) throws IOException {
        socket = new Socket(address, port);
        clientOutput = new ObjectOutputStream(socket.getOutputStream());
        clientOutput.flush();
        clientInput = new ObjectInputStream(socket.getInputStream());
    }

    public synchronized void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }

    public synchronized void escucharAlServidor() throws IOException, ClassNotFoundException {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                objeto = clientInput.readObject();

                if (objeto instanceof List) {
                    List<JugadorSTK> jugadoresSTK = (List<JugadorSTK>) objeto;
                    List<Jugador> jugadores = new ArrayList<>();

                    for (JugadorSTK jugadorB : jugadoresSTK) {
                        jugadores.add(new Jugador(jugadorB.getNombreJugador(), jugadorB.getRutaAvatar(),jugadorB.getPuntaje()));
                    }

                    objeto = jugadores;
                } else if (objeto instanceof String) {
                    String string = (String) objeto;
                    objeto = string;
                } else if (objeto instanceof MarcadorSTK) {
                    MarcadorSTK marcadorSTK = (MarcadorSTK) objeto;
                    List<JugadorSTK> jugadoresSTK = marcadorSTK.getJugadores();
                    List<Jugador> jugadores = new ArrayList<>();

                    for (JugadorSTK jugadorA : jugadoresSTK) {
                        jugadores.add(new Jugador(jugadorA.getNombreJugador(), jugadorA.getRutaAvatar(), jugadorA.getPuntaje()));
                    }

                    Marcador marcador = new Marcador(jugadores);

                    objeto = marcador;
                } else if (objeto instanceof RespuestaSTK) {
                    MovimientoSTK movimiento = ((RespuestaSTK) objeto).getMovimiento();
                    List<CasillaJugador> formas = new ArrayList<>();

                    if (movimiento.getLinea() != null) {
                        LineaSTK lineaSTK = movimiento.getLinea();

                        Linea linea = new Linea(
                                Posicion.valueOf(lineaSTK.getPosicion()),
                                new Jugador(
                                        lineaSTK.getJugador().getNombreJugador(),
                                        lineaSTK.getJugador().getRutaAvatar(),
                                        lineaSTK.getJugador().getPuntaje()),
                                lineaSTK.getIndice());

                        formas.add(linea);
                    }

                    for (CuadroSTK cuadroSTK : movimiento.getCuadros()) {
                        Cuadro cuadro = new Cuadro(
                                new Jugador(
                                        cuadroSTK.getJugador().getNombreJugador(),
                                        cuadroSTK.getJugador().getRutaAvatar(),
                                        cuadroSTK.getJugador().getPuntaje()),
                                cuadroSTK.getIndice());

                        formas.add(cuadro);
                    }

                    MarcadorSTK marcadorSTK = ((RespuestaSTK) objeto).getMarcador();
                    System.out.println("MarcadorSTK " + marcadorSTK);
                    List<JugadorSTK> jugadoresSTK = marcadorSTK.getJugadores();
                    List<Jugador> jugadores = new ArrayList<>();

                    for (JugadorSTK jugador1 : jugadoresSTK) {
                        jugadores.add(new Jugador(jugador1.getNombreJugador(), jugador1.getRutaAvatar(), jugador1.getPuntaje()));
                    }

                    Marcador marcador = new Marcador(jugadores);
                    System.out.println(marcador);
                    objeto = marcador;

                    //Solo para enviar el marcador
                    mostrarCambios();

                    objeto = formas;
                }

                mostrarCambios();

                System.out.println(objeto);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SocketJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private synchronized void mostrarCambios() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                actualizable.actualizaSocket(objeto);
            }
        });
    }
}
