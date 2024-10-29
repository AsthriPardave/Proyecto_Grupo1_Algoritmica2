/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private int diasReservados;
    private float montoTotal;
    private Vehiculo vehiculo;  // Referencia al vehículo reservado
    private boolean confirmada;

    public Reserva(Date fechaInicio, Date fechaFin, int diasReservados, Vehiculo vehiculo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasReservados = diasReservados;
        this.vehiculo = vehiculo;
        this.montoTotal = calcularTotal();
        this.confirmada = false;  // La reserva no está confirmada hasta que se realice el pago
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    // Método para calcular el total de la reserva basado en el vehículo y los días
    public float calcularTotal() {
        return vehiculo.calcularCostoReserva(diasReservados);
    }

    // Método para confirmar la reserva
    public void confirmarReserva() {
        this.confirmada = true;
    }
}

/*VERSION ORIGINAL:

package model;

import java.util.Date;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private int diasReservados;
    private float montoTotal;

    public Reserva(Date fechaInicio, Date fechaFin, int diasReservados, float montoTotal) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasReservados = diasReservados;
        this.montoTotal = montoTotal;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }
    
}
*/