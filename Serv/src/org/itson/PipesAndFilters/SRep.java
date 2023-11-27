/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters;

import org.itson.Dominio.*;

/**
 *
 * @author koine
 */
public class SRep {
    private volatile static SRep instance;
    private volatile Partida partida;
    private volatile Linea ultimaLinea;
    private volatile Cuadro ultimoCuadro;

    private SRep() {
        partida = new Partida();
    }

    public static synchronized SRep getInstance() {
        if (instance == null) {
            instance = new SRep();
        }
        return instance;
    }

    public synchronized void asignarMarcador(Marcador marcador) {
        this.partida.setMarcador(marcador);
    }

    public synchronized void asignarTablero(Tablero tablero) {
        this.partida.setTablero(tablero);
    }

    public synchronized void asignarLinea(Linea linea) {
        if(linea.getPosicion() == Posicion.HORIZONTAL){
            this.partida.getTablero().getLineasHorizontales().get(linea.getIndice()).setJugador(linea.getJugador());
            this.ultimaLinea = this.partida.getTablero().getLineasHorizontales().get(linea.getIndice());
        }else if(linea.getPosicion() == Posicion.VERTICAL){
            this.partida.getTablero().getLineasVerticales().get(linea.getIndice()).setJugador(linea.getJugador());
            this.ultimaLinea = this.partida.getTablero().getLineasVerticales().get(linea.getIndice());
        }
    }

    public synchronized void asignarCuadro(Cuadro cuadro) {
        int puntaje;
        for (Jugador jugador : this.partida.getMarcador().getJugadores()) {
            if(jugador.equals(cuadro.getJugador())){
                puntaje=jugador.getPuntaje();
                puntaje = puntaje+1;
                jugador.setPuntaje(puntaje);
                this.partida.getTablero().getCuadros().get(cuadro.getIndice()).setJugador(jugador);
                this.ultimoCuadro = this.partida.getTablero().getCuadros().get(cuadro.getIndice());
            }
        }
    }
    
    public synchronized Partida getSala() {
        return partida;
    }
    
    public synchronized Marcador obtenerMarcador(){
        return this.partida.getMarcador();
    }
    
    public synchronized Linea obtenerUltimaLinea(){
        return this.ultimaLinea;
    }
    
    public synchronized Cuadro obtenerUltimoCuadro(){
        return this.ultimoCuadro;
    }
    
    public synchronized int obtenerTurnoSiguiente(){
        return this.partida.getMarcador().getSiguiente()+1;
    }
    
    public synchronized void retirarJugador(Jugador jugador) {
        for (Jugador jugObj : this.partida.getMarcador().getJugadores()) {
            if(jugObj.equals(jugador)){
                this.partida.getMarcador().getJugadores().remove(jugObj);
                
                for (Linea vertical : this.partida.getTablero().getLineasVerticales()) {
                    if(vertical.getJugador().equals(jugObj)){
                        vertical.setJugador(null);
                    }
                }
                
                for (Linea horizontal : this.partida.getTablero().getLineasHorizontales()) {
                    if(horizontal.getJugador().equals(jugObj)){
                        horizontal.setJugador(null);
                    }
                }
                
                for (Cuadro cuadro : this.partida.getTablero().getCuadros()) {
                    if(cuadro.getJugador().equals(jugObj)){
                        cuadro.setJugador(null);
                    }
                }
            }
        }
    }
    
//    public synchronized int finalizarPartida(){
//        return this.ultimoCuadro.estaCompleto();
//    }
    
}
