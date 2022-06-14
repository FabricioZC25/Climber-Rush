/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabricio
 */
public class Elemento {

    private ImageIcon img;
    private int x;
    private int y;

    public Elemento(ImageIcon img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ImageIcon getImagen() {
        return img;
    }

    public void setImagen(ImageIcon img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void show(Graphics g) {
        img.paintIcon(null, g, x, y);
    }
}
