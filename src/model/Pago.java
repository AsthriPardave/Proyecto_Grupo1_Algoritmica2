package model;

import java.util.Date;

public class Pago {
    private String idReserva;
    private float monto;
    private Date fechaPago;
    private String metodoPago;

    public Pago(String idReserva, float monto, Date fechaPago, String metodoPago) {
        this.idReserva = idReserva;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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

    @Override
    public String toString() {
        return "Pago [idReserva=" + idReserva + ", monto=" + monto + ", fechaPago=" + fechaPago + ", metodoPago=" + metodoPago + "]";
    }
}
