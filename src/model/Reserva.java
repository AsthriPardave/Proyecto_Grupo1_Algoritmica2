/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    public String id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private int diasReservados;

    private Trabajadores trabajador;
    private Vehiculo vehiculo; // Vehículo asociado a la reserva

    private double garantia; // Pago asociado a la reserva
    private double montoTotal;
    private double impuesto;
    private double montoActual;

    private boolean cancelado;


    public Reserva(int diasReservados,
            Trabajadores trabajador, Vehiculo vehiculo) {

        fechaInicio = LocalDate.now();
        montoActual = 0.0;
        this.diasReservados = diasReservados;
        this.trabajador = trabajador;
        this.vehiculo = vehiculo;
        id = Integer.toString(Math.abs(trabajador.getDni().hashCode()));

        cancelado = false;
        calcular(); // Calcula fechaFin al crear la reserva
        
    }

    private void calcular() {

      double precioPorDia = vehiculo.getPrecioPorDia();
      montoTotal = precioPorDia * diasReservados;

      garantia = montoTotal * 0.10;
      impuesto = montoTotal * 0.05;

      fechaFin = fechaInicio.plusDays(diasReservados);
    }
    public String getId() {
      return id;
    }
    public double getMontoActual () {
      return montoActual;
    }
    public void setMontoActual ( double monto) {
        montoActual = monto;
    }
    public boolean getCancelado() {
      return cancelado;
    }
    public void setCancelado ( boolean t ) {
      cancelado = t;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getDiasReservados() {
        return diasReservados;
    }
    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }
    public Trabajadores getTrabajador() {
        return trabajador;
    }
    public void setTrabajador(Trabajadores trabajador) {
        this.trabajador = trabajador;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public double getGarantia() {
        return garantia;
    }
    public void setGarantia(double garantia) {
        this.garantia = garantia;
    }
    public double getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    public double getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    @Override
    public String toString() {
        return "Reserva {" +
              "id=" + id +
              ", fechaInicio=" + fechaInicio +
              ", fechaFin=" + fechaFin +
              ", diasReservados=" + diasReservados +
              ", cliente=" + (trabajador != null ? trabajador.getNombre() : "N/A") +
              ", vehiculo=" + (vehiculo != null ? vehiculo.getModelo() : "N/A") +
              ", garantia=" + garantia +
              ", montoTotal=" + montoTotal +
              ", impuesto=" + impuesto +
              ", montoActual=" + montoActual +
              ", cancelado=" + cancelado +
              '}';
    }
}
