/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Comandos;

import org.itson.DominioSTK.LineaSTK;
import org.itson.PipesAndFilters.Pipas.PipaLineasSTK;

/**
 *
 * @author koine
 */
public class AsignarLinea implements IJuegoPipa{
      private LineaSTK linea;

    public AsignarLinea(LineaSTK linea) {
        this.linea = linea; 
    }

    @Override
    public void ejecutar() {
        PipaLineasSTK pl = new PipaLineasSTK();
        pl.pasar(linea);
    }    
}
