package edd.proyecto_2;

import Entidad.Vehiculo;
import Registro.Conductor;
import Registro.Ruta;

public class EDDProyecto_2 {

    public static void main(String[] args) {
        Registro.Ruta.getRegistro().cargaMasiva("D:\\SevenPok\\Documents\\Usac\\Estructuras de datos\\Proyectos\\Carga Masiva\\Rutas.txt");
        Registro.Ruta.getRegistro().grafoRutas("Rutas");
        Registro.Ruta.getRegistro().recorridoAnchura("Bilbao");

        Registro.Ruta.getRegistro().recorridoProfundidad("Bilbao");
    }

}
