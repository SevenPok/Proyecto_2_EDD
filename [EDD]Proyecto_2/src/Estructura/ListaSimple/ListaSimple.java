package Estructura.ListaSimple;

import java.util.Iterator;

public class ListaSimple<T extends Comparable<T>> implements Iterable<T> {

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

    public Nodo<T> search(T data) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            while (aux != null) {
                if (aux.getData().compareTo(data) == 0) {
                    return aux;
                }
                aux = aux.getNext();
            }
        }
        return null;
    }

    public Nodo<T> search(int index) {
        if (isEmpty() || (index < 0 || index >= size)) {
            return null;
        } else if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return end;
        } else {

            Nodo<T> aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux;

        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            if (head != end) {
                Nodo<T> aux = head;
                while (aux.getNext() != end) {
                    aux = aux.getNext();
                }
                end = aux;
                end.setNext(null);
            } else {
                head = end = null;
            }
            size--;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            Nodo<T> aux = head.getNext();
            head = null;
            head = aux;
            if (size == 1) {
                end = null;
            }
            size--;
        }
    }

    public boolean remove(int index) {
        if (isEmpty() || (index < 0 || index >= size)) {
            return false;
        } else if (index == 0) {
            removeFirst();
            return true;
        } else if (index == size - 1) {
            removeLast();
            return true;
        } else {
            Nodo<T> aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            size--;
            return true;
        }
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

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<ListaSimple>();
    }

    private class MyIterator<ListaSimple> implements Iterator<T> {

        private int next;

        @Override
        public boolean hasNext() {
            return search(next) != null;
        }

        @Override
        public T next() {
            T data = search(next).getData();
            next++;
            return data;
        }

    }

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        for (int i : lista) {
            System.out.println(i);
        }
    }

}
