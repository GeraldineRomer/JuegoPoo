/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;

/**
 *
 * @author Geraldine Romero
 */
public abstract class FiguraEstandar extends FiguraGeometrica{
    private int x;
    private int y;
    
    public FiguraEstandar(int x, int y, Color borde, Color colorRelleno, boolean direccionAdelante, boolean direccionArriba,boolean maquina) {
        super(borde, colorRelleno, direccionAdelante, direccionArriba,maquina);
        this.x = x;
        this.y = y;
    }
    
    public FiguraEstandar(int x, int y, boolean direccionAdelante, boolean direccionArriba,boolean maquina) {
        super(null, null, direccionAdelante, direccionArriba,maquina);
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
