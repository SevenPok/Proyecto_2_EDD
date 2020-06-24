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
public class Arista {

    public Arista next;
    public Vertice adjacent;
    public int peso;

    public Arista(Arista next, Vertice adjacent, int peso) {
        this.next = next;
        this.adjacent = adjacent;
        this.peso = peso;
    }

}
