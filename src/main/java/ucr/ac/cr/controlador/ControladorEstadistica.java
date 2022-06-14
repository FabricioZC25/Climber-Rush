/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.WindowConstants;
import ucr.ac.cr.modelo.Datos;
import ucr.ac.cr.modelo.Personaje;
import ucr.ac.cr.modelo.RegistroDatos;
import ucr.ac.cr.vista.GUIEstadistica;
import ucr.ac.cr.vista.PanelEstadistica;

/**
 *
 * @author Fabricio
 */
public class ControladorEstadistica implements ActionListener, MouseListener {

    private GUIEstadistica guiEstadistica;
    private PanelEstadistica panelEstadistica;
    private Personaje principal;
    private RegistroDatos registroDatos;
    private Datos datos;

    public ControladorEstadistica(GUIEstadistica guiEtadistica, PanelEstadistica panelEstadistica) {
        registroDatos = new RegistroDatos();
        this.guiEstadistica = guiEstadistica;
        this.panelEstadistica = panelEstadistica;
        this.panelEstadistica.setDatosTablaEstadistica(registroDatos.getDatosTabla());

    }

    public void actionPerformed(ActionEvent evento) {
        String valor = evento.getActionCommand();

        switch (valor) {
            case "Agregar":

                String nombre = panelEstadistica.getTxtNombre();
                String apodo = panelEstadistica.getTxtApodo();
                String minutos = Integer.toString(datos.getMinutos());  
                String segundos = Integer.toString(datos.getSegundos()); 
                
                

                if (nombre.equals("") || apodo.equals("")) {
                    panelEstadistica.mostrarMensaje("Por favor, llene los espacios correspondientes");
                } else {
                    datos = registroDatos.buscar(panelEstadistica.getTxtNombre());

                    if (datos == null) {
                        datos = new Datos(nombre, apodo, minutos, segundos);
                        registroDatos.agregar(datos);
                        panelEstadistica.limpiarTodo();
                        panelEstadistica.setDatosTablaEstadistica(registroDatos.getDatosTabla());

                    } else {
                        panelEstadistica.mostrarMensaje("La figura ya ha sido agregada");

                    }

                    panelEstadistica.limpiarTodo();

                }
                break;


            case "Salir":
                
                System.exit(0);
                 
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.err.println(panelEstadistica.getFilaTabla());
        datos = (Datos) registroDatos.buscar(panelEstadistica.getFilaTabla());
        panelEstadistica.setTxtNombre(datos.getNombre());
        panelEstadistica.setTxtApodo(datos.getApodo());
        Integer.toString(principal.getOro()); 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

}
