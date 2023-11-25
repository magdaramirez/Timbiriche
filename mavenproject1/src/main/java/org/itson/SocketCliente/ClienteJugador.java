/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.SocketCliente;

import org.itson.DominioSTK.MsjSocket;
import java.io.IOException;
import java.util.List;
import org.itson.Dominio.*;
import org.itson.DominioSTK.*;
import org.itson.Interfaces.IActu;
import org.itson.Interfaces.IJugador;

/**
 *
 * @author koine
 */
public class ClienteJugador implements IJugador{
    
    private static ClienteJugador instance;

    private SocketJugador socketJug;

    public ClienteJugador(Jugador jugador, IActu actualizable) {
        this.socketJug = SocketJugador.getInstance(jugador, actualizable);
    }

    @Override
    public boolean conectarAlServidor(String address, int port) {
        try {
            socketJug.conectarAlServidor(address, port);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean enviarAlServidor(Object mensaje) {
        try {
            if (mensaje instanceof Jugador) {
                Jugador jugador = (Jugador) mensaje;
                JugadorSTK mensajeNuevo = new JugadorSTK(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje());
                socketJug.enviarAlServidor(mensajeNuevo);
                return true;
            } else if (mensaje instanceof List) {
                MovimientoSTK movimiento = new MovimientoSTK();
                List<CasillaJugador> formas = (List<CasillaJugador>) mensaje;

                for (int i = 0; i < formas.size(); i++) {
                    if (i == 0) {
                        Linea linea = (Linea) formas.get(i);
                        LineaSTK formaNueva
                                = new LineaSTK(
                                        linea.getPosicion().toString(),
                                        linea.getIndice(),
                                        new JugadorSTK(
                                                linea.getJugador().getNombre(),
                                                linea.getJugador().getRutaAvatar(),
                                                linea.getJugador().getPuntaje()));
                        movimiento.setLinea(formaNueva);
                    } else {
                        Cuadro cuadro = (Cuadro) formas.get(i);
                        CuadroSTK formaNueva
                                = new CuadroSTK(
                                        cuadro.getIndice(),
                                        new JugadorSTK(
                                                cuadro.getJugador().getNombre(),
                                                cuadro.getJugador().getRutaAvatar(),
                                                cuadro.getJugador().getPuntaje()));
                        movimiento.setCuadro(formaNueva);
                    }
                }

                socketJug.enviarAlServidor(movimiento);
                return true;
            } else if (mensaje instanceof String) {
                socketJug.enviarAlServidor(mensaje);
                return true;
            } else if (mensaje instanceof MsjSocket) {
                socketJug.enviarAlServidor(mensaje);
                return true;
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public void escucharAlServidor() {
        try {
            socketJug.escucharAlServidor();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Problemas al recibir respuesta del servidor");
        }
    }
}
