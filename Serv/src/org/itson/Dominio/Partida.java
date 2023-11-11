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
public class Partida {
    private Tablero tablero;
    private Marcador marcador;
    private int tamanio;
    
    /**
     * 
     */
    public Partida() {
    }

    /**
     * Constructor de sala, que genera el tamaño de la misma segun los jugadores que jugaran
     * @param marcador
     * @param tablero
     * @param tamanio 
     */
    public Partida(Marcador marcador, Tablero tablero, int tamanio) {
        this.tablero = tablero;
        this.marcador = marcador;
        this.tamanio = tamanio;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    public void agregarJugador(Jugador jugador){
        if(this.marcador.getJugadores().size() < this.tamanio){
            this.marcador.getJugadores().add(jugador);
        }
    }
    
    public void eliminarJugador(Jugador jugador){
        this.marcador.getJugadores().remove(jugador);
    }
}
