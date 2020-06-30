package edd.proyecto_2;

import Entidad.Cliente;
import Entidad.Grafica;
import Estructura.TablaHash.TablaHash;
import Modulo.Principal.Principal;


public class EDDProyecto_2 {

    public static void main(String[] args) {
        Principal ventana = new Principal();
        ventana.show(true);
    TablaHash tablita = new TablaHash(37);
    Cliente cli = new Cliente(99993829,"David","Diaz","Masculino","DireccionF");
    tablita.insertar(cli.getDpi(),cli);
    Cliente cli2 = new Cliente(1111111111,"David","Diaz","Masculino","otra");
    tablita.insertar(cli2.getDpi(), cli2);
    Cliente cli3 = new Cliente(1111111110,"Sampe","Diaz","Gay","xd");
    tablita.insertar(cli2.getDpi(), cli3);
    String o= tablita.graficar(tablita);
    Grafica.graficar(o, "ClienteHash");
    }
}
