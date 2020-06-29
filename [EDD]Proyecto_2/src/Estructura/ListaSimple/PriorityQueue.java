package Estructura.ListaSimple;

public class PriorityQueue<T extends Comparable<T>> extends ListaSimple<T> {

    public PriorityQueue() {
        super();
    }

    public void enqueue(T data) {
        int index = 0;
        if (isEmpty()) {
            super.addLast(data);
        } else if (index < super.getSize()) {
            Nodo<T> aux = getHead();
            while (aux != null) {
                if (data.compareTo(aux.getData()) < 0) {
                    break;
                }
                index++;
                aux = aux.getNext();
            }
            super.add(data, index);
        } else {
            super.addLast(data);
        }
    }

    public T dequeue() {
        return super.removeFirst();
    }

    public T peek() {
        if (super.getHead() != null) {
            return super.getHead().getData();
        }
        return null;
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void showConsole() {
        super.showConsole();
    }

}
