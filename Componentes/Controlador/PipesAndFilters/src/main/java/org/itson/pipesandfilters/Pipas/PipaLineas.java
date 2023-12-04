/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.Dominio.Linea;
import org.itson.PipesAndFilters.SRep;

/**
 *
 * @author koine
 */
public class PipaLineas implements Pipa<Linea, SRep>{
    
    @Override
    public void pasar(Linea objeto) {
        SRep sr = SRep.getInstance();
        sr.asignarLinea(objeto);
    }
}
