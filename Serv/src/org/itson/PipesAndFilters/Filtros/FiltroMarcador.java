/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import java.util.List;
import org.itson.Dominio.*;
import org.itson.PipesAndFilters.Pipas.PipaMarcador;

/**
 *
 * @author koine
 */
public class FiltroMarcador implements Filtro<List<Jugador>, Marcador, PipaMarcador>{
    @Override
    public void procesar(List<Jugador> objeto) {
        Marcador marcador = new Marcador(objeto);
        PipaMarcador pm = new PipaMarcador();
        pm.pasar(marcador);
    }
}
