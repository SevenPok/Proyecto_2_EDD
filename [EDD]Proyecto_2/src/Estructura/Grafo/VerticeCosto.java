package Estructura.Grafo;

public class VerticeCosto implements Comparable<VerticeCosto> {

    private Vertice vertice;
    private int costo;

    public VerticeCosto(Vertice vertice, int costo) {
        this.vertice = vertice;
        this.costo = costo;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public int compareTo(VerticeCosto o) {
        if (o.getCosto() == this.costo) {
            return 0;
        } else if (o.getCosto() > this.costo) {
            return 1;
        } else {
            return -1;
        }
    }

}
