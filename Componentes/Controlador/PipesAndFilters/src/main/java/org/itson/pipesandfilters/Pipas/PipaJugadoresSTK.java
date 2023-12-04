/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import java.util.List;
import org.itson.DominioSTK.JugadorSTK;
import org.itson.PipesAndFilters.Filtros.FiltroJugadores;

/**
 *
 * @author koine
 */
public class PipaJugadoresSTK implements Pipa<List<JugadorSTK>, FiltroJugadores>{
    @Override
    public void pasar(List<JugadorSTK> objeto) {
        FiltroJugadores fj = new FiltroJugadores();
        fj.procesar(objeto);
    }
}
