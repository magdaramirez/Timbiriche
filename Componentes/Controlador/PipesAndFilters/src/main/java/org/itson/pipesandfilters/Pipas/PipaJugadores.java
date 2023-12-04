/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import java.util.List;
import org.itson.Dominio.Jugador;
import org.itson.PipesAndFilters.Filtros.FiltroMarcador;

/**
 *
 * @author koine
 */
public class PipaJugadores implements Pipa<List<Jugador>, FiltroMarcador>{
    @Override
    public void pasar(List<Jugador> objeto) {
        FiltroMarcador fl = new FiltroMarcador();
        fl.procesar(objeto);
    }
}
