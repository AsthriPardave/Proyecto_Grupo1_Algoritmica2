/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package model;
 import java.util.Date;
 import java.util.Calendar;
 
 public class Cliente extends Persona {
    private String dni;

    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método para realizar una reserva de un vehículo
    public Reserva realizarReserva(Vehiculo vehiculo, int dias) {
        if (vehiculo.verificarDisponibilidad()) {
            Date fechaInicio = new Date(); // Fecha actual como fecha de inicio
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaInicio);
            calendar.add(Calendar.DAY_OF_MONTH, dias);
            Date fechaFin = calendar.getTime(); // Calcula la fecha de fin en función de los días

            Reserva reserva = new Reserva(fechaInicio, fechaFin, dias, vehiculo);
            reserva.calcularTotal(); // Calcula el costo total
            return reserva; // Devuelve la reserva para continuar con el pago
        } else {
            System.out.println("El vehículo no está disponible.");
            return null;
        }
    }
}
/*VERSION ORIGINAL:

package model;

public class Cliente extends Persona {
    private String dni;

    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
*/