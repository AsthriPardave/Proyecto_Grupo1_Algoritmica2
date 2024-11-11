/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cliente extends Persona {
    private String dni;

    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
        this.dni = dni;
    }

    // Método específico de Cliente
    public void realizarReserva(Vehiculo vehiculo, int dias) {
        System.out.println("Reserva realizada para el vehículo " + vehiculo.getMarca() + " por " + dias + " días.");
    }

    @Override
    public void agregarVehiculo() {
        // Los clientes no pueden agregar vehículos
        System.out.println("Operación no permitida para clientes.");
    }

    @Override
    public void modificarVehiculo() {
        // Los clientes no pueden modificar vehículos
        System.out.println("Operación no permitida para clientes.");
    }

    @Override
    public void eliminarVehiculo() {
        // Los clientes no pueden eliminar vehículos
        System.out.println("Operación no permitida para clientes.");
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