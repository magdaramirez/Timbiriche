/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

import org.itson.Dominio.*;
import org.itson.DominioSTK.CuadroSTK;
import org.itson.PipesAndFilters.Pipas.PipaCuadro;

/**
 *
 * @author koine
 */
public class FiltroCuadro implements Filtro<CuadroSTK, Cuadro, PipaCuadro>{
    @Override
    public void procesar(CuadroSTK objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador(), objeto.getJugador().getRutaAvatar(),objeto.getJugador().getPuntaje());
        
        Cuadro cuadro = new Cuadro(jugador, objeto.getIndice());
        PipaCuadro pc = new PipaCuadro();
        pc.pasar(cuadro);
    } 
}
