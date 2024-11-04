package controller;

import model.Pago;
import model.Reserva;

public class PagoController {

    // Procesa el pago de una reserva y actualiza su estado
    public boolean procesarPago(Reserva reserva, float monto, String metodoPago) {
        if (reserva != null && !reserva.isConfirmada()) {
            // Crea una nueva instancia de Pago
            Pago pago = new Pago(monto, new java.util.Date(), metodoPago);
            
            // Procesa el pago, si es exitoso confirma la reserva
            if (pago.procesarPago()) {
                reserva.confirmarReserva();
                System.out.println("Pago realizado y reserva confirmada.");
                return true;
            } else {
                System.out.println("Error en el procesamiento del pago.");
            }
        } else {
            System.out.println("La reserva no es válida o ya está confirmada.");
        }
        return false;
    }
}
