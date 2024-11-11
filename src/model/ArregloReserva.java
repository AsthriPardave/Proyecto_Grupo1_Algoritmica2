/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ArregloReserva {
    private Reserva[] reservas; // Arreglo fijo de reservas
    private int totalReservas; // Contador para el número de reservas actuales

    public ArregloReserva(int capacidadMaxima) {
        this.reservas = new Reserva[capacidadMaxima];
        this.totalReservas = 0;
    }

    // Método para agregar una reserva
    public void agregarReserva(Reserva reserva) {
        if (totalReservas < reservas.length) {
            reservas[totalReservas] = reserva;
            totalReservas++;
            System.out.println("Reserva agregada con éxito.");
        } else {
            System.out.println("No se pueden agregar más reservas, capacidad máxima alcanzada.");
        }
    }

    // Método para obtener una reserva por índice
    public Reserva obtenerReserva(int indice) {
        if (indice >= 0 && indice < totalReservas) {
            return reservas[indice];
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }

    // Método para listar todas las reservas
    public void listarReservas() {
        for (int i = 0; i < totalReservas; i++) {
            Reserva reserva = reservas[i];
            System.out.println("Reserva del " + reserva.getFechaInicio() + " al " + reserva.getFechaFin() + 
                               " - Total: " + reserva.getMontoTotal());
        }
    }

    // Método para obtener el total de reservas
    public int getTotalReservas() {
        return totalReservas;
    }
}

/*VERSION ORIGINAL:

package model;

public class ArregloReserva {
    private int indice;

    public ArregloReserva(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
*/