/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.Dominio;

/**
 *
 * @author Michell Cedano
 */
public class CasillaJugador extends Forma{
        private Jugador jugador;
    private int indice;

    public CasillaJugador(int width, int height, int x, int y) {
        super(width, height, x, y);
    }

    public CasillaJugador(Jugador jugador, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.jugador = jugador;
    }

    public CasillaJugador(Jugador jugador, int indice, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.jugador = jugador;
        this.indice = indice;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "FormaJuego{" + "jugador=" + jugador + ", indice=" + indice + '}';
    }
}
