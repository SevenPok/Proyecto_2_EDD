/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.BlockChain;

import Entidad.Viaje;
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
    
    public static ListaSimpleB getInstance(){
        if (blockchain==null) {
            blockchain = new ListaSimpleB();
        }
        return blockchain;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public void ListaSimpleB(){
        inicio=null;
        tamaniol=0;
    }
    public void agregarAlFinal(Viaje viaje,String llaves){
        // Define un nuevo nodo.
        NodoBlock nuevo = new NodoBlock(viaje);
        // Agrega al valor al nodo.
        nuevo.setDato(viaje);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            inicio = nuevo;
            inicio.setLlave(getMD5(llaves));
        } else{
            // Crea ua copia de la lista.
            NodoBlock aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null){
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
    
     public String grafica(ListaSimpleB lista){
        String graphG="";
        graphG+="node[shape=record];\n" +
        "graph[pencolor=transparent];\n";
        graphG+="rankdir=LR;\n";
        NodoBlock aux = lista.inicio;
        System.out.println(aux.getLlave());
        do{
            graphG+="A"+aux.getLlave()+"[label="+'"'+"{<data> "+aux.getLlave()+"| <next>"+ "}"+'"'+"];\n";
            aux=aux.getSiguiente();
        }while(aux!=null);
        //enlaces
        NodoBlock aux2=lista.inicio;
        do{
            if(aux2.getSiguiente()!=null){
            graphG+="A"+aux2.getLlave()+":next:c -> A"+aux2.getSiguiente().getLlave()+":data;\n";
            }
            aux2=aux2.getSiguiente();
        }while(aux2!=null);
        return graphG;
    }
     
     public Viaje buscarViaje(String llave){
         
         if(inicio!=null){
             NodoBlock aux = inicio;
             do {
                 if (aux.getLlave()==llave) {
                     return aux.getViaje();
                 }
                 aux=aux.getSiguiente();
             } while (aux!=null);
         }
        return null;
     }
}
