package Estructura.TablaHash;
import Entidad.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TablaHash {
    private int tamanio;
    private int numeroElementos;
    private double factordeCarga;
    private NodoTabla [] Tabla;
    private static TablaHash tablaH;
    
    public static TablaHash getInstance(){
        if(tablaH==null){
            tablaH = new TablaHash(37);
        }
        return tablaH;
    }
    
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
                reHash(tamanio);
            } 
        }else if (existe(iden)) {
            ListaDoble lista = ObtenerCliente(posicionenTabla(iden));
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
    
    public void eliminar(int dpi){
        if (existe(dpi)) {
            ListaDoble listita = ObtenerCliente(posicionenTabla(dpi));
            listita.Borrar(dpi);
            System.out.println("Se elimino");
        }else{
            System.out.println("El usuario no existe");
        }
    }
    private ListaDoble ObtenerCliente(int dpi) {
        for (int i = 0; i < tamanio; i++) {
            if (Tabla[i] != null) {
                if (i== dpi) {
                    return Tabla[i].lista;
                }
            }
        }
        return null;
    }
    
    public Cliente buscarCli(int dpi){
        for (int i = 0; i < tamanio; i++) {
            if (Tabla[i] != null) {   
                if (i == posicionenTabla(dpi)) {
                    ListaN aux = Tabla[i].lista.first;
                    while(aux==null){
                        if(dpi== aux.dato.getDpi()){
                            return aux.dato;
                        }
                        aux=aux.nextt;
                    }
                }
            }
        }
        return null;
    }
    
   public String graficar(TablaHash tabla){
       String codGraph="";
       codGraph+="rankdir = LR; \n node [shape=record];\n";
       codGraph+="hashTable[label="+'"';
       for (int i = 0; i <= tabla.tamanio; i++) {
           codGraph+="<f"+i+">"+i+"|";
       }
       codGraph+='"'+"];\n";
       for (int i = 0; i <tabla.tamanio; i++) {
           NodoTabla ntabla=tabla.Tabla[i];
           if(ntabla!=null){
               codGraph+="node"+i+" [label="+'"';
               ListaN auxiliar = ntabla.lista.first;
               int contador=0;
               while(auxiliar!=null){
                   codGraph+="<f"+contador+"> "+auxiliar.dato.getDpi()+"-"+auxiliar.dato.getNombre()+"|";
                   contador++;
                   auxiliar=auxiliar.nextt;
               }
               codGraph+='"'+"];\n";
           }
       }
       //enlaces
       for (int i = 0; i < tabla.tamanio; i++) {
           NodoTabla lista2=tabla.Tabla[i];
           if (lista2!=null) {
               codGraph+="hashTable:f"+i+" -> node"+i+":f0;\n";
           }
       }
       System.out.println(codGraph);
       return codGraph;
   } 
   
   public boolean CargaMasiva(String ruta){
       try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                String[] cadena = linea.split(";");
                String[] data = cadena[0].split(", ");
                try {
                    insertar(Integer.parseInt(data[0]), new Cliente(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4],data[5],data[6]));
                } catch (NumberFormatException e) {
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
   }
    
}
