/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Circulo;
import Clases.Cuadrado;
import Clases.FiguraEstandar;
import Clases.FiguraGeometrica;
import Clases.Imagen;
import Clases.Rectangulo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Geraldine Romero
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {
    private LinkedList <FiguraGeometrica> figuras;
    private boolean estaJugando;
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        this.figuras=new LinkedList<>();
        this.estaJugando=false;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  // g -> lapiz
        dibujarFiguras(g);
    }
    
    public void dibujarFiguras(Graphics g){
        for(FiguraGeometrica figuraActual:this.getFiguras()){
            if(figuraActual instanceof Cuadrado){
                dibujarCuadrado(g, (Cuadrado)figuraActual);
            } else if (figuraActual instanceof Circulo){
                dibujarCirculo(g, (Circulo)figuraActual);
            } else if (figuraActual instanceof  Imagen){
                dibujarImagen(g, (Imagen)figuraActual);
            } else if (figuraActual instanceof  Rectangulo){
                dibujarRectangulo(g, (Rectangulo)figuraActual);
            }
        }
    }
    
    public void dibujarCuadrado(Graphics g,Cuadrado elCuadrado){
        g.setColor(elCuadrado.getColorRelleno());
        g.fillRect(elCuadrado.getX(), elCuadrado.getY(), elCuadrado.getLado(), elCuadrado.getLado());
        g.setColor(elCuadrado.getBorde());
        g.drawRect(elCuadrado.getX(), elCuadrado.getY(), elCuadrado.getLado(), elCuadrado.getLado());
    }
    public void dibujarRectangulo(Graphics g,Rectangulo elRectangulo){
        g.setColor(elRectangulo.getColorRelleno());
        g.fillRect(elRectangulo.getX(), elRectangulo.getY(), elRectangulo.getAncho(), elRectangulo.getAlto());
        g.setColor(elRectangulo.getBorde());
        g.drawRect(elRectangulo.getX(), elRectangulo.getY(), elRectangulo.getAncho(), elRectangulo.getAlto());
    }
    
    public void dibujarCirculo(Graphics g,Circulo elCirculo){
        g.setColor(elCirculo.getColorRelleno());
        g.fillOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
        g.setColor(elCirculo.getBorde());
        g.drawOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
    }
    
    public void dibujarImagen(Graphics g,Imagen laImagen){
        //obtener la imagen de la ruta donde esté
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(laImagen.getRuta());
        g.drawImage(imagen, laImagen.getX(), laImagen.getY(), laImagen.getAncho(),laImagen.getAlto(),this);
    }
    
    @Override
    public void run() {
        while(this.isEstaJugando()){
            for (FiguraGeometrica figuraActual:this.figuras) {
                if(figuraActual instanceof FiguraEstandar){
                    if (figuraActual.isMaquina()){
                        movimientoFantasmaVerde((FiguraEstandar)figuraActual);
                        movimientoFantasmaRosa((FiguraEstandar)figuraActual);
                        movimientoFantasmaNaranja((FiguraEstandar)figuraActual);
                        movimientoFantasmaRojo((FiguraEstandar)figuraActual);
                        disparar((FiguraEstandar)figuraActual);
//                        movimientoEctoplasmaVerde((FiguraEstandar)figuraActual);
                    } 
                }
            }
            repaint();
            esperar(5);
        }
    }
    
    public void validarFronteras(FiguraEstandar laFigura){
        //mirar hacia adelante y hacia atrás
        if (laFigura.getX()>=755) {
            laFigura.setDireccionAdelante(false);
        } else if (laFigura.getX()<=20){
            laFigura.setDireccionAdelante(true);
        }
        //mirar hacia arriba y hacia abajo
        if(laFigura.getY()>=455){
            laFigura.setDireccionArriba(false);
        } else if (laFigura.getY()<=20){
            laFigura.setDireccionArriba(true);
        }
    }
    
    public boolean validarFronterasEctoplasma(FiguraEstandar laFigura){
        if (laFigura instanceof Imagen){
            if (((Imagen) laFigura).getRuta().equals("src/recursosPacman/ectoplasma.png")){
                if (laFigura.getX()>=800) {
                    return true;
                } else if (laFigura.getX()<=0){
                    return true;
                }
                if(laFigura.getY()>=500){
                    return true;
                } else if (laFigura.getY()<=0){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void esperar(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verificarColisiones(FiguraGeometrica jugador){
        boolean respuesta=false;
        int i=0;
        jugador.actualizarArea();
        jugador.actualizarPosiciones();
        while(i<this.figuras.size() && !respuesta){
            
            if (jugador!=this.figuras.get(i) && jugador.getArea().intersects(this.figuras.get(i).getArea())) {
                respuesta=true;
                System.out.println(this.figuras.get(i).getId());
            }
            i++;
            System.out.println(respuesta);
            
        }
        return respuesta;
        
    }
    
    public int movimientoFantasmaVerde(FiguraEstandar fanVerde){
        if (fanVerde instanceof Imagen){
            if (((Imagen) fanVerde).getRuta().equals("src/recursosPacman/fantasmaVerde.png")) {
                if (fanVerde.isDireccionArriba() == true){
                    fanVerde.setY(fanVerde.getY()+1);
                } else {
                    fanVerde.setY(fanVerde.getY()-1);
                }
                validarFronteras(fanVerde);
            }
        }
        fanVerde.actualizarArea();
        return fanVerde.getY();
    }
    
    public boolean movimientoEctoplasmaVerde(FiguraEstandar ectoplasmaVerde){
        if (ectoplasmaVerde instanceof Imagen){
            if (((Imagen) ectoplasmaVerde).getRuta().equals("src/recursosPacman/ectoplasma.png")) {
                if (ectoplasmaVerde.isDireccionAdelante() == true){
                    ectoplasmaVerde.setX(ectoplasmaVerde.getX()+1);
                } else {
                    ectoplasmaVerde.setX(ectoplasmaVerde.getX()-1);
                }
            }
        }
        return validarFronterasEctoplasma(ectoplasmaVerde);
    }
    
    public void disparar(FiguraEstandar ectoplasmaVerde){
        if (ectoplasmaVerde instanceof Imagen){
            if (((Imagen) ectoplasmaVerde).getRuta().equals("src/recursosPacman/ectoplasma.png")){
                if (movimientoEctoplasmaVerde(ectoplasmaVerde)){
                    for(FiguraGeometrica actual:this.figuras){
                        if (actual instanceof Imagen){
                            if (actual.getId().equals("FanVerde")){
                                System.out.println("entra");
                                ectoplasmaVerde.setY(movimientoFantasmaVerde(((Imagen) actual)));
                                ectoplasmaVerde.setX(((Imagen) actual).getX());
                                System.out.println(movimientoFantasmaVerde(((Imagen) actual)));
                            }
                        }
                    }
                    
                }
            }
        }
    }
    
    
    public void movimientoFantasmaNaranja(FiguraEstandar fanNaranja){
        if (fanNaranja instanceof Imagen){
            if (((Imagen) fanNaranja).getRuta().equals("src/recursosPacman/fantasmaNaranja.png")) {
                if (fanNaranja.isDireccionArriba() != true){
                    fanNaranja.setY(fanNaranja.getY()-1);
                } else {
                    fanNaranja.setY(fanNaranja.getY()+1);
                }
                validarFronteras(fanNaranja);
            }
        }
        fanNaranja.actualizarPosiciones();
        fanNaranja.actualizarArea();
    }
    
    public void movimientoFantasmaRosa(FiguraEstandar fanRosa){
        if (fanRosa instanceof Imagen){
            if (((Imagen) fanRosa).getRuta().equals("src/recursosPacman/fantasmaRosa.png")) {
                if (fanRosa.isDireccionAdelante() == true){
                    fanRosa.setX(fanRosa.getX()+1);
                } else {
                    fanRosa.setX(fanRosa.getX()-1);
                }
                validarFronteras(fanRosa);
            }
        }
        fanRosa.actualizarPosiciones();
        fanRosa.actualizarArea();
    }
    
    public void movimientoFantasmaRojo(FiguraEstandar fanRojo){
        if (fanRojo instanceof Imagen){
            if (((Imagen) fanRojo).getRuta().equals("src/recursosPacman/fantasmaRojo.png")) {
                if (fanRojo.isDireccionAdelante() != true){
                    fanRojo.setX(fanRojo.getX()-1);
                } else {
                    fanRojo.setX(fanRojo.getX()+1);
                }
                validarFronteras(fanRojo);
            }
        }
        fanRojo.actualizarPosiciones();
        fanRojo.actualizarArea();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @return the figuras
     */
    public LinkedList <FiguraGeometrica> getFiguras() {
        return figuras;
    }

    /**
     * @param figuras the figuras to set
     */
    public void setFiguras(LinkedList <FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    /**
     * @return the estaJugando
     */
    public boolean isEstaJugando() {
        return estaJugando;
    }

    /**
     * @param estaJugando the estaJugando to set
     */
    public void setEstaJugando(boolean estaJugando) {
        this.estaJugando = estaJugando;
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
