/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Comandos;

import org.itson.DominioSTK.CuadroSTK;
import org.itson.PipesAndFilters.Pipas.PipaCuadroSTK;

/**
 *
 * @author koine
 */
public class AsignarCuadro implements IJuegoPipa{
    private CuadroSTK cuadro;

    public AsignarCuadro(CuadroSTK cuadro) {
        this.cuadro = cuadro;
    }
    
    @Override
    public void ejecutar() {
        PipaCuadroSTK pipaC = new PipaCuadroSTK();
        pipaC.pasar(cuadro);
    }
}
