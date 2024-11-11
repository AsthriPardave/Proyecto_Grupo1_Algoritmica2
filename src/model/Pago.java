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

    public Pago(float monto, Date fechaPago, String metodoPago) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
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

    // Método para procesar el pago
    public boolean procesarPago() {
        // Implementación de lógica para procesar el pago
        // Aquí podrías incluir la lógica para validar el método de pago o verificar fondos

        System.out.println("Procesando el pago de " + monto + " usando " + metodoPago);
        
        // Supongamos que el pago se procesa correctamente en este ejemplo
        boolean pagoExitoso = true;

        if (pagoExitoso) {
            System.out.println("Pago procesado con éxito el " + fechaPago);
            return true;
        } else {
            System.out.println("Error al procesar el pago.");
            return false;
        }
    }
}
/* VERSION ORIGINAL:

package model;

import java.util.Date;

public class Pago {
    float monto;
    Date fechaPago;
    String MetodoPago;
}
*/