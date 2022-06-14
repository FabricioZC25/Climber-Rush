/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ucr.ac.cr.modelo.AreaJuego;
import ucr.ac.cr.modelo.Fondo;
import ucr.ac.cr.modelo.Objeto;
import ucr.ac.cr.modelo.Personaje;
import ucr.ac.cr.modelo.Tiempo;
import ucr.ac.cr.vista.GUIGanador;
import ucr.ac.cr.vista.GUIJuego;
import ucr.ac.cr.vista.GUIPerdedor;
import ucr.ac.cr.vista.PanelJuego;

/**
 *
 * @author Fabricio
 */
public class ControladorJuego extends Thread {

    private PanelJuego panelJuego;
    private AreaJuego areaJuego;
    private GUIJuego guiJuego;
    private Personaje personaje;
    private ControladorGUIJuego controladorGUIJuego;
    private GUIGanador guiGanador;
    private GUIPerdedor guiPerdedor;
    private Tiempo tiempo;
    private Objeto obj;

    public ControladorJuego(AreaJuego areaJuego, PanelJuego panelJuego, GUIJuego guiJuego, ControladorGUIJuego controladorGUIJuego) {
        this.areaJuego = areaJuego;
        this.panelJuego = panelJuego;
        this.guiJuego = guiJuego;
        this.controladorGUIJuego = controladorGUIJuego;

    }

 
    @Override
    public void run() {
        while (areaJuego.ganador() && areaJuego.perdedor()) {

            try {
                
                    
                 
                for (int posicion = 0; posicion < areaJuego.getCantidadObstaculos(); posicion++) {
                    areaJuego.getObstaculo(posicion).mover();

                }
                for (int posicion = 0; posicion < areaJuego.getCantidadObjetivo(); posicion++) {
                    areaJuego.getObjetivo(posicion).mover();

                }
                sleep(250);
                areaJuego.moverFondo();
                controladorGUIJuego.actualizar();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (!areaJuego.ganador()) {
            System.out.println("perdio");
            GUIPerdedor guiPerdedor = new GUIPerdedor();
            guiPerdedor.setVisible(true);
            controladorGUIJuego.detener();

        }
        if (!areaJuego.perdedor()) {
            System.out.println("gano");
            GUIGanador guiGanador = new GUIGanador();
            guiGanador.setVisible(true);
            controladorGUIJuego.detener();

        }

    }
}
