package Entidad;

public class Vehiculo implements Comparable<Vehiculo> {

    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private String precio;
    private String tipoCaja;

    public Vehiculo(String placa, String marca, String modelo, int anio, String color, String precio, String tipoCaja) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
        this.tipoCaja = tipoCaja;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAño: " + anio + "\nColor: " + color + "\nPrecio: Q " + precio + "\nTipo de caja: " + tipoCaja
                + "\n--------------------------------------";
    }

    @Override
    public int compareTo(Vehiculo o) {
        if (o.getPlaca().compareToIgnoreCase(this.placa) == 0) {
            return 0;
        } else if (o.getPlaca().compareToIgnoreCase(this.placa) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
