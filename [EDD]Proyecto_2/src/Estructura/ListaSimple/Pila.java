/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.ListaSimple;

public class Pila<T extends Comparable<T>> extends ListaSimple<T> {

    public Pila() {
        super();
    }

    public void push(T data) {
        super.addLast(data);
    }

    public void pop() {
        super.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty(); //To change body of generated methods, choose Tools | Templates.
    }

    public T top() {
        return super.getHead().getData();
    }

    @Override
    public void showConsole() {
        super.showConsole(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.pop();
        pila.pop();
        pila.pop();
        pila.pop();
        pila.pop();
        pila.pop();
        pila.showConsole();
    }

}
