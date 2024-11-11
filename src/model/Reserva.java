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

    public Reserva(Date fechaInicio, Date fechaFin, int diasReservados, float montoTotal) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasReservados = diasReservados;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
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

    // Método para calcular el total de la reserva
    public float calcularTotal(Vehiculo vehiculo, int dias) {
        float precioPorDia = vehiculo.getPrecioPorDia(); // Supongamos que Vehiculo tiene este método
        montoTotal = precioPorDia * dias;
        return montoTotal;
    }

    // Método para confirmar la reserva
    public void confirmarReserva() {
        System.out.println("Reserva confirmada del " + fechaInicio + " al " + fechaFin);
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