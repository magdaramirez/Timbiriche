/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.DominioSTK;

import java.io.Serializable;

/**
 *
 * @author koine
 */
public class RespuestaSTK implements Serializable{
    private MovimientoSTK movimiento;
    private MarcadorSTK marcador;

    public RespuestaSTK(MovimientoSTK movimiento, MarcadorSTK marcador) {
        this.movimiento = movimiento;
        this.marcador = marcador;
    }

    public MovimientoSTK getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(MovimientoSTK movimiento) {
        this.movimiento = movimiento;
    }

    public MarcadorSTK getMarcador() {
        return marcador;
    }

    public void setMarcador(MarcadorSTK marcador) {
        this.marcador = marcador;
    }
}
