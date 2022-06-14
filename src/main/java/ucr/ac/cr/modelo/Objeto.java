/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabricio
 */
public class Objeto extends Elemento {

//    private ImageIcon img;
    private int direccion;
    int dx, dy;  
    int ax, ay;
    int x, y;

    public Objeto(ImageIcon img, int x, int y, int direccion) {
        super(img, x, y);
        this.direccion = direccion;
        dx = dy = 0;
        ax = ay = 1;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void dibujar(Graphics g) {
        getImagen().paintIcon(null, g, getX(), getY());

    }

    public void update() {
        dx += ax;
        dy += ay;

        x += dx;
        y += dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getImagen().getIconWidth(), getImagen().getIconWidth());
    }

    public void mover() {
        switch (direccion) {
            case 0:
                if (getY() < 800) {
                    setY(getY() + 50);
                } else {
                    setY(0);
                }
                break;
            case 1:
                if (getY() < 800) {
                    setY(getY() + 1);
                } else {
                    setY(0);
                }
            case 2:
                if (getY() < 800) {
                    setY(getY() + 1);
                } else {
                    setY(0);
                }
            case 3:
                if (getY() < 850) {
                    setY(getY() + 12);
                } else {
                    setY(0);
                }
                break;
            case 4:
                if (getY() < 850) {
                    setY(getY() + 11);
                } else {
                    setY(0);
                }
            case 5:
                if (getY() < 850) {
                    setY(getY() + 10);
                } else {
                    setY(0);
                }

        }

    }

}
