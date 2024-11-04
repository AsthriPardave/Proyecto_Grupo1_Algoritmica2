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
    private Vehiculo vehiculo;
    private Cliente cliente;  // Nuevo atributo cliente
    private boolean confirmada;

    // Constructor para inicializar los atributos de Reserva
    public Reserva(Date fechaInicio, Date fechaFin, int diasReservados, Vehiculo vehiculo, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasReservados = diasReservados;
        this.vehiculo = vehiculo;
        this.cliente = cliente;  // Asignación del cliente
        this.montoTotal = calcularTotal();
        this.confirmada = false;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {  // Nuevo método getter para cliente
        return cliente;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    // Calcula el monto total de la reserva en función de los días
    public float calcularTotal() {
        return vehiculo.calcularCostoReserva(diasReservados);
    }

    // Confirma la reserva después del pago
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