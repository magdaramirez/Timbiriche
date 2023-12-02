/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.DominioSTK.CuadroSTK;
import org.itson.PipesAndFilters.Filtros.FiltroCuadro;

/**
 *
 * @author koine
 */
public class PipaCuadroSTK implements Pipa<CuadroSTK, FiltroCuadro>{
    @Override
    public void pasar(CuadroSTK objeto) {
        FiltroCuadro fc = new FiltroCuadro();
        fc.procesar(objeto);
    }
}
