/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.Dominio;

/**
 *
 * @author koine
 */
public class Marcador {
    private Jugador lider;
    private int siguiente;
    private List<Jugador> jugadores;

    public Marcador(Jugador lider) {
        this.jugadores = new ArrayList<>();
        this.lider = lider;
        this.siguiente = 0;
    }

    public Marcador(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        if (this.jugadores.get(0) != null) {
            this.lider = this.jugadores.get(0);
            this.siguiente = 0;
        }
    }

    public Jugador getLider() {
        return lider;
    }

    public void setLider(Jugador lider) {
        this.lider = lider;
    }

    public int getSiguiente() {
        int siguienteTemporal = this.siguiente;
        this.siguiente++;
        if (this.siguiente == this.jugadores.size()) {
            this.siguiente = 0;
        }
        return siguienteTemporal;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void turnar() {
        Collections.shuffle(this.jugadores);
    }

    @Override
    public String toString() {
        return "Marcador{" + "lider=" + lider + ", siguiente=" + siguiente + ", jugadores=" + jugadores + '}';
    }
}
