/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.TablaHash;
import Entidad.Cliente;
/**
 *
 * @author Co
 */
public class NodoTabla {
    public int ident;
    public ListaDoble lista;
    public boolean eliminado;

    public NodoTabla(int ident,Cliente cli) {
        this.ident=ident;
        this.lista= new ListaDoble();
        lista.Insertar(cli);
    }
    
}
