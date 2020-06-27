package edd.proyecto_2;

import Entidad.Vehiculo;
import Estructura.BTree.BTree;
import Registro.Conductor;
import Registro.Ruta;
import java.io.IOException;

public class EDDProyecto_2 {

    public static void main(String[] args) throws IOException {
        Registro.Vehiculo.getRegistro().cargaMasiva("D:\\SevenPok\\Documents\\Usac\\Estructuras de datos\\Proyectos\\Carga Masiva\\arbolb.txt");
        Registro.Vehiculo.getRegistro().add(new Vehiculo("asdppasda1", "", "", 0, "", "", ""));
        Registro.Vehiculo.getRegistro().graficar();
    }
}
