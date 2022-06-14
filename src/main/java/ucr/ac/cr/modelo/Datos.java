/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author Fabricio
 */
public class Datos  {

    private String nombre;
    private String apodo;
    private String minutos;
   

    public static final String[] ETIQUETA_ESTADISTICA = {"Nombre", "Apodo", "Minutos","Segundos"};

    public Datos(String nombre, String apodo, String minutos, String segundos) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.minutos = this.minutos;
//        this.segundos = this.segundos;
        
    }

    public Datos() {
         
    }
 

    public String setDatosEstadistica(int indice) {
        switch (indice) {
            case 0:
                return this.getNombre();
            case 1:
                return this.getApodo();
//            case 2:
//                return Integer.toString(principal.getOro());
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

 

}
