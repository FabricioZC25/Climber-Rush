/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.AreaJuego;
import ucr.ac.cr.modelo.Fondo;
import ucr.ac.cr.modelo.Objeto;
import ucr.ac.cr.modelo.Personaje;
import ucr.ac.cr.modelo.Tiempo;
import ucr.ac.cr.vista.GUIJuego;
import ucr.ac.cr.vista.PanelJuego;

/**
 *
 * @author Fabricio
 */
public class ControladorGUIJuego implements KeyListener {

    private Personaje principal;
    private PanelJuego panelJuego;
    private GUIJuego guiJuego;
    private AreaJuego areaJuego;
    private ControladorJuego controladorJuego;
    private Tiempo tiempo;

    public ControladorGUIJuego(PanelJuego panelJuego) {

        areaJuego = new AreaJuego();
        principal = areaJuego.getPersonaje();
        this.panelJuego = panelJuego;
        panelJuego.setControlador(this);
        controladorJuego = new ControladorJuego(areaJuego, panelJuego, guiJuego, this);
        tiempo = new Tiempo(areaJuego, panelJuego, guiJuego, this);
        controladorJuego.start();
        tiempo.start();

    }

    public void setGUIJuego(GUIJuego guiJuego) {
        this.guiJuego = guiJuego;

    }

    public void actualizar() {
        panelJuego.repaint();
    }

    public void detener() {
        tiempo.suspend();
        JOptionPane.showMessageDialog(null,
                "Tiempo " +tiempo.getMinutos()+ ":" + tiempo.getSegundos()
                +"   " +principal.getOro()
                +"   " +principal.getVidas()
        );
         
    }

    public void dibujar(Graphics g) {
        panelJuego.setControlador(this);
        areaJuego.getFondo().show(g);

        for (int posicion = 0; posicion < areaJuego.getCantidadObjetivo(); posicion++) {
            areaJuego.getObjetivo(posicion).show(g);
        }
        principal.show(g);
        for (int posicion = 0; posicion < areaJuego.getCantidadObstaculos(); posicion++) {
            areaJuego.getObstaculo(posicion).show(g);
        }
        areaJuego.dibujarDatos(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        principal.teclaPresionada(e);
        panelJuego.repaint();
        areaJuego.getColisionObjetivo();
        areaJuego.getColisionObstaculo();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
