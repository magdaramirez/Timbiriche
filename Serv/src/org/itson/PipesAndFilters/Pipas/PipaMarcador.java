/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Pipas;

import org.itson.Dominio.Marcador;
import org.itson.PipesAndFilters.SRep;

/**
 *
 * @author koine
 */
public class PipaMarcador implements Pipa<Marcador, SRep>{
    
    @Override
    public void pasar(Marcador objeto) {
        SRep sr = SRep.getInstance();
        sr.asignarMarcador(objeto);
    }
}
