/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.Interfaces;


/**
 *
 * @author march
 */
public interface ICliente { 
    boolean conectarAlServidor(String address, int port);
    boolean enviarAlServidor(Object mensaje);
    void escucharAlServidor();
}
