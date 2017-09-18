/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.beans;

/**
 *
 * @author Josseline
 */
public class Table {

    private String nombre_columna;
    private String dato;

    public Table(String nombre_columna) {
        this.nombre_columna = nombre_columna;

    }

    public String getNombre_columna() {
        return nombre_columna;
    }

    public void setNombre_columna(String nombre_columna) {
        this.nombre_columna = nombre_columna;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
