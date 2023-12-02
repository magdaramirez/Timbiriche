/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.Dominio.Cuadro;
import org.itson.PipesAndFilters.SRep;

/**
 *
 * @author koine
 */
public class PipaCuadro implements Pipa<Cuadro, SRep>{
    @Override
    public void pasar(Cuadro objeto) {
        SRep sr = SRep.getInstance();
        sr.asignarCuadro(objeto);
    }   
}
