/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import java.util.ArrayList;
import java.util.List;
import org.itson.Dominio.Jugador;
import org.itson.DominioSTK.JugadorSTK;
import org.itson.PipesAndFilters.Pipas.PipaJugadores;

/**
 *
 * @author koine
 */
public class FiltroJugadores implements Filtro<List<JugadorSTK>, List<Jugador>, PipaJugadores>{
    @Override
    public void procesar(List<JugadorSTK> objeto) {
        List<Jugador> jugadores = new ArrayList<>();
        for (JugadorSTK jugadorSTK : objeto) {

            Jugador jugador = new Jugador(jugadorSTK.getNombreJugador(), 
                    jugadorSTK.getRutaAvatar(),jugadorSTK.getPuntaje());
            jugadores.add(jugador);
        }
        PipaJugadores pipaJ = new PipaJugadores();
        pipaJ.pasar(jugadores);
    }
}
