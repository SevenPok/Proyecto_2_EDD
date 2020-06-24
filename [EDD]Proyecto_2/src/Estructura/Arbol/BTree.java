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

    public void graficar() {
        if (this.root != null) {
            this.root.graficar(1);
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

    public static void main(String[] args) {
        Cliente c1 = new Cliente(10, "Gerber David", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c2 = new Cliente(5, "Jose Pablo", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c3 = new Cliente(1, "Julio Alejandro", "Colindres Monterroso", "Masculino", "6ta calle 1-53");
        Cliente c4 = new Cliente(8, "Bruno David", "Colindres Monterroso", "Masculino", "6ta calle 1-53");

        BTree<Integer> t = new BTree(2);
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.insert(10);


        t.graficar();

    }
}
