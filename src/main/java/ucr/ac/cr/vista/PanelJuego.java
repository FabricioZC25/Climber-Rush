/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.vista;

import java.awt.Graphics;
import ucr.ac.cr.controlador.ControladorGUIJuego;

/**
 *
 * @author Fabricio
 */
public class PanelJuego extends javax.swing.JPanel {

    private ControladorGUIJuego controladorGUIJuego;

    /**
     * Creates new form PanelJuego
     */
    public PanelJuego() {
        initComponents();
        controladorGUIJuego = new ControladorGUIJuego(this);
    }
    
      public ControladorGUIJuego getControladorGUIJuego() {
        return controladorGUIJuego;
    }
    
    public void setControlador(ControladorGUIJuego controladorGUIJuego) {
        this.controladorGUIJuego = controladorGUIJuego;
    }


    public void repaint(Graphics g) {
        controladorGUIJuego.dibujar(g);

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        controladorGUIJuego.dibujar(g);

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
            .addGap(0, 435, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
