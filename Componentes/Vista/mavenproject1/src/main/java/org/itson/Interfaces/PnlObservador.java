/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.Interfaces;

import org.itson.Dominio.CasillaJugador;
import java.util.List;

/**
 *
 * @author march
 */
public interface PnlObservador {
    void actualiza(List<CasillaJugador> movimiento);
}