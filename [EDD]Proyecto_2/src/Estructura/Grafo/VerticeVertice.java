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
public class VerticeVertice implements Comparable<VerticeVertice> {

    private Vertice origen;
    private Vertice destino;

    public VerticeVertice(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    @Override
    public int compareTo(VerticeVertice o) {
        if (o.getOrigen().compareTo(origen) == 0 && o.getDestino().compareTo(destino) == 0) {
            return 0;
        }
        return -1;
    }

}
