/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.vista;
//(1) PAQUETE

import java.awt.*;

import javax.swing.*;
import ucr.ac.cr.modelo.Tiempo;

//(2) FORMULARIO
public class Programa extends JFrame {
    
    private Tiempo tiempo;

    //(3) CONTROLES DEL FORMULARIO        
    JPanel jpanel = (JPanel) this.getContentPane();

    JLabel jlabel = new JLabel();

    //(4) CONSTRUCTOR DEL FORMULARIO       
    public Programa() {

        //(5) PROPIEDADES DEL CONTENEDOR
        jpanel.setLayout(null);

        jpanel.setBackground(Color.lightGray);

        //(6) PROPIEDADES DE LOS CONTROLES         
        jlabel.setBounds(new Rectangle(5, 15, 220, 21));

        jlabel.setText("Tiempo " +tiempo.getMinutos()+ ":" + tiempo.getSegundos());

        //(7) ADICION DE LOS CONTROLES AL CONTENEDOR        
        jpanel.add(jlabel, null);

        //(8) PROPIEDADES DEL FORMULARIO         
        setSize(300, 150);
        setTitle("Resultados");
        setVisible(true);

    }

    //(9) METODOS DEL FORMULARIO     
    public static void main(String arg[]) {
        new Programa();
    }

}
