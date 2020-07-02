/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.BlockChain;

import Entidad.Cliente;
import Entidad.Conductor;
import Entidad.Vehiculo;
import Entidad.Viaje;
import Estructura.ListaSimple.ListaSimple;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Co
 */
public class ListaSimpleB {

    private NodoBlock inicio;
    private int tamaniol;
    private static ListaSimpleB blockchain;

    public static ListaSimpleB getInstance() {
        if (blockchain == null) {
            blockchain = new ListaSimpleB();
        }
        return blockchain;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void ListaSimpleB() {
        inicio = null;
        tamaniol = 0;
    }

    public void agregarAlFinal(Viaje viaje, String llaves) {
        // Define un nuevo nodo.
        NodoBlock nuevo = new NodoBlock(viaje);
        // Agrega al valor al nodo.
        nuevo.setDato(viaje);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            inicio = nuevo;
            inicio.setLlave(getMD5(llaves));
        } else {
            // Crea ua copia de la lista.
            NodoBlock aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
            nuevo.setPreviusHash(aux.getLlave());
            nuevo.setLlave(getMD5(llaves));
        }
        // Incrementa el contador de tamaño de la lista
        tamaniol++;
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String topViaje() {
        String cadena = "";
        if (!esVacia()) {
            NodoBlock aux = inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
            }
        }
        return cadena;
    }

    public String topVehiculo() {
        String cadena = "";
        if (!esVacia()) {
            ListaSimple<TopVehiculo> top = new ListaSimple<>();
            NodoBlock aux = inicio;
            while (aux != null) {
                TopVehiculo nuevo = new TopVehiculo(aux.getViaje().getVehiculo(), vehiculo(aux.getViaje().getVehiculo().getPlaca()));
                if (!top.exist(nuevo)) {
                    top.addLast(nuevo);
                }
                aux = aux.getSiguiente();
            }
            top.sort();
            cadena = top.struct();
        }
        return cadena;
    }

    public String topCliente() {
        String cadena = "";
        if (!esVacia()) {
            ListaSimple<TopCliente> top = new ListaSimple<>();
            NodoBlock aux = inicio;
            while (aux != null) {
                TopCliente nuevo = new TopCliente(aux.getViaje().getCliente(), cliente(aux.getViaje().getCliente().getDpi()));
                if (!top.exist(nuevo)) {
                    top.addLast(nuevo);
                }
                aux = aux.getSiguiente();
            }
            top.sort();
            cadena = top.struct();
        }
        return cadena;
    }

    public String topConductor() {
        String cadena = "";
        if (!esVacia()) {
            ListaSimple<TopConductor> top = new ListaSimple<>();
            NodoBlock aux = inicio;
            while (aux != null) {
                TopConductor nuevo = new TopConductor(aux.getViaje().getConductor(), conductor(aux.getViaje().getConductor().getDpi()));
                if (!top.exist(nuevo)) {
                    top.addLast(nuevo);
                }
                aux = aux.getSiguiente();
            }
            top.sort();
            cadena = top.struct();
        }
        return cadena;
    }

    private int vehiculo(String placa) {
        int i = 0;
        if (!esVacia()) {
            NodoBlock aux = inicio;
            while (aux != null) {
                if (aux.getViaje().getVehiculo().getPlaca().equals(placa)) {
                    i++;
                }
                aux = aux.getSiguiente();
            }
        }
        return i;
    }

    private int cliente(int dpi) {
        int i = 0;
        if (!esVacia()) {
            NodoBlock aux = inicio;
            while (aux != null) {
                if (aux.getViaje().getCliente().getDpi() == dpi) {
                    i++;
                }
                aux = aux.getSiguiente();
            }
        }
        return i;
    }

    private int conductor(String dpi) {
        int i = 0;
        if (!esVacia()) {
            NodoBlock aux = inicio;
            while (aux != null) {
                if (aux.getViaje().getConductor().getDpi().equals(dpi)) {
                    i++;
                }
                aux = aux.getSiguiente();
            }
        }
        return i;
    }

    private class TopVehiculo implements Comparable<TopVehiculo> {

        public Vehiculo vehiculo;
        public int cantidad;

        public TopVehiculo(Vehiculo vehiculo, int cantidad) {
            this.vehiculo = vehiculo;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return vehiculo.toString2() + "\nCantidad: " + cantidad + "\n--------------------------------------\n";
        }

        @Override
        public int compareTo(TopVehiculo o) {
            if (this.cantidad == o.cantidad && this.vehiculo.getPlaca().equals(o.vehiculo.getPlaca())) {
                return 0;
            } else if (this.cantidad > o.cantidad) {
                return 1;
            }
            return -1;
        }
    }

    private class TopCliente implements Comparable<TopCliente> {

        public Cliente cliente;
        public int cantidad;

        public TopCliente(Cliente cliente, int cantidad) {
            this.cliente = cliente;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return cliente.toString2() + "\nCantidad: " + cantidad + "\n--------------------------------------\n";
        }

        @Override
        public int compareTo(TopCliente o) {
            if (this.cantidad == o.cantidad && cliente.getDpi() == o.cliente.getDpi()) {
                return 0;
            } else if (this.cantidad > o.cantidad) {
                return 1;
            }
            return -1;
        }
    }

    private class TopConductor implements Comparable<TopConductor> {

        public Conductor conductor;
        public int cantidad;

        public TopConductor(Conductor conductor, int cantidad) {
            this.conductor = conductor;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return conductor.toString2() + "\nCantidad: " + cantidad + "\n--------------------------------------\n";
        }

        @Override
        public int compareTo(TopConductor o) {
            if (this.cantidad == o.cantidad && conductor.getDpi().equals(o.conductor.getDpi())) {
                return 0;
            } else if (this.cantidad > o.cantidad) {
                return 1;
            }
            return -1;
        }
    }
}
