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
    public boolean agregar(Reserva reserva) {
        if (totalReservas < reservas.length) {
            reservas[totalReservas] = reserva;
            totalReservas++;
            System.out.println("Reserva agregada con éxito.");
            return true;
        } else {
            System.out.println("No se pueden agregar más reservas, capacidad máxima alcanzada.");
            return false;
        }
    }

    // Método para buscar una reserva por la matrícula del vehículo
    public Reserva buscar(String matricula) {
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i] != null && reservas[i].getVehiculo().getMatricula().equals(matricula)) {
                return reservas[i];
            }
        }
        System.out.println("Reserva no encontrada para la matrícula: " + matricula);
        return null;
    }

    // Método para obtener una reserva por índice (opcional)
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
            System.out.println("Reserva del " + reserva.getFecha() + " al " + reserva.getFechaFin() + 
                               " - Total: " + reserva.getMontoTotal());
        }
    }

    // Método para obtener el total de reservas
    public int getTotalReservas() {
        return totalReservas;
    }
}
