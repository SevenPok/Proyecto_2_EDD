package Entidad;

import Estructura.Grafo.Vertice;

public class Viaje {

    private String origen;
    private String destino;
    private String fecha_hora;
    private Cliente cliente;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private String ruta;

    public Viaje(String origen, String destino, String fecha_hora, Cliente cliente, Conductor conductor, Vehiculo vehiculo, String ruta) {
        this.origen = origen;
        this.destino = destino;
        this.fecha_hora = fecha_hora;
        this.cliente = cliente;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.ruta = ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
