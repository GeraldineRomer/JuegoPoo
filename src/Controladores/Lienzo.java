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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Geraldine Romero
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {
    private LinkedList <FiguraGeometrica> figuras;
    private boolean estaJugando;
    private int punto;
     private LinkedList <JLabel> text; 
     private LinkedList <FiguraGeometrica> basurero;
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        this.figuras=new LinkedList<>();
        this.estaJugando=false;
        this.punto=0;
        this.text = new LinkedList<>();
        this.basurero = new LinkedList<>();
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
            for (FiguraGeometrica figuraActual:this.getFiguras()) {
                if(figuraActual instanceof FiguraEstandar){
                    if (figuraActual.isMaquina()){
                        movimientoFantasmaVerde((FiguraEstandar)figuraActual);
                        movimientoFantasmaRosa((FiguraEstandar)figuraActual);
                        movimientoFantasmaNaranja((FiguraEstandar)figuraActual);
                        movimientoFantasmaRojo((FiguraEstandar)figuraActual);
                        dispararEctoplasmaVerde((FiguraEstandar)figuraActual);
                        dispararEctoplasmaRosa((FiguraEstandar)figuraActual);
                        dispararEctoplasmaNaranja((FiguraEstandar)figuraActual);
                        dispararEctoplasmaRojo((FiguraEstandar)figuraActual);
//                        ColisionMapaDesdeArriba((FiguraEstandar)figuraActual);
                       
                    }else{
                         puntuacion((FiguraEstandar)figuraActual);
                         
//                        GameOver((FiguraEstandar)figuraActual);
                    } 
                }
            }
            this.figuras.removeAll(this.basurero);
            repaint();
            esperar(5);
        }
        if(this.isEstaJugando()== false){
            
            JOptionPane.showMessageDialog(this, "game over");
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
    
    public boolean validarFronterasEctoplasma(FiguraEstandar laFigura,String idFigura){
        if (laFigura instanceof Imagen){
            if (((Imagen) laFigura).getId().equals(idFigura)){
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
    public Rectangulo ColisionMapa(FiguraEstandar jugador){
        Rectangulo respuesta=null;
        if(ColisionObjeto(jugador) instanceof Rectangulo){
            respuesta=((Rectangulo)ColisionObjeto(jugador));
        }
        return respuesta;
    }
    public boolean verificarColisiones(FiguraGeometrica jugador){
        boolean respuesta=false;
        int i=0;
        jugador.actualizarArea();
        jugador.actualizarPosiciones();
        boolean aux=false;
        while(i<this.getFiguras().size() && !respuesta){
            if(this.getFiguras().get(i) instanceof Circulo){
                aux=true;
            }
            if (jugador!=this.getFiguras().get(i) && jugador.getArea().intersects(this.getFiguras().get(i).getArea()) && !aux ) {
                respuesta=true;
                System.out.println(this.getFiguras().get(i).getId());
            }
            i++;
//            System.out.println(respuesta);
            
        }
        return respuesta;
        
    }
        
    
    public void puntuacion(FiguraEstandar Jugador){
        
        if ( ColisionObjeto(Jugador) instanceof Circulo){
            this.setPunto(this.getPunto() + 1);
            this.getText().get(0).setText(""+this.getPunto());
            this.basurero.add(ColisionObjeto(Jugador));
//            this.getFiguras().remove(ColisionObjeto(Jugador));
                      
        }
        System.out.println(this.getPunto());
    }
        public FiguraEstandar ColisionObjeto(FiguraEstandar jugador){
//        boolean respuesta=false;

        FiguraEstandar objeto=null;
        int i=0;
        jugador.actualizarArea();
        jugador.actualizarPosiciones();
            
        if(jugador.getId()=="pacman"){
            
            while(i<this.getFiguras().size() ){
            
            if (jugador!=this.getFiguras().get(i) && jugador.getArea().intersects(this.getFiguras().get(i).getArea())) {
                //(respuesta=true;
                
                objeto=((FiguraEstandar)this.getFiguras().get(i));   
                
                
                
            }
            i++;
            //System.out.println(respuesta);
            
        }
        }
        
        return objeto;
        
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
    
    public int movimientoFantasmaNaranja(FiguraEstandar fanNaranja){
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
        return fanNaranja.getY();
    }
    
    public int movimientoFantasmaRosa(FiguraEstandar fanRosa){
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
        return fanRosa.getX();
    }
    
    public int movimientoFantasmaRojo(FiguraEstandar fanRojo){
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
        return fanRojo.getX();
    }
    
    public boolean movimientoEctoplasmaVerde(FiguraEstandar ectoplasmaVerde){
        if (ectoplasmaVerde instanceof Imagen){
            if (((Imagen) ectoplasmaVerde).getId().equals("ectoPlasmaVerde")) {
                if (ectoplasmaVerde.isDireccionAdelante() == true){
                    ectoplasmaVerde.setX(ectoplasmaVerde.getX()+1);
                } else {
                    ectoplasmaVerde.setX(ectoplasmaVerde.getX()-1);
                }
            }
        }
        return validarFronterasEctoplasma(ectoplasmaVerde,"ectoPlasmaVerde");
    }
    
    public boolean movimientoEctoplasmaRosa(FiguraEstandar ectoplasmaRosa){
        if (ectoplasmaRosa instanceof Imagen){
            if (((Imagen) ectoplasmaRosa).getId().equals("ectoPlasmaRosa")) {
                if (ectoplasmaRosa.isDireccionArriba() == true){
                    ectoplasmaRosa.setY(ectoplasmaRosa.getY()-1);
                } else {
                    ectoplasmaRosa.setY(ectoplasmaRosa.getY()+1);
                }
            }
        }
        return validarFronterasEctoplasma(ectoplasmaRosa,"ectoPlasmaRosa");
    }
    
    public boolean movimientoEctoplasmaNaranja(FiguraEstandar ectoplasmaNaranja){
        if (ectoplasmaNaranja instanceof Imagen){
            if (((Imagen) ectoplasmaNaranja).getId().equals("ectoPlasmaNaranja")) {
                if (ectoplasmaNaranja.isDireccionAdelante() != true){
                    ectoplasmaNaranja.setX(ectoplasmaNaranja.getX()-1);
                } else {
                    ectoplasmaNaranja.setX(ectoplasmaNaranja.getX()+1);
                }
            }
        }
        return validarFronterasEctoplasma(ectoplasmaNaranja,"ectoPlasmaNaranja");
    }
    
    public boolean movimientoEctoplasmaRojo(FiguraEstandar ectoplasmaRojo){
        if (ectoplasmaRojo instanceof Imagen){
            if (((Imagen) ectoplasmaRojo).getId().equals("ectoPlasmaRojo")) {
                if (ectoplasmaRojo.isDireccionArriba() != true){
                    ectoplasmaRojo.setY(ectoplasmaRojo.getY()-1);
                } else {
                    ectoplasmaRojo.setY(ectoplasmaRojo.getY()+1);
                }
            }
        }
        return validarFronterasEctoplasma(ectoplasmaRojo,"ectoPlasmaRojo");
    }
    
    public void dispararEctoplasmaVerde(FiguraEstandar ectoplasmaVerde){
        if (ectoplasmaVerde instanceof Imagen){
            if (((Imagen) ectoplasmaVerde).getRuta().equals("src/recursosPacman/ectoplasma.png")){
                if (movimientoEctoplasmaVerde(ectoplasmaVerde)){
                    for(FiguraGeometrica actual:this.getFiguras()){
                        if (actual instanceof Imagen){
                            if (actual.getId().equals("FanVerde")){
                                ectoplasmaVerde.setY(movimientoFantasmaVerde(((Imagen) actual)));
                                ectoplasmaVerde.setX(((Imagen) actual).getX());
                            }
                        }
                    }
                    
                }
            }
        }
    }
    
    public void dispararEctoplasmaRosa(FiguraEstandar ectoplasmaRosa){
        if (ectoplasmaRosa instanceof Imagen){
            if (((Imagen) ectoplasmaRosa).getId().equals("ectoPlasmaRosa")){
                if (movimientoEctoplasmaRosa(ectoplasmaRosa)){
                    for(FiguraGeometrica actual:this.getFiguras()){
                        if (actual instanceof Imagen){
                            if (actual.getId().equals("FanRosa")){
                                ectoplasmaRosa.setX(movimientoFantasmaRosa(((Imagen) actual)));
                                ectoplasmaRosa.setY(((Imagen) actual).getY());
                            }
                        }
                    }
                    
                }
            }
        }
    }
    
    public void dispararEctoplasmaNaranja(FiguraEstandar ectoplasmaNaranja){
        if (ectoplasmaNaranja instanceof Imagen){
            if (((Imagen) ectoplasmaNaranja).getId().equals("ectoPlasmaNaranja")){
                if (movimientoEctoplasmaNaranja(ectoplasmaNaranja)){
                    for(FiguraGeometrica actual:this.getFiguras()){
                        if (actual instanceof Imagen){
                            if (actual.getId().equals("fanNaranja")){
                                ectoplasmaNaranja.setY(movimientoFantasmaNaranja(((Imagen) actual)));
                                ectoplasmaNaranja.setX(((Imagen) actual).getX());
                            }
                        }
                    }
                    
                }
            }
        }
    }
    
    
    public void dispararEctoplasmaRojo(FiguraEstandar ectoplasmaRojo){
        if (ectoplasmaRojo instanceof Imagen){
            if (((Imagen) ectoplasmaRojo).getId().equals("ectoPlasmaRojo")){
                if (movimientoEctoplasmaRojo(ectoplasmaRojo)){
                    for(FiguraGeometrica actual:this.getFiguras()){
                        if (actual instanceof Imagen){
                            if (actual.getId().equals("fanRojo")){
                                ectoplasmaRojo.setX(movimientoFantasmaRojo(((Imagen) actual)));
                                ectoplasmaRojo.setY(((Imagen) actual).getY());
                            }
                        }
                    }
                    
                }
            }
        }
    }
    public void GameOver(FiguraEstandar jugador){
        if(ColisionObjeto(jugador) instanceof Imagen){
            this.setEstaJugando(false);
        }
        
    }
    public void movimientoArriba(FiguraEstandar jugador){
        if(jugador.getId()=="pacman"){
            if(verificarColisiones(jugador) != true){
            jugador.setY(jugador.getY() - 1);
            repaint();
            
            }else{
                jugador.setY(jugador.getY() + 1);
            }
        }
    }
    public void movimientoAbajo(FiguraEstandar jugador){
        if(jugador.getId()=="pacman"){
            if(verificarColisiones(jugador) != true){
            jugador.setY(jugador.getY() + 1);
            repaint();
            
            }
        }
    }
    public void movimientoDerecha(FiguraEstandar jugador){
        if(jugador.getId()=="pacman"){
            if(verificarColisiones(jugador) != true){
            jugador.setX(jugador.getX() + 1);
            repaint();
            
            }
        }
    }
    public void movimientoIzda(FiguraEstandar jugador){
        if(jugador.getId()=="pacman"){
            if(verificarColisiones(jugador) != true){
            jugador.setX(jugador.getX() - 1);
            repaint();
            
            }
        }
    }
    public void sacarBloquesMovArriba(FiguraEstandar jugador){
        if(jugador.getId()== "pacman"){
            if(verificarColisiones(jugador) == true){
                jugador.setY(ColisionMapa(jugador).getY() + ColisionMapa(jugador).getAlto() + 1);
            }
                

        }
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

    /**
     * @return the punto
     */
    public int getPunto() {
        return punto;
    }

    /**
     * @param punto the punto to set
     */
    public void setPunto(int punto) {
        this.punto = punto;
    }

    /**
     * @return the text
     */
    public LinkedList <JLabel> getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(LinkedList <JLabel> text) {
        this.text = text;
    }

    /**
     * @return the basurero
     */
    public LinkedList <FiguraGeometrica> getBasurero() {
        return basurero;
    }

    /**
     * @param basurero the basurero to set
     */
    public void setBasurero(LinkedList <FiguraGeometrica> basurero) {
        this.basurero = basurero;
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
