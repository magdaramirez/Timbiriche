/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Comandos;

import java.util.List;
import org.itson.DominioSTK.JugadorSTK;

/**
 *
 * @author koine
 */
public class CrearJuegoPanel implements IJuegoPipa{
    private List<JugadorSTK> jugadores;

    public CrearJuegoPanel(List<JugadorSTK> jugadores) {
        this.jugadores = jugadores;
    }
    
    @Override
    public void ejecutar() {
        
    }
}
