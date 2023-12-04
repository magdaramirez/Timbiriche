/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Comandos;

import org.itson.DominioSTK.JugadorSTK;
import org.itson.PipesAndFilters.Pipas.PipaJugadorSTK;

/**
 *
 * @author koine
 */
public class RetirarJugador implements IJuegoPipa{
    private JugadorSTK jugador;

    public RetirarJugador(JugadorSTK jugador) {
        this.jugador = jugador;
    }

    @Override
    public void ejecutar() {
        PipaJugadorSTK pj = new PipaJugadorSTK();
        pj.pasar(jugador);
    }
}
