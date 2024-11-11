/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Pago {
    private float monto;
    private Date fechaPago;
    private String metodoPago;
    private boolean realizado;

    // Constructor para inicializar los atributos de Pago
    public Pago(float monto, Date fechaPago, String metodoPago) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.realizado = false;  // El pago aún no se ha realizado
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean isRealizado() {
        return realizado;
    }

    // Procesa el pago y actualiza el estado a realizado
    public boolean procesarPago() {
        this.realizado = true;
        return this.realizado;
    }
}