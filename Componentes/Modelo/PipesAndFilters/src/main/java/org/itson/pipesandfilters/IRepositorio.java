/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters;

import java.util.List;
import org.itson.DominioSTK.*;

/**
 *
 * @author koine
 */
public interface IRepositorio {
    MarcadorSTK obtenerMarcador();
    LineaSTK obtenerUltimaLinea();
    CuadroSTK obtenerUltimoCuadro();
    int obtenerTurnoSiguiente();
}
