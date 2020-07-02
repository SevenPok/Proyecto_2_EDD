package edd.proyecto_2;

<<<<<<< HEAD
import Entidad.Conductor;
import Entidad.Vehiculo;
import Entidad.Viaje;
import java.math.BigInteger;
=======
import Entidad.Cliente;
import Entidad.Grafica;
import Estructura.TablaHash.TablaHash;
import Modulo.Principal.Principal;

>>>>>>> b1c7e65f098e099afc9d3892c5299beef4c1cb79

public class EDDProyecto_2 {

    public static void main(String[] args) {
<<<<<<< HEAD
        Registro.Vehiculo.getRegistro().cargaMasiva("D:\\SevenPok\\Documents\\Usac\\Estructuras de datos\\Proyectos\\Carga Masiva\\arbolb.txt");
        System.out.println(Registro.Vehiculo.getRegistro().search(new Vehiculo("p14lAf14", "", "", 0, "", "", "")).toString2());
        
=======
        TablaHash tablita =  TablaHash.getInstance();
        Principal ventana = new Principal();
        ventana.show(true);
>>>>>>> b1c7e65f098e099afc9d3892c5299beef4c1cb79
    }
}
