/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.PipesAndFilters.Filtros.FiltroSala;

/**
 *
 * @author koine
 */
public class PipaSize implements Pipa<Integer, FiltroSala>{
    @Override
    public void pasar(Integer objeto) {
        FiltroSala ft = new FiltroSala();
        ft.procesar(objeto);
    }
}
