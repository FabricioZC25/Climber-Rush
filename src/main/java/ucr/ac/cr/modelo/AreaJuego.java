/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ucr.ac.cr.controlador.ControladorGUIJuego;
import ucr.ac.cr.controlador.ControladorJuego;

/**
 *
 * @author Fabricio
 */
public class AreaJuego {

 

    private ArrayList<Objeto> tesoro;
    private ArrayList<Objeto> obstaculos;
    private Personaje principal;
    private Fondo fondo;
    private Tiempo tiempo;
    private ControladorJuego controladorJuego;
    private ControladorGUIJuego controladorGUIJuego;

    public AreaJuego() {
        obstaculos = new ArrayList<Objeto>();
        tesoro = new ArrayList<Objeto>();
        setElementos();


    }

    public void setElementos() {
        crearPersonaje();
        crearObstaculos();
        crearObjetivo();
        crearFondo();
    }

    public void crearPersonaje() {
        ImageIcon personaje = new ImageIcon("./src/main/resources/img/Zio5.gif");
        principal = new Personaje(personaje, 350, 575, 6, 0);
    }

    public Personaje getPersonaje() {
        return principal;
    }

    public void crearFondo() {
        ImageIcon iFondo = new ImageIcon("./src/main/resources/img/Fondoo.png");
        fondo = new Fondo(iFondo, 0, -3200);
    }

    public void moverFondo() {
        fondo.setY(fondo.getY() + 1);
    }

    public Elemento getFondo() {
        return fondo;
    }

    public void crearObstaculos() {
        ImageIcon roca = new ImageIcon("./src/main/resources/img/Roca250.png");
        Objeto obstaculo = new Objeto(roca, 50, 200, 0);
        obstaculos.add(obstaculo);
        roca = new ImageIcon("./src/main/resources/img/Roca250.png");
        obstaculo = new Objeto(roca, 330, 750, 1);
        obstaculos.add(obstaculo);
        roca = new ImageIcon("./src/main/resources/img/Roca250.png");
        obstaculo = new Objeto(roca, 550, 450, 2);
        obstaculos.add(obstaculo);

    }

    public Objeto getObstaculo(int posicion) {
        return obstaculos.get(posicion);
    }

    public int getCantidadObstaculos() {
        return obstaculos.size();
    }

    public void crearObjetivo() {
        ImageIcon oro = new ImageIcon("./src/main/resources/img/Gold1.png");
        Objeto objetivo = new Objeto(oro, 100, 1, 3);
        tesoro.add(objetivo);
        oro = new ImageIcon("./src/main/resources/img/Gold1.png");
        objetivo = new Objeto(oro, 380, 1, 4);
        tesoro.add(objetivo);
        oro = new ImageIcon("./src/main/resources/img/Gold1.png");
        objetivo = new Objeto(oro, 635, 1, 5);
        tesoro.add(objetivo);

    }

    public Objeto getObjetivo(int posicion) {
        return tesoro.get(posicion);
    }

    public int getCantidadObjetivo() {
        return tesoro.size();
    }

    public boolean getColisionObstaculo() {
        for (int i = 0; i < this.getCantidadObstaculos(); i++) {
            if (principal.getBounds().intersects(obstaculos.get(i).getBounds())) {
                efectoSonido("./src/main/resources/sonido/Sound.wav");
                System.out.println("Vidas "+principal.getVidas());
                principal.setVidas(principal.getVidas() - 1);

                return true;
            }
        }
        return false;
    }

    public boolean getColisionObjetivo() {
        for (int i = 0; i < this.getCantidadObjetivo(); i++) {
            if (principal.getBounds().intersects(tesoro.get(i).getBounds())) {
                efectoSonido("./src/main/resources/sonido/Coin.wav");
                System.out.println("Oro "+principal.getOro());
                principal.setOro(principal.getOro() + 1);

                return true;
            }
        }
        return false;
    }

    public void dibujarDatos(Graphics g) {
        Font score = new Font("Arial", Font.BOLD, 50);
        g.setFont(score);
        g.setColor(Color.BLACK);
        g.drawString("" + principal.getOro(), 40, 70);
        g.drawString("" + principal.getVidas(), 40, 150);
        

    }

    public boolean ganador() {
        if (principal.getVidas() > 0) {
            return true;
        }
        return false;
    }

    public boolean perdedor() {
        if (principal.getOro() <= 4) {
            return true;
        }
        return false;
    }

    public void efectoSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {

        }
    }

}
