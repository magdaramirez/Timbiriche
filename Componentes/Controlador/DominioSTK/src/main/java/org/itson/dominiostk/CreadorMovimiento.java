/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.DominioSTK;

/**
 *
 * @author koine
 */
public abstract class CreadorMovimiento {
    protected MovimientoSTK movimiento;
    
    public MovimientoSTK getMovimientoSTK(){
        return movimiento;
    }
    
    public void creaMovimientoSTK(){
        movimiento = new MovimientoSTK();
    }
    
    public void agregarLinea(LineaSTK linea){};
    
    public void agregarCuadro(CuadroSTK cuadro){};
}
