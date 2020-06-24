/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.Grafo;

/**
 *
 * @author SevenPok
 */
public class Vertice implements Comparable<Vertice> {

    public Vertice next;
    public Arista adjacent;
    public String nombre;

    public Vertice(Vertice next, Arista adjacent, String nombre) {
        this.next = next;
        this.adjacent = adjacent;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Vertice o) {
        if (o.nombre.compareToIgnoreCase(nombre) == 0) {
            return 0;
        } else if (o.nombre.compareToIgnoreCase(nombre) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
