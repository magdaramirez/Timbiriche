/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.PipesAndFilters;

import java.util.ArrayList;
import java.util.List;
import org.itson.Dominio.*;
import org.itson.DominioSTK.*;

/**
 *
 * @author koine
 */
public class Repositorio implements IRepositorio{
    private SRep sr = SRep.getInstance();

    @Override
    public MarcadorSTK obtenerMarcador() {
        Marcador marcador = sr.obtenerMarcador();

        List<JugadorSTK> jugadoresSTK = new ArrayList<>();
        for (Jugador jugador : marcador.getJugadores()) {
            jugadoresSTK.add(new JugadorSTK(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje()));
        }
        MarcadorSTK marcadorSTK = new MarcadorSTK(jugadoresSTK);

        return marcadorSTK;
    }

    @Override
    public LineaSTK obtenerUltimaLinea() {
        Linea linea = sr.obtenerUltimaLinea();
        if (linea != null) {
            LineaSTK lineaDTO
                    = new LineaSTK(
                            linea.getPosicion().toString(),
                            linea.getIndice(),
                            new JugadorSTK(
                                    linea.getJugador().getNombre(),
                                    linea.getJugador().getRutaAvatar(),
                                    linea.getJugador().getPuntaje()));
            return lineaDTO;
        }else{
            return null;
        }
    }

    @Override
    public CuadroSTK obtenerUltimoCuadro() {
        Cuadro cuadro = sr.obtenerUltimoCuadro();
        CuadroSTK cuadroSTK
                = new CuadroSTK(cuadro.getIndice(),
                        new JugadorSTK(cuadro.getJugador().getNombre(),
                                cuadro.getJugador().getRutaAvatar(),
                                cuadro.getJugador().getPuntaje()));

        return cuadroSTK;
    }

    @Override
    public int obtenerTurnoSiguiente() {
        return sr.obtenerTurnoSiguiente();
    }
}
