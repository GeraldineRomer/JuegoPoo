/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Circulo;
import Clases.Cuadrado;
import Clases.Imagen;
import Clases.Rectangulo;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.applet.AudioClip;

/**
 *
 * @author Geraldine Romero
 */
public class Inicio extends javax.swing.JFrame {
 Imagen pacman;
 Thread proceso;
 AudioClip Mov;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        
        initComponents();
            starter();
        cambiarfoco();
        this.lienzo1.getText().add(this.lbPuntos);
        AudioClip intro;
            intro = java.applet.Applet.newAudioClip(getClass().getResource("/recursosPacman/introPacman.wav"));
        intro.play();
        
        
        
        
        
    }
    public void starter(){
        
        this.lienzo1.getFiguras().clear();
        creacionEscenario();
        this.lienzo1.setPunto(0);   
        this.setFocusable(true);
        
        
    }
    public void creacionHilo(){
        proceso=new Thread(this.lienzo1);
        this.lienzo1.setEstaJugando(true);
        proceso.start();
    }
    
    public void creacionEscenario() {
        this.pacman = new Imagen(25, 25, 313, 393, "src/recursosPacman/pacmanDerecha.gif", true, true, false, "pacman");
        this.lienzo1.getFiguras().add(pacman);
        laberinto();
        fantasmas();

    }

    public void laberinto() {
        bordesLaberinto();
        rellenoLaberinto();
        bolitas();
    }

    public void fantasmas() {
        Imagen FanRojo = new Imagen(25, 25, 752, 22, "src/recursosPacman/fantasmaRojo.png", false, false, true, "fanRojo");
        Imagen FanNaranja = new Imagen(25, 25, 752, 452, "src/recursosPacman/fantasmaNaranja.png", false, false, true, "fanNaranja");
        Imagen FanRosa = new Imagen(25, 25, 22, 452, "src/recursosPacman/fantasmaRosa.png", true, false, true, "FanRosa");
        Imagen FanVerde = new Imagen(25, 25, 22, 22, "src/recursosPacman/fantasmaVerde.png", false, true, true, "FanVerde");

        Imagen EctoplasmaVerde = new Imagen(20, 20, FanVerde.getX(), FanVerde.getY(), "src/recursosPacman/ectoplasmaVerde.png", true, false, true, "ectoPlasmaVerde");
        Imagen EctoplasmaRosa = new Imagen(20, 20, FanRosa.getX(), FanRosa.getY(), "src/recursosPacman/ectoplasmaRosa.png", true, true, true, "ectoPlasmaRosa");
        Imagen EctoplasmaNaranja = new Imagen(20, 20, FanNaranja.getX(), FanNaranja.getY(), "src/recursosPacman/ectoplasmaNaranja.png", false, false, true, "ectoPlasmaNaranja");
        Imagen EctoplasmaRojo = new Imagen(20, 20, FanRojo.getX(), FanRojo.getY(), "src/recursosPacman/ectoplasmaRojo.png", true, true, true, "ectoPlasmaRojo");

        this.lienzo1.getFiguras().add(EctoplasmaVerde);
        this.lienzo1.getFiguras().add(EctoplasmaRosa);
        this.lienzo1.getFiguras().add(EctoplasmaNaranja);
        this.lienzo1.getFiguras().add(EctoplasmaRojo);

        //disparar(FanVerde);
        this.lienzo1.getFiguras().add(FanRojo);
        this.lienzo1.getFiguras().add(FanNaranja);
        this.lienzo1.getFiguras().add(FanRosa);
        this.lienzo1.getFiguras().add(FanVerde);

    }

    public void bordesLaberinto() {
        Rectangulo bordeIzda = new Rectangulo(0, 0, Color.blue, Color.blue, 20, 500, true, true, "bordeIzda");
        Rectangulo bordeInf = new Rectangulo(0, 480, Color.blue, Color.blue, 800, 20, true, true, "bordeInf");
        Rectangulo bordeSup = new Rectangulo(0, 0, Color.blue, Color.blue, 800, 20, true, true, "bordeSup");
        Rectangulo bordeDer = new Rectangulo(780, 0, Color.blue, Color.blue, 20, 500, true, true, "bordeDer");

        this.lienzo1.getFiguras().add(bordeIzda);
        this.lienzo1.getFiguras().add(bordeInf);
        this.lienzo1.getFiguras().add(bordeSup);
        this.lienzo1.getFiguras().add(bordeDer);
    }

    public void rellenoLaberinto() {
        horizontales();
        verticales();
    }

    public void horizontales() {
        Rectangulo R1 = new Rectangulo(50, 50, Color.blue, Color.blue, 83, 30, true, true, "R1");
        Rectangulo R2 = new Rectangulo(50, 110, Color.blue, Color.blue, 139, 30, true, true, "R2");
        Rectangulo R3 = new Rectangulo(50, 170, Color.blue, Color.blue, 139, 30, true, true, "R3");
        Rectangulo R4 = new Rectangulo(50, 260, Color.blue, Color.blue, 139, 30, true, true, "R4");
        Rectangulo R5 = new Rectangulo(50, 320, Color.blue, Color.blue, 139, 30, true, true, "R5");
        Rectangulo R6 = new Rectangulo(50, 380, Color.blue, Color.blue, 139, 40, true, true, "R6");
        Rectangulo R7 = new Rectangulo(246, 140, Color.blue, Color.blue, 33, 32, true, true, "R7");
        Rectangulo R8 = new Rectangulo(279, 49, Color.blue, Color.blue, 242, 16, true, true, "R8");
        Rectangulo R9 = new Rectangulo(279, 80, Color.blue, Color.blue, 242, 30, true, true, "R9");
        Rectangulo R10 = new Rectangulo(307, 202, Color.blue, Color.blue, 186, 28, true, true, "R10");
        Rectangulo R11 = new Rectangulo(309, 260, Color.blue, Color.blue, 182, 5, true, true, "R11");
        Rectangulo R12 = new Rectangulo(309, 270, Color.blue, Color.blue, 182, 17, true, true, "R12");
        Rectangulo R13 = new Rectangulo(340, 300, Color.blue, Color.blue, 120, 30, true, true, "R13");
        Rectangulo R14 = new Rectangulo(305, 420, Color.blue, Color.blue, 190, 30, true, true, "R14");
        Rectangulo R31 = new Rectangulo(521, 140, Color.blue, Color.blue, 33, 32, true, true, "R31");
        Rectangulo R32 = new Rectangulo(667, 50, Color.blue, Color.blue, 83, 30, true, true, "R32");
        Rectangulo R33 = new Rectangulo(611, 110, Color.blue, Color.blue, 139, 30, true, true, "R33");
        Rectangulo R34 = new Rectangulo(611, 170, Color.blue, Color.blue, 139, 30, true, true, "R34");
        Rectangulo R35 = new Rectangulo(611, 260, Color.blue, Color.blue, 139, 30, true, true, "R35");
        Rectangulo R36 = new Rectangulo(611, 320, Color.blue, Color.blue, 139, 30, true, true, "R36");
        Rectangulo R37 = new Rectangulo(611, 380, Color.blue, Color.blue, 139, 40, true, true, "R37");

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

    public void bolitas() {
        Circulo c1 = new Circulo(651, 243, Color.white, Color.white, 5, true, true, true, "c1");
        Circulo c2 = new Circulo(531, 360, Color.white, Color.white, 5, true, true, true, "c2");
        Circulo c3 = new Circulo(670, 430, Color.white, Color.white, 5, true, true, true, "c3");
        Circulo c4 = new Circulo(110, 301, Color.white, Color.white, 5, true, true, true, "c4");
        Circulo c5 = new Circulo(103, 212, Color.white, Color.white, 5, true, true, true, "c5");
        Circulo c6 = new Circulo(395, 180, Color.white, Color.white, 5, true, true, true, "c6");
        this.lienzo1.getFiguras().add(c1);
        this.lienzo1.getFiguras().add(c2);
        this.lienzo1.getFiguras().add(c3);
        this.lienzo1.getFiguras().add(c4);
        this.lienzo1.getFiguras().add(c5);
        this.lienzo1.getFiguras().add(c6);
     

    }

    public void verticales() {
        Rectangulo R15 = new Rectangulo(163, 50, Color.blue, Color.blue, 26, 69, true, true, "R15");
        Rectangulo R16 = new Rectangulo(80, 230, Color.blue, Color.blue, 30, 57, true, true, "R16");
        Rectangulo R17 = new Rectangulo(99, 336, Color.blue, Color.blue, 30, 57, true, true, "R17");
        Rectangulo R18 = new Rectangulo(219, 50, Color.blue, Color.blue, 30, 180, true, true, "R18");
        Rectangulo R19 = new Rectangulo(219, 260, Color.blue, Color.blue, 30, 160, true, true, "R19");
        Rectangulo R20 = new Rectangulo(309, 65, Color.blue, Color.blue, 30, 107, true, true, "R20");
        Rectangulo R21 = new Rectangulo(279, 330, Color.blue, Color.blue, 31, 120, true, true, "R21");
        Rectangulo R22 = new Rectangulo(366, 330, Color.blue, Color.blue, 4, 60, true, true, "R22");
        Rectangulo R23 = new Rectangulo(430, 330, Color.blue, Color.blue, 4, 60, true, true, "R23");
        Rectangulo R24 = new Rectangulo(461, 65, Color.blue, Color.blue, 30, 107, true, true, "R24");
        Rectangulo R25 = new Rectangulo(490, 330, Color.blue, Color.blue, 31, 120, true, true, "R25");
        Rectangulo R26 = new Rectangulo(551, 50, Color.blue, Color.blue, 30, 180, true, true, "R26");
        Rectangulo R27 = new Rectangulo(551, 260, Color.blue, Color.blue, 30, 160, true, true, "R27");
        Rectangulo R28 = new Rectangulo(611, 50, Color.blue, Color.blue, 26, 69, true, true, "R28");
        Rectangulo R29 = new Rectangulo(690, 230, Color.blue, Color.blue, 30, 57, true, true, "R29");
        Rectangulo R30 = new Rectangulo(671, 336, Color.blue, Color.blue, 30, 57, true, true, "R30");
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
    
    public void nivel2(){
        if(this.lienzo1.getGanado()==0){
            this.lienzo1.setEstaJugando(false);
        while(this.proceso.isAlive()){
            System.out.println("todavia vive");
        }
        starter();
        
        Circulo c7 = new Circulo(530, 55, Color.white, Color.white, 5, true, true, true, "c1");
        Circulo c8 = new Circulo(231, 30, Color.white, Color.white, 5, true, true, true, "c2");
        Circulo c9 = new Circulo(255, 464, Color.white, Color.white, 5, true, true, true, "c3");
        Circulo c10 = new Circulo(651, 243, Color.white, Color.white, 5, true, true, true, "c4");
        Circulo c11 = new Circulo(651, 360, Color.white, Color.white, 5, true, true, true, "c5");
        Circulo c12 = new Circulo(398, 337, Color.white, Color.white, 5, true, true, true, "c6");
        this.lienzo1.getFiguras().add(c7);
        this.lienzo1.getFiguras().add(c8);
        this.lienzo1.getFiguras().add(c9);
        this.lienzo1.getFiguras().add(c10);
        this.lienzo1.getFiguras().add(c11);
        this.lienzo1.getFiguras().add(c12);
            System.out.println("entra ");
            this.lienzo1.getText().get(0).setText("0");
            cambiarfoco();
        creacionHilo();
        
//            System.out.println(this.lienzo1.isEstaJugando());
            
        
        }
    }
    
    public void cambiarfoco(){
        this.btnPause.setFocusable(false);
        this.btnPlay.setFocusable(false);
        this.btnRetry.setFocusable(false);
        this.setFocusable(true);
        
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
        btnPlay = new javax.swing.JButton();
        lbPuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPause = new javax.swing.JButton();
        btnRetry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
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

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        lbPuntos.setText("0");

        jLabel1.setText("Puntos:");

        btnPause.setText("pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnRetry.setText("retry");
        btnRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPlay)
                    .addComponent(lbPuntos)
                    .addComponent(jLabel1)
                    .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRetry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnPlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(lbPuntos)
                .addGap(18, 18, 18)
                .addComponent(btnPause)
                .addGap(18, 18, 18)
                .addComponent(btnRetry)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:     
        this.setFocusable(true);    
//        System.out.println(evt.getKeyChar());
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyChar() == 'w' || evt.getKeyChar() == 'W') {
            this.lienzo1.movimientoArriba(pacman);
            this.lienzo1.setLastKey("w");
            this.pacman.setRuta("src/recursosPacman/pacmanArriba.gif");
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyChar() == 'a' || evt.getKeyChar() == 'A') {
            this.lienzo1.movimientoIzda(pacman);
            this.lienzo1.setLastKey("a");
            this.pacman.setRuta("src/recursosPacman/pacmanIzda.gif");
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyChar() == 's' || evt.getKeyChar() == 'S') {
            this.lienzo1.movimientoAbajo(pacman);
            this.lienzo1.setLastKey("s");
            this.pacman.setRuta("src/recursosPacman/pacmanAbajo.gif");
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
            this.lienzo1.movimientoDerecha(pacman);
            this.lienzo1.setLastKey("d");
            this.pacman.setRuta("src/recursosPacman/pacmanDerecha.gif");
        }
        else if ( evt.getKeyChar() == ' ') {
            
            nivel2();
            this.lienzo1.setGanado(0);
            this.lienzo1.setEstaJugando(true);
            this.lienzo1.setLastKey("q");
        
        
            
            
//            if(this.lienzo1.getGanado()==1){
//              creacionHilo();
//        this.btnPlay.setFocusable(false);
//        this.setFocusable(true);
//        
//        cambiarfoco();  
//            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        
        
//        starter();
        this.lienzo1.setLastKey("q");
        this.lienzo1.getText().get(0).setText("0");
        this.btnPlay.setFocusable(false);
        this.lienzo1.setGanado(4);
        
         
        cambiarfoco();
        creacionHilo();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
       
               this.btnPause.setFocusable(false);
              
       this.lienzo1.setEstaJugando(false);
        this.setFocusable(true);
        this.btnPause.setFocusable(false);
         cambiarfoco();
         
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetryActionPerformed
        // TODO add your handling code here:
        
        this.lienzo1.setEstaJugando(false);
        while(this.proceso.isAlive()){
            System.out.println("todavia vive");
        }
//        this.btnRetry.setFocusable(false);
//        this.setFocusable(true);
        starter();
        this.lienzo1.setLastKey("q");
        this.lienzo1.getText().get(0).setText("0");
        this.btnRetry.setFocusable(false);
        cambiarfoco();
        creacionHilo();
        if(this.lienzo1.getGanado()==0){
            this.lienzo1.setEstaJugando(false);
            
        while(this.proceso.isAlive()){
            System.out.println("todavia vive");
        }
//        this.btnRetry.setFocusable(false);
//        this.setFocusable(true);
        nivel2();
        }
    }//GEN-LAST:event_btnRetryActionPerformed

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
                int example=0;
                new Inicio().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRetry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbPuntos;
    private Controladores.Lienzo lienzo1;
    // End of variables declaration//GEN-END:variables
}
