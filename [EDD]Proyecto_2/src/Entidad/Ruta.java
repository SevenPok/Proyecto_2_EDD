package Entidad;

public class Ruta implements Comparable<Ruta> {

    private String lugar;
    private int tiempo;

    public Ruta(String lugar, int tiempo) {
        this.lugar = lugar;
        this.tiempo = tiempo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Ruta o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Lugar: " + lugar + "\\nTiempo: " + tiempo;
    }

}
