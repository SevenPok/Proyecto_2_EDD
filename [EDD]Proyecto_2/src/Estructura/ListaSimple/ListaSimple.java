package Estructura.ListaSimple;

public class ListaSimple<T extends Comparable<T>> {

    private Nodo<T> head;
    private Nodo<T> end;
    private int size;

    public ListaSimple() {
        this.end = null;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (isEmpty()) {
            head = nuevo;
            end = nuevo;
        } else {
            nuevo.setNext(head);
            head = nuevo;
        }
        size++;
    }

    public void addLast(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (isEmpty()) {
            addFirst(data);
        } else {
            end.setNext(nuevo);
            end = nuevo;
            size++;
        }
    }

    public T search(T data) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            while (aux != null) {
                if (aux.getData().compareTo(data) == 0) {
                    return aux.getData();
                }
                aux = aux.getNext();
            }
        }
        return null;
    }

    public boolean remove(T data) {
        int delete = searchIndex(data);
        if (delete >= 0) {

        }
        return false;
    }

    private int searchIndex(T data) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            int contador = 0;
            while (aux != null) {
                if (aux.getData().compareTo(data) == 0) {
                    return contador;
                }
                aux = aux.getNext();
                contador++;
            }
        }
        return -1;
    }

    public void showConsole() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo<T> aux = head;
            while (aux != null) {
                System.out.println(aux.getData().toString());
                aux = aux.getNext();
            }
        }
    }
}
