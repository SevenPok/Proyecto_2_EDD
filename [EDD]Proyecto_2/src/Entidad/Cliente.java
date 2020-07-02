package Entidad;

import java.math.BigInteger;

public class Cliente implements Comparable<Cliente> {

    private int dpi;
    private String nombre;
    private String apellido;
    private String genero;
    private String nacimiento;
    private String telefono;
    private String direccion;

    public Cliente(int dpi, String nombre, String apellido, String genero, String nacimiento, String telefono, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "DPI: " + dpi + "\nNombres: " + nombre + "\nApellidos: " + apellido + "\nGenero: " + genero + "\nDireccion: " + direccion
                + "\n--------------------------------------";
    }

    public String toString2() {
        return "DPI: " + dpi + "\nNombres: " + nombre + "\nApellidos: " + apellido + "\nGenero: " + genero + "\nDireccion: " + direccion;
    }

    @Override
    public int compareTo(Cliente o) {
        if (this.dpi == o.getDpi()) {
            return 0;
        } else if (this.dpi > o.getDpi()) {
            return 1;
        } else {
            return -1;
        }
    }

}
