package Estructura.Arbol;

import Entidad.Cliente;
import Entidad.Grafica;
import javax.swing.table.DefaultTableModel;

public class BTree<T extends Comparable<T>> {

    private Nodo<T> root;
    private int t;

    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void traverse() {
        if (this.root != null) {
            this.root.traverse();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Nodo<T> getRoot() {
        return this.root;
    }

    public void graficar() {
        if (this.root != null) {
            Grafica.cadena += "node[shape=record];\n" + "subgraph clusterBTree { \n"
                    + "\n"
                    + "	 node [shape=record];\n"
                    + "node [style=filled];\n"
                    + "node [fillcolor=\"#EEEEEE\"];\n"
                    + "node [color=\"#8C8C8E\"];\n"
                    + "edge [color=\"#31CEF0\"]; \n";
            this.root.graficar("Vehiculos");
            Grafica.cadena += "}";
            Grafica.graficar(Grafica.cadena, "Vehiculos");
            Grafica.cadena = "";
            System.out.println(Grafica.cadena);
        }

    }

    public String cadena() {
        String cadena = "";
        if (this.root != null) {
            Grafica.cadena += "node[shape=record];\n" + "subgraph clusterBTree { \n"
                    + "\n"
                    + "	 node [shape=record];\n"
                    + "node [style=filled];\n"
                    + "node [fillcolor=\"#EEEEEE\"];\n"
                    + "node [color=\"#8C8C8E\"];\n"
                    + "edge [color=\"#31CEF0\"]; \n";
            this.root.graficar("Vehiculos");
            Grafica.cadena += "}";
            cadena = Grafica.cadena;
            Grafica.cadena = "";
        }
        return cadena;
    }

    public void graficarLabel() {
        if (this.root != null) {

        }
    }

    public void show(DefaultTableModel modelo) {
        if (this.root != null) {
            this.root.show(modelo);
        }
    }

    public Nodo<T> searchTree(T data) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.search(data);
        }
    }

    public T search(T data) {
        Nodo<T> aux = searchTree(data);
        if (aux != null) {
            for (int i = 0; i < aux.n; i++) {
                if (aux.keys[i].compareTo(data) == 0) {
                    return aux.keys[i];
                }
            }
        }
        return null;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Nodo<>(t, true);
            root.keys[0] = data;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                Nodo aux = new Nodo(t, false);
                aux.children[0] = root;
                aux.splitChild(0, root);

                int i = 0;
                if (aux.keys[0].compareTo(data) < 0) {
                    i++;
                }
                aux.children[i].insertNonNull(data);
                root = aux;
            } else {
                root.insertNonNull(data);
            }
        }
    }

    public void remove(T data) {
        if (root == null) {
            System.out.println("El arbol esta vacio");
        } else {
            root.remove(data);
            if (root.n == 0) {
                Nodo<T> aux = root;
                if (root.leaf) {
                    root = null;
                } else {
                    root = root.children[0];
                }
            }
        }
    }

}
