/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import org.itson.Dominio.Tablero;
import org.itson.PipesAndFilters.Pipas.PipaSala;

/**
 *
 * @author koine
 */
public class FiltroSala implements Filtro<Integer, Tablero, PipaSala>{
    @Override
    public void procesar(Integer objeto) {
        //
        Tablero tablero = new Tablero(objeto);
        tablero.generaInstanciasDeFormaJuego();
        PipaSala pt = new PipaSala();
        pt.pasar(tablero);
    }
}
