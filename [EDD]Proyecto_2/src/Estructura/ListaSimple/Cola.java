package Estructura.ListaSimple;

public class Cola<T extends Comparable<T>> extends ListaSimple<T> {

    public Cola() {
        super();
    }

    public void enqueue(T data) {
        super.addLast(data);
    }

    public void dequeue() {
        super.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public T top() {
        return super.getHead().getData();
    }
}
