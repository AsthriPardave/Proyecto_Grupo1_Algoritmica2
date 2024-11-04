/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ArregloReserva {
    private Reserva[] reservas;
    private int cantidad;

    // Constructor con capacidad inicial de 10 reservas
    public ArregloReserva() {
        this.reservas = new Reserva[10];
        this.cantidad = 0;
    }

    // Devuelve la cantidad actual de reservas
    public int getCantidadReservas() {
        return cantidad;
    }

    // Agrega una reserva al arreglo, expandiendo la capacidad si es necesario
    public boolean agregarReserva(Reserva reserva) {
        if (cantidad == reservas.length) {
            expandirCapacidad();
        }
        reservas[cantidad++] = reserva;
        return true;
    }

    // Busca una reserva por su índice
    public Reserva buscarReservaPorIndice(int indice) {
        if (indice >= 0 && indice < cantidad) {
            return reservas[indice];
        }
        return null;
    }

    // Elimina una reserva por su índice
    public boolean eliminarReserva(int indice) {
        if (indice >= 0 && indice < cantidad) {
            for (int i = indice; i < cantidad - 1; i++) {
                reservas[i] = reservas[i + 1];
            }
            reservas[--cantidad] = null;
            return true;
        }
        return false;
    }

    // Expande la capacidad del arreglo al doble cuando se llena
    private void expandirCapacidad() {
        Reserva[] nuevoArreglo = new Reserva[reservas.length * 2];
        System.arraycopy(reservas, 0, nuevoArreglo, 0, reservas.length);
        reservas = nuevoArreglo;
    }

    // Retorna todas las reservas hasta la cantidad actual
    public Reserva[] getReservas() {
        Reserva[] copiaReservas = new Reserva[cantidad];
        System.arraycopy(reservas, 0, copiaReservas, 0, cantidad);
        return copiaReservas;
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