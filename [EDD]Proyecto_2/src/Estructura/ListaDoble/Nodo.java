package Estructura.ListaDoble;

public class Nodo<T extends Comparable<T>> {

    private T data;
    private Nodo<T> next;
    private Nodo<T> back;

    public Nodo(T data, Nodo<T> next, Nodo<T> back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public Nodo(T data) {
        this(data, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getBack() {
        return back;
    }

    public void setBack(Nodo<T> back) {
        this.back = back;
    }

}
