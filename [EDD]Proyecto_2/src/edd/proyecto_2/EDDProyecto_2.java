package edd.proyecto_2;

import Entidad.Cliente;
import Entidad.Grafica;
import Estructura.TablaHash.TablaHash;
import Modulo.Principal.Principal;


public class EDDProyecto_2 {

    public static void main(String[] args) {
        TablaHash tablita =  TablaHash.getInstance();
        Principal ventana = new Principal();
        ventana.show(true);
    }
}
