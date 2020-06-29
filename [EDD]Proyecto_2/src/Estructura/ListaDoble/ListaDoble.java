package Estructura.ListaDoble;

public class ListaDoble<T extends Comparable<T>> {

    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public ListaDoble() {
        head = tail = null;
        size = 0;
    }

    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
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

    public void insertFirst(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            nuevo.setNext(head);
            head.setBack(nuevo);
            head = nuevo;
        }
        size++;
    }

    public void insertLast(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.setNext(nuevo);
            nuevo.setBack(tail);
            tail = nuevo;
        }
        size++;
    }

    public void insertIndex(T data, int index) {
        if (isEmpty() || (index < 0 || index >= size)) {
            System.out.println("Esta vacia la lista");
        } else if (index == 0) {
            insertFirst(data);
        } else if (index == size - 1) {
            insertLast(data);
        } else {
            Nodo<T> aux = head;
            Nodo<T> nuevo = new Nodo(data);
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            nuevo.setBack(aux);
            nuevo.setNext(aux.getNext());
            aux.getNext().setBack(nuevo);
            aux.setNext(nuevo);
            size++;
        }
    }

    public void showConsole() {
        if (isEmpty()) {
            System.out.println("Esta vacio");
        } else {
            Nodo<T> aux = head;
            while (aux != null) {
                System.out.println(aux.getData().toString());
                aux = aux.getNext();
            }
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

    public int searchOfIndex(T data) {
        if (!isEmpty()) {
            int contador = 0;
            Nodo<T> aux = head;
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

    public void removeFirst(T data) {
        if (isEmpty()) {
            System.out.println("Esta vacio");
        } else {
            Nodo<T> aux = head.getNext();
            head = null;
            head = aux;
            if (size == 1) {
                tail = null;
            }
            size--;
        }
    }

    public void removeLast(T data) {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            if (head != tail) {
                Nodo<T> aux = head;
                while (aux.getNext() != tail) {
                    aux = aux.getNext();
                }
                tail = aux;
                tail.setNext(null);
            } else {
                head = tail = null;
            }
            size--;
        }
    }

    public T remove(T data) {
        Nodo<T> aux = search(data);
        if (aux != null) {
            if (aux == head) {
                removeFirst(data);
            } else if (aux == tail) {
                removeLast(data);
            } else {
                aux.getBack().setNext(aux.getNext());
                aux.getNext().setBack(aux.getBack());
                size--;
            }
            return aux.getData();
        }
        return null;
    }

    public T removeIndex(int index) {
        Nodo<T> aux = searchIndex(index);
        if (aux != null) {
            if (aux == head) {
                removeFirst(aux.getData());
            } else if (aux == tail) {
                removeLast(aux.getData());
            } else {
                aux.getBack().setNext(aux.getNext());
                aux.getNext().setBack(aux.getBack());
                size--;
            }
            return aux.getData();
        }
        return null;
    }

    public Nodo<T> searchIndex(int index) {
        if (isEmpty() || (index < 0 || index >= size)) {
            return null;
        } else if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return tail;
        } else {
            Nodo<T> aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux;
        }
    }

}
