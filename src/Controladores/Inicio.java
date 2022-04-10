/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuadrado;
import Clases.Imagen;
import Clases.Rectangulo;
import java.awt.Color;

/**
 *
 * @author Geraldine Romero
 */
public class Inicio extends javax.swing.JFrame {
 Imagen pacman;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        creacionEscenario();
//        Color backG= new Color(5,5,20);
//        this.lienzo1=new Lienzo();
//        this.lienzo1.setBackground(backG);
//        this.lienzo1.setVisible(true);
//        this.lienzo1.setSize(800, 500);
//        this.add(lienzo1);
        
        Thread proceso=new Thread(this.lienzo1);
        this.lienzo1.setEstaJugando(true);
        proceso.start();
    }
    
    public void creacionEscenario(){
        this.pacman = new Imagen(25, 25, 313, 393, "src/recursosPacman/pacman.png", true, true, false);
        this.lienzo1.getFiguras().add(pacman);
        laberinto();
        fantasmas();
        
    }
    
    public void laberinto(){
        bordesLaberinto();
        rellenoLaberinto();
    }
    
    public void fantasmas(){
        Imagen FanRojo= new Imagen(25, 25, 752, 22, "src/recursosPacman/fantasmaRojo.png", false, false, true) ;
        Imagen FanNaranja= new Imagen(25, 25, 752, 452, "src/recursosPacman/fantasmaNaranja.png", false, false, true) ;
        Imagen FanRosa= new Imagen(25, 25, 22, 452, "src/recursosPacman/fantasmaRosa.png", true, false, true) ;
        Imagen FanVerde= new Imagen(25, 25, 22, 22, "src/recursosPacman/fantasmaVerde.png", false, true, true) ;
        
        Imagen Ectoplasma= new Imagen(20, 20, FanVerde.getX(), FanVerde.getY(), "src/recursosPacman/ectoplasma.png", true, false, true) ;
        this.lienzo1.getFiguras().add(Ectoplasma);
        
        //disparar(FanVerde);
        
        
        this.lienzo1.getFiguras().add(FanRojo);
        this.lienzo1.getFiguras().add(FanNaranja);
        this.lienzo1.getFiguras().add(FanRosa);
        this.lienzo1.getFiguras().add(FanVerde);
        
        
    }
    
    public void disparar(Imagen fantasma){
        Imagen Ectoplasma= new Imagen(20, 20, fantasma.getX(), fantasma.getY(), "src/recursosPacman/ectoplasma.png", true, false, true) ;
        this.lienzo1.getFiguras().add(Ectoplasma);
        
        if(this.lienzo1.validarFronterasEctoplasma(Ectoplasma) == true){
            System.out.println("entra");
        }
    }
    
    public void bordesLaberinto(){
        Rectangulo bordeIzda = new Rectangulo(0, 0, Color.blue, Color.blue, 20, 500, true, true);
        Rectangulo bordeInf = new Rectangulo(0,480, Color.blue, Color.blue, 800, 20, true, true);
        Rectangulo bordeSup = new Rectangulo(0, 0, Color.blue, Color.blue, 800, 20, true, true);
        Rectangulo bordeDer = new Rectangulo(780, 0, Color.blue, Color.blue, 20, 500, true, true);
        
        this.lienzo1.getFiguras().add(bordeIzda);
        this.lienzo1.getFiguras().add(bordeInf);
        this.lienzo1.getFiguras().add(bordeSup);
        this.lienzo1.getFiguras().add(bordeDer);
    }
    
    public void rellenoLaberinto(){
        horizontales();
        verticales();
    }
    
    public void horizontales(){
        Rectangulo R1 = new Rectangulo(50, 50, Color.blue, Color.blue, 83, 30, true, true);
        Rectangulo R2 = new Rectangulo(50, 110, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R3 = new Rectangulo(50, 170, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R4 = new Rectangulo(50, 260, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R5 = new Rectangulo(50, 320, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R6 = new Rectangulo(50, 380, Color.blue, Color.blue, 139, 40, true, true);
        Rectangulo R7 = new Rectangulo(246,140, Color.blue, Color.blue, 33, 32, true, true);
        Rectangulo R8 = new Rectangulo(279, 49, Color.blue, Color.blue, 242, 16, true, true);
        Rectangulo R9 = new Rectangulo(279, 80, Color.blue, Color.blue,242, 30, true, true);
        Rectangulo R10 = new Rectangulo(309, 202, Color.blue, Color.blue, 182, 30, true, true);
        Rectangulo R11 = new Rectangulo(309, 260, Color.blue, Color.blue, 182, 5, true, true);
        Rectangulo R12 = new Rectangulo(309, 270, Color.blue, Color.blue, 182, 17, true, true);
        Rectangulo R13 = new Rectangulo(340, 300, Color.blue, Color.blue, 120, 30, true, true);
        Rectangulo R14 = new Rectangulo(305, 420, Color.blue, Color.blue, 190, 30, true, true);
        Rectangulo R31 = new Rectangulo(521, 140, Color.blue, Color.blue, 33, 32, true, true);
        Rectangulo R32 = new Rectangulo(667, 50, Color.blue, Color.blue, 83, 30, true, true);
        Rectangulo R33 = new Rectangulo(611, 110, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R34 = new Rectangulo(611, 170, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R35 = new Rectangulo(611, 260, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R36 = new Rectangulo(611, 320, Color.blue, Color.blue, 139, 30, true, true);
        Rectangulo R37 = new Rectangulo(611,380, Color.blue, Color.blue, 139, 40, true, true);
         
        this.lienzo1.getFiguras().add(R1);
        this.lienzo1.getFiguras().add(R2);
        this.lienzo1.getFiguras().add(R3);
        this.lienzo1.getFiguras().add(R4);
        this.lienzo1.getFiguras().add(R5);
        this.lienzo1.getFiguras().add(R6);
        this.lienzo1.getFiguras().add(R7);
        this.lienzo1.getFiguras().add(R8);
        this.lienzo1.getFiguras().add(R9);
        this.lienzo1.getFiguras().add(R10);
        this.lienzo1.getFiguras().add(R11);
        this.lienzo1.getFiguras().add(R12);
        this.lienzo1.getFiguras().add(R13);
        this.lienzo1.getFiguras().add(R14);
        this.lienzo1.getFiguras().add(R31);
        this.lienzo1.getFiguras().add(R32);
        this.lienzo1.getFiguras().add(R33);
        this.lienzo1.getFiguras().add(R34);
        this.lienzo1.getFiguras().add(R35);
        this.lienzo1.getFiguras().add(R36);
        this.lienzo1.getFiguras().add(R37);
        
        
        
        
    }
    public void verticales(){
        Rectangulo R15 = new Rectangulo(163, 50, Color.blue, Color.blue, 26, 69, true, true);
        Rectangulo R16 = new Rectangulo(80, 230, Color.blue, Color.blue, 30, 57, true, true);
        Rectangulo R17 = new Rectangulo(99, 336, Color.blue, Color.blue, 30, 57, true, true);
        Rectangulo R18 = new Rectangulo(219, 50, Color.blue, Color.blue, 30, 182, true, true);
        Rectangulo R19 = new Rectangulo(219, 260, Color.blue, Color.blue, 30, 160, true, true);
        Rectangulo R20 = new Rectangulo(309, 65, Color.blue, Color.blue, 30, 107, true, true);
        Rectangulo R21 = new Rectangulo(279, 330, Color.blue, Color.blue, 31, 120, true, true);
        Rectangulo R22 = new Rectangulo(366, 330, Color.blue, Color.blue, 4, 60, true, true);
        Rectangulo R23 = new Rectangulo(430, 330, Color.blue, Color.blue, 4, 60, true, true);
        Rectangulo R24 = new Rectangulo(461, 65, Color.blue, Color.blue, 30, 107, true, true);
        Rectangulo R25 = new Rectangulo(490, 330, Color.blue, Color.blue, 31, 120, true, true);
        Rectangulo R26 = new Rectangulo(551, 50, Color.blue, Color.blue, 30, 182, true, true);
        Rectangulo R27 = new Rectangulo(551, 260, Color.blue, Color.blue, 30, 160, true, true);
        Rectangulo R28 = new Rectangulo(611, 50, Color.blue, Color.blue, 26, 69, true, true);
        Rectangulo R29 = new Rectangulo(690, 230, Color.blue, Color.blue, 30, 57, true, true);
        Rectangulo R30 = new Rectangulo(671, 336, Color.blue, Color.blue, 30, 57, true, true);
        this.lienzo1.getFiguras().add(R15);
        this.lienzo1.getFiguras().add(R16);
        this.lienzo1.getFiguras().add(R17);
        this.lienzo1.getFiguras().add(R18);
        this.lienzo1.getFiguras().add(R19);
        this.lienzo1.getFiguras().add(R20);
        this.lienzo1.getFiguras().add(R21);
        this.lienzo1.getFiguras().add(R22);
        this.lienzo1.getFiguras().add(R23);
        this.lienzo1.getFiguras().add(R24);
        this.lienzo1.getFiguras().add(R25);
        this.lienzo1.getFiguras().add(R26);
        this.lienzo1.getFiguras().add(R27);
        this.lienzo1.getFiguras().add(R28);
        this.lienzo1.getFiguras().add(R29);
        this.lienzo1.getFiguras().add(R30);
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo1 = new Controladores.Lienzo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lienzo1.setBackground(new java.awt.Color(5, 5, 20));
        lienzo1.setForeground(new java.awt.Color(5, 5, 20));

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        this.setFocusable(true);
            if (evt.getKeyChar()=='w') {
                while(this.lienzo1.verificarColisiones(pacman) != true){
                    this.pacman.setY(this.pacman.getY()-1);
                    
                    this.pacman.actualizarArea();
                    repaint();
                    this.lienzo1.esperar(1);
                }
            } else if (evt.getKeyChar()=='a'){
                while(this.lienzo1.verificarColisiones(pacman) != true){
                    this.pacman.setX(this.pacman.getX()-1);
                    
                    this.pacman.actualizarArea();
                    repaint();
                    this.lienzo1.esperar(1);
                }
                
            } else if (evt.getKeyChar()=='s'){
                while(this.lienzo1.verificarColisiones(pacman) != true){
                    this.pacman.setY(this.pacman.getY()+1);
                    
                    this.pacman.actualizarArea();
                    repaint();
                    this.lienzo1.esperar(1);
                }
                
            } else if (evt.getKeyChar()=='d'){
                while(this.lienzo1.verificarColisiones(pacman) != true){
                    this.pacman.setX(this.pacman.getX()+1);
                    
                    this.pacman.actualizarArea();
                    repaint();
                    this.lienzo1.esperar(1);
                }
                
            }
        
        
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controladores.Lienzo lienzo1;
    // End of variables declaration//GEN-END:variables
}
