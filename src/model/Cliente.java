/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cliente extends Persona implements ClienteUsuario {
    private String dni;

    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
        this.dni = dni;
    }

    // Getter y Setter para dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método específico de Cliente para realizar reservas
    public void realizarReserva(Vehiculo vehiculo, int dias) {
        float costoTotal = vehiculo.getPrecioPorDia() * dias;
        System.out.println("Reserva realizada para el vehículo " + vehiculo.getMarca() + " por " + dias + 
                           " días. Costo total: " + costoTotal + " soles.");
    }

    // Métodos sobrescritos con acceso restringido
    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        System.out.println("Operación no permitida: los clientes no pueden agregar vehículos.");
    }

    @Override
    public void modificarVehiculo(String matricula, String nuevaMarca, String nuevoModelo, float nuevoPrecioPorDia) {
        System.out.println("Operación no permitida: los clientes no pueden modificar vehículos.");
    }

    @Override
    public void eliminarVehiculo(String matricula) {
        System.out.println("Operación no permitida: los clientes no pueden eliminar vehículos.");
    }

    @Override
    public void listarVehiculos() {
        System.out.println("Operación no permitida: los clientes no pueden listar vehículos.");
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
