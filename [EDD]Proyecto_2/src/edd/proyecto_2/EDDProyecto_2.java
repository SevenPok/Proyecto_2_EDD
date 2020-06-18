/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto_2;

import Estructura.ListaSimple.ListaSimple;

/**
 *
 * @author SevenPok
 */
public class EDDProyecto_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(3);
        lista.addFirst(4);
        lista.showConsole();
        System.out.println("Se encontro: " + lista.search(1));
    }
    
}
