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
public class Cuadrado extends FiguraEstandar{
    private int lado;

    public Cuadrado() {
        super(0, 0, null, null,true,true,false,"");
    }

    public Cuadrado( int x, int y, Color borde, Color colorRelleno, int lado,boolean direccionAdelante, boolean direccionArriba,boolean maquina,String id) {
        super(x, y, borde, colorRelleno, direccionAdelante, direccionArriba,maquina,id);
        this.lado = lado;
        Rectangle area=new Rectangle(x, y, lado, lado);
        this.setArea(area);
    }

    /**
     * @return the lado
     */
    public int getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.lado, this.lado);
        this.setArea(area);
    }

    @Override
    public void actualizarPosiciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
