/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabricio
 */
public class Personaje {

    private int x = 10;
    private int y = 10;
    private ImageIcon img ;
    private int vidas;
    int oro;
    private int movimiento = 270;

    public Personaje(ImageIcon img , int x, int y, int vidas, int oro) {
        this.x = x;
        this.y = y;
        this.img  = img ;
        this.vidas = vidas;
        this.oro = oro;
        
    }

    public int getOro() {
        return oro;
    }
    

    public void setOro(int oro) {
        this.oro = oro;
    }
 

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void show(Graphics g) {
        img .paintIcon(null, g, x, y);
    }

    public void teclaPresionada(KeyEvent evento) {

        if (evento.getKeyCode() == 65) { //IZQUIERDA
            x = x - movimiento;
        }
        if (evento.getKeyCode() == 68) { //DERECHA
            x = x + movimiento;
        }
            if (evento.getKeyCode() == 83) { //ARRIBA
            y = y + movimiento;
        }
        if (evento.getKeyCode() == 87) { //ABAJO
            y = y - movimiento;
        }
      
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, img.getIconWidth(), img.getIconHeight());
    }

}
