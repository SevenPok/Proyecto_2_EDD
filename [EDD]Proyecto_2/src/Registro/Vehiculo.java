package Registro;

import Estructura.Arbol.BTree;
import Estructura.Arbol.Nodo;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

public class Vehiculo {

    private static Vehiculo registro;
    private BTree<Entidad.Vehiculo> vehiculo;

    private Vehiculo() {
        vehiculo = new BTree<>(3);
    }

    public static Vehiculo getRegistro() {
        if (registro == null) {
            registro = new Vehiculo();
        }
        return registro;
    }

    public static void setRegistro(Vehiculo registro) {
        Vehiculo.registro = registro;
    }

    public void add(Entidad.Vehiculo data) {
        vehiculo.insert(data);
    }

    public void remove(Entidad.Vehiculo data) {
        vehiculo.remove(data);
    }

    public Entidad.Vehiculo search(Entidad.Vehiculo data) {
        Entidad.Vehiculo aux = vehiculo.search(data);
        if (aux == null) {
            return null;
        }
        return aux;
    }

    public boolean modify(Entidad.Vehiculo data) {
        Entidad.Vehiculo aux = vehiculo.search(data);
        if (aux != null) {
            aux.setMarca(data.getMarca());
            aux.setModelo(data.getModelo());
            aux.setAnio(data.getAnio());
            aux.setColor(data.getColor());
            aux.setPrecio(data.getPrecio());
            aux.setTipoCaja(data.getTipoCaja());
            return true;
        }
        return false;
    }

    public boolean cargaMasiva(String ruta) {
        try {

            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                String[] cadena = linea.split(";");
                String[] data = cadena[0].split(":");
                try {
                    add(new Entidad.Vehiculo(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], data[5], data[6]));
                } catch (NumberFormatException e) {
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void show(DefaultTableModel modelo) {
        if (vehiculo.getRoot() != null) {
            vehiculo.show(modelo);
        }
    }

    public void graficar() {
        vehiculo.graficar();
    }

    public boolean isEmty() {
        return vehiculo.isEmpty();
    }

    public String cadena() {
        return vehiculo.cadena();
    }
}
