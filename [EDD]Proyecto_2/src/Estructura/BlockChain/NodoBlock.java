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
public class NodoBlock {
    private Viaje dato;
    private NodoBlock siguiente;
    private String llave;
    private String previusHash;

    public NodoBlock(Viaje dato) {
        this.dato = dato;
        this.siguiente=null;
        this.llave="";
        this.previusHash="";
    }

    
    public Viaje getViaje(){
        return dato;
    }
    

    public void setDato(Viaje dato) {
        this.dato = dato;
    }

    public NodoBlock getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBlock siguiente) {
        this.siguiente = siguiente;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getPreviusHash() {
        return previusHash;
    }

    public void setPreviusHash(String previusHash) {
        this.previusHash = previusHash;
    }

}
