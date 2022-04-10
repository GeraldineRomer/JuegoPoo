/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Geraldine Romero
 */
public class Circulo extends FiguraEstandar{
    private int radio;

    public Circulo() {
        super(0, 0, null, null,true,true,false);
    }

    public Circulo( int x, int y, Color borde, Color colorRelleno,int radio, boolean direccionAdelante, boolean direccionArriba,boolean maquina) {
        super(x, y, borde, colorRelleno, direccionAdelante, direccionArriba,maquina);
        this.radio = radio;
        Rectangle area=new Rectangle(x, y, radio*2, radio*2);
        this.setArea(area);
    }

    /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.radio*2, radio*2);
        this.setArea(area);
    }

    @Override
    public void actualizarPosiciones(int x,int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
