/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafica {

    public static String cadena = "";

    public static void graficar(String cadena, String nombre) {
        String archivo = nombre + ".dot";
        try {
            FileWriter fichero = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fichero);
            pw.println("digraph G {\n");
            pw.println(cadena);
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot.exe -Tpng " + nombre + ".dot -o " + nombre + ".png";
            Runtime.getRuntime().exec(cmd);
            File path = new File(nombre + ".png");
            Desktop.getDesktop().open(path);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
