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
public class Imagen extends FiguraEstandar{
    private String ruta;
    private int ancho;
    private int alto;

    public Imagen( int ancho, int alto, int x, int y,String ruta, boolean direccionAdelante, boolean direccionArriba,boolean maquina,String id) {
        super(x, y, direccionAdelante, direccionArriba,maquina,id);
        this.ruta = ruta;
        this.ancho = ancho;
        this.alto = alto;
        Rectangle area=new Rectangle(x, y, ancho, alto);
        
        this.setArea(area);
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
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
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.ancho, this.alto);
        this.setArea(area);
    }

    @Override
    public void actualizarPosiciones() {
        int x=this.getX();
        int y=this.getY();
    }
}
