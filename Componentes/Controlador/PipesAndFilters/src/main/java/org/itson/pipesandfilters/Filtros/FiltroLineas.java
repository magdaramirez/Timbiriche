/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import org.itson.Dominio.*;
import org.itson.DominioSTK.LineaSTK;
import org.itson.PipesAndFilters.Pipas.PipaLineas;

/**
 *
 * @author koine
 */
public class FiltroLineas implements Filtro<LineaSTK, Linea, PipaLineas>{
    @Override
    public void procesar(LineaSTK objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador(), objeto.getJugador().getRutaAvatar());
        Linea linea = new Linea(Posicion.valueOf(objeto.getPosicion()), jugador, objeto.getIndice());
        PipaLineas pl = new PipaLineas();
        pl.pasar(linea);
    }
}
