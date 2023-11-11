/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters.Filtros;

/**
 *
 * @author koine
 */
public interface Filtro<I,O,P> {
    void procesar(I objeto);
}
