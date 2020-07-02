package Registro;

import Entidad.Grafica;
import Entidad.Viaje;
import Estructura.Grafo.Grafo;
import Estructura.Grafo.Vertice;
import Estructura.ListaSimple.ListaSimple;
import Estructura.ListaSimple.Nodo;
import Modulo.Principal.Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ruta {

    private static Ruta registro;
    private Grafo ruta;

    private Ruta() {
        ruta = new Grafo();
    }

    public static Ruta getRegistro() {
        if (registro == null) {
            registro = new Ruta();
        }
        return registro;
    }

    public static void setRegistro(Ruta registro) {
        Ruta.registro = registro;
    }

    public boolean cargaMasiva(String ruta) {
        try {

            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                String[] cadena = linea.split("%");
                String[] data = cadena[0].split("/");
                try {
                    data[0] = data[0].trim();
                    data[1] = data[1].trim();
                    data[2] = data[2].trim();
                    if (this.ruta.getVertice(data[0]) == null) {
                        this.ruta.insertVertice(data[0]);
                    }
                    if (this.ruta.getVertice(data[1]) == null) {
                        this.ruta.insertVertice(data[1]);
                    }
                    this.ruta.insertArista(this.ruta.getVertice(data[0]), this.ruta.getVertice(data[1]), Integer.parseInt(data[2]));
                } catch (NumberFormatException e) {
                }
            }
            //this.ruta.show();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void listaAdyacente(String nombre) {
        Grafica.graficar(this.ruta.listaAdyacencia(), nombre);
    }

    public void grafoRutas() {
        Grafica.graficar(this.ruta.graficaRutas(), "Rutas");
    }

    public void recorridoAnchura(String vertice) {
        this.ruta.recorridoAnchura(this.ruta.getVertice(vertice));
        System.out.println("");
    }

    public void recorridoProfundidad(String vertice) {
        this.ruta.recorridoProfundidad(this.ruta.getVertice(vertice));
        System.out.println("");
    }

    public void rutaMasCorta(String origen, String destino, Viaje viaje) {
        this.ruta.rutaMasCorta(ruta.getVertice(origen), ruta.getVertice(destino), viaje);
    }

    public void iniciarApp() {
        JFileChooser fc = new JFileChooser();
        int selection = fc.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            if (cargaMasiva(ruta)) {
                JOptionPane.showMessageDialog(null, "Se completo la carga existosamente");

                Principal ventana = new Principal();
                ventana.show(true);
                grafoRutas();
            } else {
                JOptionPane.showMessageDialog(null, "Error en la carga");
            }
        }

    }
}
