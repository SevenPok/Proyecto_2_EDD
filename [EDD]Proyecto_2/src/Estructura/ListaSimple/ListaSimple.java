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

    public Nodo<T> buscar(T data) {
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

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Nodo<T> delete = end;
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
            return delete.getData();
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Nodo<T> aux = head.getNext();
            Nodo<T> delete = head;
            head = null;
            head = aux;
            if (size == 1) {
                end = null;
            }
            size--;
            return delete.getData();
        }
    }

    public T remove(int index) {
        if (isEmpty() || (index < 0 || index >= size)) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();

        } else {
            Nodo<T> aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            size--;
            return aux.getData();
        }
    }

    public T add(T data, int index) {
        if (index == 0) {
            addFirst(data);
            return head.getData();
        } else if (index == size) {
            addLast(data);
            return end.getData();
        } else if (index < 0 || index >= size) {
            return null;
        } else {
            Nodo<T> back = search(index - 1);
            Nodo<T> actual = search(index);
            Nodo<T> aux = new Nodo<>(data, actual);
            back.setNext(aux);
            size++;
            return search(index).getData();
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

    public void ordenar() {
        Nodo<T> aux = head;
        Nodo<T> aux2 = null;
        T dato = null;
        while (aux != null) {
            aux2 = head;
            while (aux2 != null) {
                if (aux.getData().compareTo(aux2.getData()) > 0) {
                    dato = aux.getData();
                    aux.setData(aux2.getData());
                    aux2.setData(dato);
                }
                aux2 = aux2.getNext();
            }
            aux = aux.getNext();
        }

    }

    public void sort() {
        Nodo<T> aux = head;
        Nodo<T> aux2 = null;
        T dato = null;
        while (aux != null) {
            aux2 = head;
            while (aux2 != null) {
                if (aux2.getData().compareTo(aux.getData()) > 0) {
                    dato = aux.getData();
                    aux.setData(aux2.getData());
                    aux2.setData(dato);
                }
                aux2 = aux2.getNext();
            }
            aux = aux.getNext();
        }

    }

    public boolean exist(T data) {
        if (!isEmpty()) {
            Nodo<T> aux = head;
            while (aux != null) {
                if (aux.getData().compareTo(data) == 0) {
                    return true;
                }
                aux = aux.getNext();
            }
        }
        return false;
    }

    public String struct() {
        String cadena = "";
        if (!isEmpty()) {
            Nodo<T> aux = head;
            while (aux != null) {
                cadena += aux.getData().toString();
                aux = aux.getNext();
            }
        }
        return cadena;
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
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);
        lista.addLast(7);
        lista.addLast(8);
        lista.add(1, 0);
        lista.add(1, 3);
        lista.showConsole();
    }

}
