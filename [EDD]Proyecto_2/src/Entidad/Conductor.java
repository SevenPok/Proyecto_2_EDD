package Entidad;

public class Conductor implements Comparable<Conductor> {

    private String dpi;
    private String nombre;
    private String apellido;
    private String genero;
    private String direccion;
    private String tipoLicencia;

    public Conductor(String dpi, String nombre, String apellido, String genero, String direccion, String tipoLicencia) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.direccion = direccion;
        this.tipoLicencia = tipoLicencia;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
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

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public String toString() {
        return "DPI: " + dpi + "\nNombres: " + nombre + "\nApellidos: " + apellido + "\nTipo de licencia: " + tipoLicencia + "\nGenero: " + genero + "\nDireccion: " + direccion
                + "\n--------------------------------------";
    }

    @Override
    public int compareTo(Conductor o) {
        if (o.getDpi().compareToIgnoreCase(this.dpi) == 0) {
            return 0;
        } else if (o.getDpi().compareToIgnoreCase(this.dpi) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
