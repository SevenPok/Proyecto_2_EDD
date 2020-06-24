package Registro;

import Estructura.ListaDoble.ListaDobleCircular;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Conductor {

    private static Conductor registro;
    private ListaDobleCircular<Entidad.Conductor> conductor;

    private Conductor() {
        conductor = new ListaDobleCircular<>();
    }

    public static Conductor getRegistro() {
        if (registro == null) {
            registro = new Conductor();
        }
        return registro;
    }

    public static void setRegistro(Conductor registro) {
        Conductor.registro = registro;
    }

    public void add(Entidad.Conductor data) {
        conductor.addLast(data);
    }

    public boolean remove(Entidad.Conductor data) {
        return conductor.remove(data);
    }

    public Entidad.Conductor search(Entidad.Conductor data) {
        Estructura.ListaDoble.Nodo<Entidad.Conductor> aux = conductor.search(data);
        if (aux == null) {
            return null;
        }
        return aux.getData();
    }

    public boolean modify(Entidad.Conductor data) {
        Entidad.Conductor aux = search(data);
        if (aux == null) {
            return false;
        } else {
            aux.setNombre(data.getNombre());
            aux.setApellido(data.getApellido());
            aux.setGenero(data.getGenero());
            aux.setDireccion(data.getDireccion());
            aux.setTipoLicencia(data.getTipoLicencia());
            return true;
        }
    }

    public boolean cargaMasiva(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                String[] cadena = linea.split(";");
                String[] data = cadena[0].split("%");
                try {
                    add(new Entidad.Conductor(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
                } catch (NumberFormatException e) {
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void show() {
        conductor.showConsole();
    }
}
