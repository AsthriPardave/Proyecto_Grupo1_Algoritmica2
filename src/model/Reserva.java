package model;

import java.time.LocalDate;

public class Reserva {
    private String id;
    private LocalDate fecha;
    private LocalDate fechaFin;
    private int diasReservados;
    private double montoTotal;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Reserva(String id, int diasReservados, Vehiculo vehiculo, Cliente cliente) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.diasReservados = diasReservados;
        this.vehiculo = vehiculo;
        this.cliente = cliente;

        this.id = "R-" + vehiculo.getMatricula().hashCode();

        calcular(); 
    }

    // Método público para calcular los montos y la fecha de fin
    public void calcular() {
        double precioPorDia = vehiculo.getPrecioPorDia();
        this.montoTotal = precioPorDia * diasReservados;

        // Calcula la fecha de fin sumando los días reservados a la fecha de inicio
        this.fechaFin = fecha.plusDays(diasReservados);
    }

    // Métodos Getters y Setters
    public String getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    @Override
    public String toString() {
        return "Reserva {" +
               "id='" + id + '\'' +
               ", fechaInicio=" + fecha +
               ", fechaFin=" + fechaFin +
               ", diasReservados=" + diasReservados +
               ", vehiculo=" + (vehiculo != null ? vehiculo.getMatricula() : "N/A") +
               ", cliente=" + (cliente != null ? cliente.getDni() : "N/A") +
               ", montoTotal=" + montoTotal +
               '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
