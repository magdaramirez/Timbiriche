/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.SckServer;

import java.util.List;

import java.util.List;
import org.itson.DominioSTK.*;
import org.itson.PipesAndFilters.*;
import org.itson.PipesAndFilters.Comandos.InvocarPanel;

/**
 *
 * @author koine
 */
public class SckServerProtocol {
    private IRepositorio rep;
    private IJuego juego;

    public SckServerProtocol() {
        this.juego = new InvocarPanel();
        this.rep = new Repositorio();
    }

    public Object procesarEntrada(Object mensajeEntrante) {

        if (mensajeEntrante instanceof JugadorSTK) {
            return MensSocket.JUGADOR_NUEVO;

        } else if (mensajeEntrante instanceof MovimientoSTK) {
            MovimientoSTK movimiento = (MovimientoSTK) mensajeEntrante;
            
            if(movimiento.getLinea() != null){
                juego.asignarLinea(movimiento.getLinea());
            }else if(movimiento.getCuadros() != null){
                for (CuadroSTK cuadro : movimiento.getCuadros()) {
                    juego.asignarCuadro(cuadro);
                }
            }
            
            RespuestaSTK respuesta = new RespuestaSTK(movimiento, rep.obtenerMarcador());
            return respuesta;
            
        } else if (mensajeEntrante == MensSocket.VOTO) {
            return MensSocket.VOTO;
        } else if (mensajeEntrante == MensSocket.TURNO_TERMINADO) {
            return rep.obtenerTurnoSiguiente();
        } else if (mensajeEntrante == MensSocket.MARCADOR) {
            return rep.obtenerMarcador();
        }
        return null;
    }

    public Object empezarPartida(List<JugadorSTK> jugadoresDTO) {
        juego.crearSala(jugadoresDTO);
        return rep.obtenerMarcador();
    }
}
