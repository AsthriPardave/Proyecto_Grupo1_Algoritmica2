/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Calendar;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private int diasReservados;
    private float montoTotal;
    private Vehiculo vehiculo; // Vehículo asociado a la reserva
    private Pago pago; // Pago asociado a la reserva

    public Reserva(Date fechaInicio, int diasReservados, Vehiculo vehiculo) {
        this.fechaInicio = fechaInicio;
        this.diasReservados = diasReservados;
        this.vehiculo = vehiculo;
        this.montoTotal = 0.0f;
        calcularFechaFin(); // Calcula fechaFin al crear la reserva
    }

    // Getters y Setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        calcularFechaFin(); // Actualiza fechaFin si se cambia fechaInicio
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
        calcularFechaFin(); // Actualiza fechaFin si se cambia diasReservados
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    // Método para calcular el total de la reserva basado en el vehículo y los días
    public float calcularTotal(Vehiculo vehiculo, int dias) {
        float precioPorDia = vehiculo.getPrecioPorDia();
        this.montoTotal = precioPorDia * dias;
        return montoTotal;
    }

    // Método para confirmar la reserva, procesar el pago y mostrar la información
    public boolean confirmarReserva() {
        System.out.println("Reserva confirmada del " + fechaInicio + " al " + fechaFin);
        System.out.println("Días reservados: " + diasReservados + ", Monto total: " + montoTotal + " soles.");
        
        if (pago != null && pago.getMonto() == montoTotal) {
            return pago.procesarPago();
        } else {
            System.out.println("No se puede procesar el pago. Monto incorrecto o método de pago no establecido.");
            return false;
        }
    }

    // Método privado para calcular la fecha de fin de la reserva
    private void calcularFechaFin() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaInicio);
        calendario.add(Calendar.DAY_OF_YEAR, diasReservados);
        this.fechaFin = calendario.getTime();
    }

    @Override
    public String toString() {
        return "Reserva [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin +
               ", diasReservados=" + diasReservados + ", montoTotal=" + montoTotal +
               ", vehiculo=" + vehiculo + ", pago=" + (pago != null ? pago.toString() : "No pagado") + "]";
    }
}
