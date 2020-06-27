/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura.TablaHash;
import Entidad.Cliente;

/**
 *
 * @author Co
 */
public class ListaDoble {
    ListaN first,lastt;
    int tam;

    public ListaDoble() {
        this.tam=0;
        this.first=this.lastt=null;
    }
    public void Insertar(Cliente cli){
        ListaN nuevo = new ListaN(cli);
        if (first==null) {
            first=nuevo;
            lastt=nuevo;
            tam++;
        }else{
            if (existe(cli.getDpi())==false) {
                lastt.nextt=nuevo;
                nuevo.previous=lastt;
                lastt=nuevo;
                tam++;
                return;
            }else{
                System.out.println("El Cliente ya existe");
                return;
            }
        }
    }
    
    public void Borrar(int dpi){
        ListaN temp = first;
        while (temp != null) {
            if (temp.getDato().getDpi()== dpi) {
                if (temp == first) {
                    first = temp.nextt;
                    tam--;
                    return;
                } else {
                    if (temp.nextt == null) {
                        temp.previous.nextt = null;
                        temp = null;
                    } else {
                        temp.previous.nextt = temp.nextt;
                        temp = null;
                    }
                    tam--;
                    return;
                }
            } else {
                temp = temp.nextt;
            }
        }
    }
    
    boolean existe(int dpi){
        ListaN temp = first;
        while (temp!=null) {            
            if (temp.getDato().getDpi()==dpi) {
                return true;
            }
            temp= temp.nextt;
        }
        return false;
    }
    
    public boolean getCliente(int dpi) {
        ListaN temp = first;
        while (temp != null) {
            if (temp.getDato().getDpi() == dpi) {
                return true;
            } else {
                temp = temp.nextt;
            }
        }
        return false;
    }
    
}
