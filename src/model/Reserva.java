package model;

import java.time.LocalDate;

public class Reserva {
    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private int diasReservados;
    private Vehiculo vehiculo; // Vehículo asociado a la reserva

    private double garantia;   // Pago inicial asociado a la reserva
    private double montoTotal; // Monto total de la reserva
    private double impuesto;   // Impuesto asociado a la reserva
    private double montoActual; // Monto pagado hasta el momento

    private boolean cancelado; // Estado de la reserva (cancelado o no)

    // Constructor actualizado
    public Reserva(int diasReservados, Vehiculo vehiculo) {
        this.fechaInicio = LocalDate.now(); // Fecha de inicio como la fecha actual
        this.diasReservados = diasReservados;
        this.vehiculo = vehiculo;
        this.montoActual = 0.0; // Inicializa el monto actual en 0
        this.cancelado = false;

        // Generar un ID único basado en la matrícula del vehículo
        this.id = "R-" + vehiculo.getMatricula().hashCode();

        calcular(); // Calcula los montos y la fecha de fin
    }

    // Método para calcular los montos y la fecha de fin
    private void calcular() {
        double precioPorDia = vehiculo.getPrecioPorDia();
        this.montoTotal = precioPorDia * diasReservados;

        // Calcula la garantía y el impuesto
        this.garantia = montoTotal * 0.10; // 10% del monto total como garantía
        this.impuesto = montoTotal * 0.05; // 5% del monto total como impuesto

        // Calcula la fecha de fin sumando los días reservados a la fecha de inicio
        this.fechaFin = fechaInicio.plusDays(diasReservados);
    }

    // Métodos Getters y Setters, incluido cancelado
    public String getId() {
        return id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getGarantia() {
        return garantia;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public boolean getCancelado() { // Getter de cancelado
        return cancelado;
    }

    public void setCancelado(boolean cancelado) { // Setter de cancelado
        this.cancelado = cancelado;
    }

    @Override
    public String toString() {
        return "Reserva {" +
               "id='" + id + '\'' +
               ", fechaInicio=" + fechaInicio +
               ", fechaFin=" + fechaFin +
               ", diasReservados=" + diasReservados +
               ", vehiculo=" + (vehiculo != null ? vehiculo.getModelo() : "N/A") +
               ", garantia=" + garantia +
               ", montoTotal=" + montoTotal +
               ", impuesto=" + impuesto +
               ", montoActual=" + montoActual +
               ", cancelado=" + cancelado +
               '}';
    }
}
