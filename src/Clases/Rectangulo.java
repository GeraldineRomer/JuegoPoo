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
 * @author JEAN SAID
 */
public class Rectangulo extends FiguraEstandar {
    private int ancho;
    private int alto;

    public Rectangulo() {
        super(0, 0, null, null,true,true,false,"");
    }

    public Rectangulo( int x, int y, Color borde, Color colorRelleno, int ancho,int alto,boolean direccionAdelante, boolean direccionArriba,String id) {
        super(x, y, borde, colorRelleno, direccionAdelante, direccionArriba,false,id);
        this.ancho = ancho;
        this.alto=alto;
        Rectangle area=new Rectangle(x, y, ancho, alto);
        this.setArea(area);
    }
    public Rectangulo( int x, int y, Color borde, Color colorRelleno, int ancho,int alto,boolean direccionAdelante, boolean direccionArriba,boolean maquina,String id) {
        super(x, y, borde, colorRelleno, direccionAdelante, direccionArriba,maquina,id);
        this.ancho = ancho;
        this.alto=alto;
        Rectangle area=new Rectangle(x, y, ancho, alto);
        this.setArea(area);
    }
    

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
 @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.getAncho(), this.getAlto());
        this.setArea(area);
    }   

    @Override
    public void actualizarPosiciones() {
        this.getX();
        this.getY();
    }
}
