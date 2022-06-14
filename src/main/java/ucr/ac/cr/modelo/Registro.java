/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.modelo;

/**
 *
 * @author UCR
 */
public interface Registro {
    public String agregar(Object objeto);
    public Object buscar(String id);
    public String eliminar(String id);
    public String eliminar(Object objeto);
}
