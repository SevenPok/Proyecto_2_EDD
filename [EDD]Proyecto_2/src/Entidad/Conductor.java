package Entidad;

public class Conductor implements Comparable<Conductor> {

    private int dpi;
    private String nombre;
    private String apellido;
    private String tipoLicencia;
    private String genero;
    private String fechaNac;
    private String telefono;
    private String direccion;

    public Conductor(int dpi, String nombre, String apellido, String tipoLicencia, String genero, String fechaNac, String telefono, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoLicencia = tipoLicencia;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.direccion = direccion;

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

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "DPI: " + dpi + "\nNombres: " + nombre + "\nApellidos: " + apellido + "\nTipo de licencia: " + tipoLicencia + "\nGenero: " + genero
                + "\nFecha de nacimiento: " + fechaNac + "\nTelefono: " + telefono + "\nDireccion: " + direccion
                + "\n--------------------------------------";
    }

    @Override
    public int compareTo(Conductor o) {
        if (o.getDpi() == this.dpi) {
            return 0;
        } else if (o.getDpi() > this.dpi) {
            return 1;
        } else {
            return -1;
        }
    }

}
