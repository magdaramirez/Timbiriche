/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.SckServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.DominioSTK.*;

/**
 *
 * @author koine
 */
public class SckServerThread implements Runnable{
    private volatile JugadorSTK jugadorSTK;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile List<SckServerThread> threads;
    private SckServerProtocol ssp;
    private Socket s;
    private boolean votado;
    private int MAX;

    public SckServerThread(Socket s, List<SckServerThread> threads, int MAX) throws IOException {
        this.s = s;
        this.threads = threads;
        this.votado = false;
        this.ssp = new SckServerProtocol();
        this.output = new ObjectOutputStream(s.getOutputStream());
        this.output.flush();
        this.input = new ObjectInputStream(s.getInputStream());
        this.MAX = MAX;
    }

    public void run() {
        Object mensajeEntrante;

        while (true) {
            try {

                
                mensajeEntrante = input.readObject();

                
                Object mensajeSaliente = ssp.procesarEntrada(mensajeEntrante);

                
                if (mensajeSaliente == MsjSocket.JUGADOR_NUEVO) {
                    System.out.println("Entro jugador: " + mensajeEntrante);
                    this.jugadorSTK = (JugadorSTK) mensajeEntrante;

                    
                    List<JugadorSTK> jugadores = new ArrayList<>();
                    for (SckServerThread thread : threads) {
                        jugadores.add(thread.getJugadorDTO());
                    }

                    
                    transmitirATodos(jugadores);

                    if (threads.size() == MAX) {
                        Object empezarPartida = ssp.empezarPartida(jugadores);
                        transmitirATodos(empezarPartida);
                    }

                    
                } else if (mensajeSaliente == MsjSocket.VOTO) {
                    
                    if (this.votado == false) {
                        this.votado = true;
                        mensajeSaliente = this.jugadorSTK.getNombreJugador() + " ha votado";
                        
                    } else {
                        this.votado = false;
                        mensajeSaliente = this.jugadorSTK.getNombreJugador() + " ha cancelado el voto";
                    }

                    
                    transmitirATodos(mensajeSaliente);
                } else if (mensajeSaliente instanceof MarcadorSTK) {
                    transmitirATodos(mensajeSaliente);
                } else if (mensajeSaliente instanceof RespuestaSTK) {
                    transmitirATodos(mensajeSaliente);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JugadorSTK getJugadorDTO() {
        return jugadorSTK;
    }

    public void setJugadorDTO(JugadorSTK JugadorSTK) {
        this.jugadorSTK = JugadorSTK;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public boolean isVotado() {
        return votado;
    }

    public void setVotado(boolean votado) {
        this.votado = votado;
    }

    public synchronized void transmitirASiMismo(Object mensaje) {
        try {
            this.output.writeObject(mensaje);
            this.output.flush();
        } catch (IOException ex) {
            Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void transmitirATodos(Object mensaje) {
        for (SckServerThread thread : threads) {
            try {
                thread.output.writeObject(mensaje);
                thread.output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
