/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.TablaHash;
import Estructura.TablaHash.ListaN;
import Entidad.Cliente;
/**
 *
 * @author Co
 */
public class ListaN {
    public Cliente dato;
    public ListaN nextt,previous;

    public ListaN(Cliente dato) {
        this.dato = dato;
        this.nextt=null;
        this.previous=null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }
    
    
}
