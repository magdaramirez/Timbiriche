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
public class Preferencia {
    private List<String> colores;

    public Preferencia(String colorLinea2, String colorLinea3, String colorLinea4) {
        colores = new ArrayList<>();
        colores.add(colorLinea2);
        colores.add(colorLinea3);
        colores.add(colorLinea4);
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }
}
