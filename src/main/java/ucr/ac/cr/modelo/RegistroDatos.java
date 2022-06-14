/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Fabricio
 */
public class RegistroDatos {

    private ArrayList<Datos> listaDato;
    private File archivo;
    private JSONObject baseJSONDatos;

    public RegistroDatos() {

        listaDato = new ArrayList<Datos>();
        archivo = new File("datos.json");
        leerJSON();
    }

    public void escribirJSON() {
        JSONArray arregloDatos = new JSONArray();
        baseJSONDatos = new JSONObject();

        for (Datos datos : listaDato) {
            JSONObject objJSONDatos = new JSONObject();
            objJSONDatos.put("nombre", datos.getNombre());
            objJSONDatos.put("apodo", datos.getApodo());
            objJSONDatos.put("minutos", datos.getMinutos());
            objJSONDatos.put("minutos", datos.getSegundos());
            arregloDatos.add(objJSONDatos);
        }
        baseJSONDatos.put("listaDatos", arregloDatos);

        try {

            FileWriter escribir = new FileWriter(archivo);
            escribir.write(baseJSONDatos.toJSONString());
            escribir.flush();
            escribir.close();
        } catch (IOException ex) {
            System.err.print("Error al escribir el archivo");

        }
    }


    public void leerJSON() {
        listaDato = new ArrayList<>();
        JSONParser convierte = new JSONParser();
        try {
            FileReader archivoLee = new FileReader(this.archivo);
            Object obj = convierte.parse(archivoLee);
            baseJSONDatos = (JSONObject) obj;

            JSONArray arregloJSON = (JSONArray) baseJSONDatos.get("listaEstudios");
            for (Object object : arregloJSON) {
                JSONObject objDatos = (JSONObject) object;
                Datos datos = new Datos();
                datos.setNombre(objDatos.get("nombre").toString());
                datos.setApodo(objDatos.get("apodo").toString());
                
                
                listaDato.add(datos);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer");
        } catch (IOException ex) {
            System.err.println("Error al leer");
        } catch (org.json.simple.parser.ParseException ex) {
            ex.printStackTrace();
        }
    }

    public String[][] getDatosTabla() {
        String[][] matrizTabla = new String[this.listaDato.size()][Datos.ETIQUETA_ESTADISTICA.length];
        for (int f = 0; f < this.listaDato.size(); f++) {
            for (int c = 0; c < matrizTabla[0].length; c++) {
                matrizTabla[f][c] = this.listaDato.get(f).setDatosEstadistica(c);
            }
        }
        return matrizTabla;
    }

    public String agregar(Datos datos) {

        if (listaDato.contains(datos)) {
            escribirJSON();
            return "El estudio ya estaba registrado";
        } else {
            if (listaDato.add(datos)) {
                return "El estudio se registró correctamente";
            } else {
                return "Error al registrar estudio";
            }
        }
    }

    public String[] getApodo() {
        String[] listaDatos = new String[listaDato.size()];
        for (int i = 0; i < listaDato.size(); i++) {
            listaDatos[i] = listaDato.get(i).getApodo();
        }
        return listaDatos;
    }

    public Datos buscar(String nombre) {
        for (int indice = 0; indice < listaDato.size(); indice++) {
            if (listaDato.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaDato.get(indice);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String salida = "Lista estudio: \n";
        Iterator it = this.listaDato.iterator();
        while (it.hasNext()) {
            salida += it.next() + "\n";
        }
        return salida;
    }

}
