/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ucr.ac.cr.controlador.ControladorGUIJuego;
import ucr.ac.cr.modelo.AreaJuego;
import ucr.ac.cr.modelo.Fondo;
import ucr.ac.cr.modelo.Objeto;
import ucr.ac.cr.modelo.Personaje;
import ucr.ac.cr.vista.GUIGanador;
import ucr.ac.cr.vista.GUIJuego;
import ucr.ac.cr.vista.GUIPerdedor;
import ucr.ac.cr.vista.PanelJuego;

/**
 *
 * @author Fabricio
 */
public class Tiempo extends Thread { //una clase que hereda de la clase Thread

    int minutos=0, segundos=0;
 
    
    public Tiempo(int minutos , int segundos) {
        this.minutos = minutos;
        this.segundos = segundos;
    }
        
    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int setSegundos(int segundos) {
        this.segundos = segundos;
        return 0;
    }

    public int setMinutos(int minutos) {
        this.minutos = minutos;
        return 0;
    }
    
    
    private PanelJuego panelJuego;
    private AreaJuego areaJuego;
    private GUIJuego guiJuego;
    private ControladorGUIJuego controladorGUIJuego;

    public Tiempo(AreaJuego areaJuego, PanelJuego panelJuego, GUIJuego guiJuego, ControladorGUIJuego controladorGUIJuego) {
        this.areaJuego = areaJuego;
        this.panelJuego = panelJuego;
        this.guiJuego = guiJuego;
        this.controladorGUIJuego = controladorGUIJuego;

    }

    public void run() {
        try {
            for (;;) {
                if (segundos == 59) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 59) {
                    minutos = 0;
                     
                }
                segundos++;

                this.sleep(1000);
          
                System.err.println(+ minutos + ":" + segundos);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
