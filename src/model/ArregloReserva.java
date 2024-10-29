/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class ArregloReserva {
    private ArrayList<Reserva> reservas;

    public ArregloReserva() {
        this.reservas = new ArrayList<>();
    }

    public int getCantidadReservas() {
        return reservas.size();
    }

    // Método para agregar una reserva al arreglo
    public boolean agregarReserva(Reserva reserva) {
        return reservas.add(reserva);
    }

    // Método para buscar una reserva por su índice
    public Reserva buscarReservaPorIndice(int indice) {
        if (indice >= 0 && indice < reservas.size()) {
            return reservas.get(indice);
        }
        return null;  // Retorna null si el índice es inválido
    }

    // Método para eliminar una reserva por su índice
    public boolean eliminarReserva(int indice) {
        if (indice >= 0 && indice < reservas.size()) {
            reservas.remove(indice);
            return true;
        }
        return false;  // Retorna false si el índice es inválido
    }

    // Método para obtener todas las reservas (útil para listar)
    public ArrayList<Reserva> getReservas() {
        return reservas;
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