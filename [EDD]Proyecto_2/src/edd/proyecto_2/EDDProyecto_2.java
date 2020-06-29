package edd.proyecto_2;

import Entidad.Cliente;
import Entidad.Grafica;
import Estructura.TablaHash.TablaHash;


public class EDDProyecto_2 {

    public static void main(String[] args) {
        TablaHash tablita = new TablaHash(37);
    Cliente cli = new Cliente(99993829,"David","Diaz","Masculino","DireccionF");
    tablita.insertar(cli.getDpi(),cli);
    Cliente cli2 = new Cliente(1111111111,"David","Diaz","Masculino","otra");
    tablita.insertar(cli2.getDpi(), cli2);
    String o= tablita.graficar(tablita);
    Grafica.graficar(o, "ClienteHash");
    }
}
