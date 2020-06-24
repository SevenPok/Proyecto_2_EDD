package Estructura.Grafo;

import Estructura.ListaSimple.Cola;
import Estructura.ListaSimple.ListaSimple;
import Estructura.ListaSimple.Pila;
import javafx.util.Pair;

public class Grafo {

    private Vertice root;

    public Grafo() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        Vertice aux = root;
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.next;
        }
        return contador;
    }

    public Vertice getVertice(String nombre) {
        Vertice aux = root;
        while (aux != null) {
            if (aux.nombre.equalsIgnoreCase(nombre)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    public void insertArista(Vertice origen, Vertice destino, int peso) {
        Arista nuevo = new Arista(null, null, peso);
        Arista aux = origen.adjacent;

        if (aux == null) {
            origen.adjacent = nuevo;
            nuevo.adjacent = destino;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
            nuevo.adjacent = destino;
        }
    }

    public void insertVertice(String nombre) {
        Vertice nuevo = new Vertice(null, null, nombre);
        if (isEmpty()) {
            root = nuevo;
        } else {
            Vertice aux = root;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
    }

    public String listaAdyacencia() {
        Vertice auxVertice = root;
        Arista auxArista;
        String cadena = "node [shape=box]\n";
        String back = "";
        String next = "";
        String alinear = "{rank=same;";
        while (auxVertice != null) {

            auxArista = auxVertice.adjacent;
            cadena += generarId(auxVertice) + generarLabel(auxVertice) + "\n";
            back = generarId(auxVertice);
            alinear += back + ";";
            while (auxArista != null) {
                cadena += generarId(auxVertice, auxArista) + generarLabel(auxArista.adjacent) + "\n";
                next = generarId(auxVertice, auxArista);
                cadena += back + "->" + next + "\n";
                back = generarId(auxVertice, auxArista);
                alinear += back + ";";
                auxArista = auxArista.next;
            }
            alinear += "}\n";
            if (auxVertice.next != null) {
                cadena += generarId(auxVertice) + "->" + generarId(auxVertice.next) + "\n";
            }
            cadena += alinear;
            alinear = "{rank=same;";
            auxVertice = auxVertice.next;
        }

        return cadena;
    }

    public void show() {
        Vertice auxVertice = root;
        Arista auxArista;
        while (auxVertice != null) {
            auxArista = auxVertice.adjacent;
            System.out.print(auxVertice.nombre);
            while (auxArista != null) {
                System.out.print("->" + auxArista.adjacent.nombre);
                auxArista = auxArista.next;
            }
            auxVertice = auxVertice.next;
            System.out.println("");
        }
    }

    public String graficaRutas() {
        String cadena = "rankdir=LR size=\"8,5\"\n"
                + "	node [shape=circle]\n";
        Vertice auxVertice = root;
        Arista auxArista;
        while (auxVertice != null) {
            cadena += "\"" + auxVertice.nombre + "\"\n";
            auxArista = auxVertice.adjacent;
            while (auxArista != null) {
                cadena += "\"" + auxVertice.nombre + "\"->\"" + auxArista.adjacent.nombre + "\"[dir=none label=\"" + auxArista.peso + "\"]\n";
                auxArista = auxArista.next;
            }
            auxVertice = auxVertice.next;
        }
        return cadena;
    }

    private String generarLabel(Vertice vertice) {
        String cadena = "";
        cadena += "[label=\"" + vertice.nombre + "\"]";
        return cadena;
    }

    private String generarId(Vertice vertice, Arista arista) {
        String cadena = "";
        cadena += "\"" + vertice.nombre + arista.adjacent.nombre + "\"";
        return cadena;
    }

    private String generarId(Vertice vertice) {
        String cadena = "";
        cadena += "\"" + vertice.nombre + "\"";
        return cadena;
    }

    public void recorridoAnchura(Vertice origen) {
        int band;
        int band2;
        Vertice actual;
        Cola<Vertice> cola = new Cola<>();
        ListaSimple<Vertice> lista = new ListaSimple<>();

        cola.enqueue(origen);
        while (!cola.isEmpty()) {
            band = 0;
            actual = cola.top();
            cola.dequeue();
            for (Vertice i : lista) {
                if (i == actual) {
                    band = 1;
                }
            }
            if (band == 0) {
                System.out.print(actual.nombre + ", ");
                lista.addLast(actual);
                Arista aux;
                aux = actual.adjacent;
                while (aux != null) {
                    band2 = 0;
                    for (Vertice i : lista) {
                        if (aux.adjacent == i) {
                            band2 = 1;
                        }
                    }

                    if (band2 == 0) {
                        cola.enqueue(aux.adjacent);
                    }
                    aux = aux.next;
                }
            }
        }
    }

    public void recorridoProfundidad(Vertice origen) {

        int band, band2;
        Vertice actual;
        Pila<Vertice> pila = new Pila<>();
        ListaSimple<Vertice> lista = new ListaSimple<>();

        pila.push(origen);
        while (!pila.isEmpty()) {
            band = 0;
            actual = pila.top();
            pila.pop();

            for (Vertice i : lista) {
                if (i == actual) {
                    band = 1;
                }
            }
            if (band == 0) {
                System.out.print(actual.nombre + ", ");
                lista.addLast(actual);

                Arista aux = actual.adjacent;
                while (aux != null) {
                    band2 = 0;
                    for (Vertice i : lista) {
                        if (i == aux.adjacent) {
                            band2 = 1;
                        }
                    }
                    if (band2 == 0) {
                        pila.push(aux.adjacent);
                    }
                    aux = aux.next;
                }

            }
        }
    }

    public void primeroMejor(Vertice origen, Vertice destino) {
        Pair<Vertice, Integer> VerticeCosto;
    }

    public boolean Comparacion(Pair<Vertice, Integer> a, Pair<Vertice, Integer> b) {
        return a.getValue() < b.getValue();
    }
}
