/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.DominioSTK;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author koine
 */
public class MarcadorSTK implements Serializable{
    private List<JugadorSTK> jugadores;
    private int siguiente;

    public MarcadorSTK(List<JugadorSTK> jugadores) {
        this.jugadores = jugadores;
        this.siguiente = 0;
    }

    public MarcadorSTK(List<JugadorSTK> jugadores, int siguiente) {
        this.jugadores = jugadores;
        this.siguiente = siguiente;
    }

    public List<JugadorSTK> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorSTK> jugadores) {
        this.jugadores = jugadores;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "MarcadorSTK{" + "jugadores=" + jugadores + ", siguiente=" + siguiente + '}';
    }
}
