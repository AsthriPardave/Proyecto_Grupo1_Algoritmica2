package controller;

import model.Reserva;
import model.Cliente;
import model.Vehiculo;
import model.ArregloReserva;
import java.util.Date;
import java.util.Calendar;

public class ReservaController {
    private ArregloReserva arregloReserva;

    // Constructor para inicializar el arreglo de reservas
    public ReservaController(ArregloReserva arregloReserva) {
        this.arregloReserva = arregloReserva;
    }

    // Crea una nueva reserva si el vehículo está disponible
public Reserva crearReserva(Cliente cliente, Vehiculo vehiculo, int dias) {
    if (vehiculo.verificarDisponibilidad()) {
        Date fechaInicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        Date fechaFin = calendar.getTime();

        // Ahora pasamos el cliente como último argumento al constructor de Reserva
        Reserva reserva = new Reserva(fechaInicio, fechaFin, dias, vehiculo, cliente);
        arregloReserva.agregarReserva(reserva);  // Agrega la reserva al arreglo
        return reserva;  // Devuelve la reserva para procesamiento de pago
    } else {
        System.out.println("El vehículo no está disponible.");
        return null;
    }
}


    // Busca una reserva por su índice en el arreglo de reservas
    public Reserva obtenerReservaPorIndice(int indice) {
        return arregloReserva.buscarReservaPorIndice(indice);
    }

    // Elimina una reserva existente por su índice
    public boolean cancelarReserva(int indice) {
        return arregloReserva.eliminarReserva(indice);
    }

    // Confirma la reserva una vez que el pago ha sido realizado
    public void confirmarReserva(Reserva reserva) {
        if (reserva != null) {
            reserva.confirmarReserva();
            System.out.println("Reserva confirmada.");
        }
    }
}
