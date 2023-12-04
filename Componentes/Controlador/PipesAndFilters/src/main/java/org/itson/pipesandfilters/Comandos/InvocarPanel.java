/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Comandos;

import org.itson.PipesAndFilters.Comandos.*;
import java.util.List;
import org.itson.DominioSTK.*;
import org.itson.PipesAndFilters.IJuego;

/**
 *
 * @author koine
 */
public class InvocarPanel implements IJuego{
    IJuegoPipa com;

    @Override
    public void crearSala(List<JugadorSTK> jugadores) {
        com = new CrearJuegoPanel(jugadores);
        com.ejecutar();
    }

    @Override
    public void asignarLinea(LineaSTK linea) {
        com = new AsignarLinea(linea);
        com.ejecutar();
    }

    @Override
    public void asignarCuadro(CuadroSTK cuadro) {
        com = new AsignarCuadro(cuadro);
        com.ejecutar();
    }

    @Override
    public void retirarJugador(JugadorSTK jugador) {
        com = new RetirarJugador(jugador);
        com.ejecutar();
    }   
}
