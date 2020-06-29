package Estructura.ListaDoble;

import Entidad.Grafica;
import javax.swing.table.DefaultTableModel;

public class ListaDobleCircular<T extends Comparable<T>> {

    private Nodo<T> head;
    private Nodo<T> end;
    private int size;

    public ListaDobleCircular() {
        this.head = null;
        this.end = null;
        this.size = 0;
    }

    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getEnd() {
        return end;
    }

    public void setEnd(Nodo<T> end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            nuevo.setBack(nuevo);
            head = nuevo;
            end = nuevo;
        } else {
            nuevo.setNext(head);
            nuevo.setBack(end);
            head.setBack(nuevo);
            end.setNext(nuevo);
            head = nuevo;
        }
        size++;
    }

    public void addLast(T data) {

        if (isEmpty()) {
            addFirst(data);
        } else {
            Nodo<T> nuevo = new Nodo<>(data);
            nuevo.setNext(head);
            nuevo.setBack(end);
            head.setBack(nuevo);
            end.setNext(nuevo);
            end = nuevo;
            size++;
        }
    }

    public boolean remove(T data) {
        Nodo<T> value = search(data);
        if (value != null) {
            if (size == 1) {
                head = null;
                end = null;
            } else if (value == head) {
                head = head.getNext();
                head.setBack(end);
                end.setNext(head);
            } else if (value == end) {
                end = end.getBack();
                end.setNext(head);
                head.setBack(end);
            } else {
                value.getBack().setNext(value.getNext());
                value.getNext().setBack(value.getBack());
            }
            size--;
            return true;
        }
        return false;
    }

    public Nodo<T> search(T data) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            do {
                if (aux.getData().compareTo(data) == 0) {
                    return aux;
                }
                aux = aux.getNext();
            } while (aux != head);
        }
        return null;
    }

    public void showConsole() {
        if (isEmpty()) {
            System.out.println("Esta vacia la lista");
        } else {
            Nodo<T> aux = head;
            do {
                System.out.println(aux.getData().toString());
                aux = aux.getNext();
            } while (aux != head);
        }
    }

    public void setModelo(DefaultTableModel modelo) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            do {
                modelo.addRow(aux.getData().toString().split("-"));
                aux = aux.getNext();
            } while (aux != head);
        }
    }

    public void graficar() {
        if (isEmpty()) {
            System.out.println("Esta vacia la lista");
        } else {
            Nodo<T> aux = head;
            String cadena = "node[shape=box]\n";
            String alinear = "{rank=same;";
            do {
                cadena += aux.getData().hashCode() + "->" + aux.getNext().getData().hashCode() + "\n";
                cadena += aux.getData().hashCode() + "->" + aux.getBack().getData().hashCode() + "\n";
                alinear += aux.getData().hashCode() + ";";
                aux = aux.getNext();
            } while (aux != head);
            alinear += "}\n";
            cadena += alinear;
            cadena += label();
            Grafica.graficar(cadena, "Conductores");
        }
    }

    private String label() {
        if (isEmpty()) {
            System.out.println("Esta vacia la lista");
            return "";
        } else {
            Nodo<T> aux = head;
            String cadena = "";
            do {
                cadena += aux.getData().hashCode() + "[label=\"DPI: " + aux.getData().toString().split("-")[0] + "\"]\n";
                aux = aux.getNext();
            } while (aux != head);
            return cadena;
        }
    }
}
