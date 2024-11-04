package controller;

import model.Cliente;
import model.Vehiculo;
import model.Reserva;
import model.ArregloReserva;

public class ClienteController {
    private ArregloReserva arregloReserva;

    // Constructor que inicializa el arreglo de reservas
    public ClienteController(ArregloReserva arregloReserva) {
        this.arregloReserva = arregloReserva;
    }

    // Muestra la lista de vehículos disponibles
    public Vehiculo[] verVehiculosDisponibles(Vehiculo[] flota) {
        int disponibles = 0;
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponible()) disponibles++;
        }
        
        Vehiculo[] vehiculosDisponibles = new Vehiculo[disponibles];
        int index = 0;
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponible()) {
                vehiculosDisponibles[index++] = vehiculo;
            }
        }
        return vehiculosDisponibles;
    }

    // Permite al cliente consultar sus reservas activas
    public Reserva[] verReservasCliente(Cliente cliente) {
        Reserva[] reservasCliente = new Reserva[arregloReserva.getCantidadReservas()];
        int index = 0;
        for (int i = 0; i < arregloReserva.getCantidadReservas(); i++) {
            Reserva reserva = arregloReserva.buscarReservaPorIndice(i);
            if (reserva != null && reserva.getCliente().equals(cliente)) {
                reservasCliente[index++] = reserva;
            }
        }
        return reservasCliente;
    }

    // Permite al cliente cancelar una reserva
    public boolean cancelarReservaCliente(Cliente cliente, int indice) {
        Reserva reserva = arregloReserva.buscarReservaPorIndice(indice);
        if (reserva != null && reserva.getCliente().equals(cliente)) {
            return arregloReserva.eliminarReserva(indice);
        }
        System.out.println("No se encontró la reserva o no pertenece al cliente.");
        return false;
    }
}
