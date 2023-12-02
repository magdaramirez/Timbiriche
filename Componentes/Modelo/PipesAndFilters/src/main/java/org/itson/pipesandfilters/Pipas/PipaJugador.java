/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.Dominio.Jugador;
import org.itson.PipesAndFilters.SRep;

/**
 *
 * @author koine
 */
public class PipaJugador implements Pipa<Jugador, SRep>{
    @Override
    public void pasar(Jugador objeto) {
        SRep sr = SRep.getInstance();
        sr.retirarJugador(objeto);
        
    }
}
