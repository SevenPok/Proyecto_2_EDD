
package Estructura.TablaHash;
import Entidad.Cliente;


public class TablaHash {
    private int tamanio;
    private int numeroElementos;
    private double factordeCarga;
    NodoTabla [] Tabla;
    
    
    public TablaHash(int tamanio) {
        this.tamanio = tamanio;
        Tabla=new NodoTabla[tamanio];
        for (int i = 0; i < tamanio; i++) {
            Tabla[i]=null;
        }
        factordeCarga=0;
        numeroElementos=0;
    }
    
    public int posicionenTabla(int dpi){
        int indice=dpi%tamanio;
        return indice;
    }
    public boolean existe(int id){
        int posicion = posicionenTabla(id);
        NodoTabla actual=Tabla[posicion];
        if (actual!=null) {
            if (actual.eliminado) {
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    
    public void insertar(int iden, Cliente cli){
        if (!existe(iden)) {
            NodoTabla nuevo = new NodoTabla(iden,cli);
            int posicion = posicionenTabla(iden);
            Tabla[posicion]=nuevo;
            Tabla[posicion].eliminado=false;
            numeroElementos++;
            factordeCarga=numeroElementos/tamanio; //actualiza la densidad en la tablahash
            if (factordeCarga>=0.75) {//verifica que no se ocupe el 75% de la tabla
                //funcion del rehashing;
            } 
        }else if (existe(iden)) {
            ListaDoble lista = getCliente(iden);
            if (lista.existe(cli.getDpi())==false) {
                lista.Insertar(cli);
            }else{
                System.out.println("El Cliente ya existe");
            }
        }
    }
    
    private void reHash(int tama){
        tama=tama+37;
        TablaHash Tablaaux = new TablaHash(tama);
        for (int i = 0; i < tamanio; i++) {
            ListaDoble aux=Tabla[i].lista;
            ListaN temp = aux.first;
            while(temp!=null){
                Tablaaux.insertar(Tabla[i].ident, temp.dato);
                temp=temp.nextt;
            }
        }
        tamanio=tama;
        numeroElementos=Tablaaux.numeroElementos;
        factordeCarga=Tablaaux.factordeCarga;
        //borrar tabla
        Tabla=Tablaaux.Tabla;
        
        
    }
    
    
    private ListaDoble getCliente(int dpi) {
        for (int i = 0; i < tamanio; i++) {
            if (Tabla[i] != null) {
                if (Tabla[i].ident == dpi) {
                    return Tabla[i].lista;
                }
            }
        }
        return null;
    }
    
    
    
}
