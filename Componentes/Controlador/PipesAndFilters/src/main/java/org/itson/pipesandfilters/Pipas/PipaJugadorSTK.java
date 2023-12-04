/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.DominioSTK.JugadorSTK;
import org.itson.PipesAndFilters.Filtros.FiltroJugador;

/**
 *
 * @author koine
 */
public class PipaJugadorSTK implements Pipa<JugadorSTK, FiltroJugador>{
    @Override
    public void pasar(JugadorSTK objeto) {
        FiltroJugador fl = new FiltroJugador();
        fl.procesar(objeto);
    } 
}
