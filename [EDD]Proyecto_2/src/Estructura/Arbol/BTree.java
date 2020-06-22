package Estructura.Arbol;

import Entidad.Cliente;

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

    public Nodo search(T data) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.search(data);
        }
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

    public static void main(String[] args) {
        Cliente c1 = new Cliente(10, "Gerber David", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c2 = new Cliente(5, "Jose Pablo", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c3 = new Cliente(1, "Julio Alejandro", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c4 = new Cliente(8, "Bruno David", "Colindres Monterroso", "Masculino", "6ta calle 1-53");

        BTree<Integer> t = new BTree(2);
        t.insert(10);
        t.insert(5);
        t.insert(1);
        t.insert(8);
        t.insert(50);
        t.insert(33);
        t.insert(2);
        t.insert(15);
        t.insert(20);
        t.insert(30);
        t.insert(11);
        t.insert(12);
        t.insert(13);
        t.insert(14);

        t.traverse();
    }
}
