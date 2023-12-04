/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.DominioSTK;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author koine
 */
public class MovimientoSTK implements Serializable{
    private LineaSTK linea;
    private List<CuadroSTK> cuadros = new ArrayList<>();

    public LineaSTK getLinea() {
        return linea;
    }

    public void setLinea(LineaSTK linea) {
        this.linea = linea;
    }

    public List<CuadroSTK> getCuadros() {
        return cuadros;
    }

    public void setCuadros(List<CuadroSTK> cuadros) {
        this.cuadros = cuadros;
    }

    public void setCuadro(CuadroSTK cuadro) {
        if(cuadros.size() < 2){
            cuadros.add(cuadro);
        }else{
            cuadros.remove(0);
            cuadros.add(cuadro);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.linea);
        hash = 37 * hash + Objects.hashCode(this.cuadros);
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
        final MovimientoSTK other = (MovimientoSTK) obj;
        if (!Objects.equals(this.linea, other.linea)) {
            return false;
        }
        if (!Objects.equals(this.cuadros, other.cuadros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovimientoSTK { " + "linea=" + linea + ", cuadros=" + cuadros + '}';
    }
}
