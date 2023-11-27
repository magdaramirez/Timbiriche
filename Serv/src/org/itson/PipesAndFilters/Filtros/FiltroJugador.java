/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import org.itson.Dominio.Jugador;
import org.itson.DominioSTK.JugadorSTK;
import org.itson.PipesAndFilters.Pipas.PipaJugador;

/**
 *
 * @author koine
 */
public class FiltroJugador implements Filtro<JugadorSTK, Jugador, PipaJugador>{
    @Override
    public void procesar(JugadorSTK objeto) {
        Jugador jugador = new Jugador(objeto.getNombreJugador(), objeto.getRutaAvatar(),objeto.getPuntaje());
        PipaJugador pj = new PipaJugador();
        pj.pasar(jugador);
    }
}
