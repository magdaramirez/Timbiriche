/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.DominioSTK;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author koine
 */
public class LineaSTK implements Serializable{
    private String posicion;
    private int indice;
    private JugadorSTK jugador;

    public LineaSTK(String posicion, int indice) {
        this.posicion = posicion;
        this.indice = indice;
    }

    public LineaSTK(String posicion, int indice, JugadorSTK jugador) {
        this.posicion = posicion;
        this.indice = indice;
        this.jugador = jugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public JugadorSTK getJugador() {
        return jugador;
    }

    public void setJugador(JugadorSTK jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.posicion);
        hash = 79 * hash + this.indice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineaSTK other = (LineaSTK) obj;
        if (this.indice != other.indice) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LineaSTK{" + posicion + ", " + indice + ", " + jugador + ")";
    }
}
