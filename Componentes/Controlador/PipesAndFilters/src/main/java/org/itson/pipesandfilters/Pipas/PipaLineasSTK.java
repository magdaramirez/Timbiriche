/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.DominioSTK.LineaSTK;
import org.itson.PipesAndFilters.Filtros.FiltroLineas;

/**
 *
 * @author koine
 */
public class PipaLineasSTK implements Pipa<LineaSTK, FiltroLineas>{
    
    @Override
    public void pasar(LineaSTK objeto) {
        FiltroLineas fl = new FiltroLineas();
        fl.procesar(objeto);
    }  
}
