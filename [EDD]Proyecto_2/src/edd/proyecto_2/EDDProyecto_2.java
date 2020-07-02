package edd.proyecto_2;

import Entidad.Conductor;
import Entidad.Vehiculo;
import Entidad.Viaje;
import java.math.BigInteger;

import Entidad.Cliente;
import Entidad.Grafica;
import Entidad.Ruta;
import Estructura.ListaSimple.ListaSimple;
import Estructura.TablaHash.TablaHash;
import Modulo.Principal.Principal;

public class EDDProyecto_2 {

    public static void main(String[] args) {

//        Registro.Vehiculo.getRegistro().cargaMasiva("D:\\SevenPok\\Documents\\Usac\\Estructuras de datos\\Proyectos\\Carga Masiva\\arbolb.txt");
//        System.out.println(Registro.Vehiculo.getRegistro().search(new Vehiculo("p14lAf14", "", "", 0, "", "", "")).toString2());
//
        TablaHash tablita = TablaHash.getInstance();
        Registro.Ruta.getRegistro().iniciarApp();
       

    }
}
