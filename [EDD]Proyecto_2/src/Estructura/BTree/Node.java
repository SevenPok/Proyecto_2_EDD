/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.BTree;

import Entidad.Vehiculo;

public class Node {

    public static int m = 5;
    private static int numPunteros = m + 1;
    private static int numLlaves = m;
    public Boolean hoja = true;
    public int ULlave = 1;
    public Vehiculo[] llaves = new Vehiculo[numLlaves];
    public Node[] punteros = new Node[numPunteros];
    public Node Padre;

    public Node(Object objeto) {
        Vehiculo vehiculo = (Vehiculo) objeto;
        llaves[0] = vehiculo;

    }

    public Node() {
        for (int i = 0; i < m - 1; i++) {
            llaves[i] = null;
        }
        this.Padre = null;
    }
}
