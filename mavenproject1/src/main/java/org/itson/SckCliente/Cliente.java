/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.SckCliente;

import org.itson.Interfaces.IActualizable;
import org.itson.Interfaces.ICliente;
import org.itson.Dominio.Cuadro;
import org.itson.Dominio.CasillaJugador;
import org.itson.Dominio.Jugador;
import org.itson.Dominio.Linea;
import org.itson.DominioDTO.CuadroDTO;
import org.itson.DominioDTO.JugadorDTO;
import org.itson.DominioDTO.LineaDTO;
import org.itson.DominioDTO.MensajeSockets;
import org.itson.DominioDTO.MovimientoDTO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author march
 */
public class Cliente implements ICliente {

    private static Cliente instance;

    private SckClient sckCliente;

    public Cliente(Jugador jugador, IActualizable actualizable) {
        this.sckCliente = SckClient.getInstance(jugador, actualizable);
    }

    @Override
    public boolean conectarAlServidor(String address, int port) {
        try {
            sckCliente.conectarAlServidor(address, port);
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
                JugadorDTO mensajeNuevo = new JugadorDTO(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje());
                sckCliente.enviarAlServidor(mensajeNuevo);
                return true;
            } else if (mensaje instanceof List) {
                MovimientoDTO movimiento = new MovimientoDTO();
                List<CasillaJugador> formas = (List<CasillaJugador>) mensaje;

                for (int i = 0; i < formas.size(); i++) {
                    if (i == 0) {
                        Linea linea = (Linea) formas.get(i);
                        LineaDTO formaNueva
                                = new LineaDTO(
                                        linea.getPosicion().toString(),
                                        linea.getIndice(),
                                        new JugadorDTO(
                                                linea.getJugador().getNombre(),
                                                linea.getJugador().getRutaAvatar(),
                                                linea.getJugador().getPuntaje()));
                        movimiento.setLinea(formaNueva);
                    } else {
                        Cuadro cuadro = (Cuadro) formas.get(i);
                        CuadroDTO formaNueva
                                = new CuadroDTO(
                                        cuadro.getIndice(),
                                        new JugadorDTO(
                                                cuadro.getJugador().getNombre(),
                                                cuadro.getJugador().getRutaAvatar(),
                                                cuadro.getJugador().getPuntaje()));
                        movimiento.setCuadro(formaNueva);
                    }
                }

                sckCliente.enviarAlServidor(movimiento);
                return true;
            } else if (mensaje instanceof String) {
                sckCliente.enviarAlServidor(mensaje);
                return true;
            } else if (mensaje instanceof MensajeSockets) {
                sckCliente.enviarAlServidor(mensaje);
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
            sckCliente.escucharAlServidor();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Problemas al recibir la respuesta del servidor");
        }
    }
}
