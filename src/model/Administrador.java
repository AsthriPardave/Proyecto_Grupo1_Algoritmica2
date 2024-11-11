/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Administrador extends Persona {

    // Constructor para inicializar los atributos de Administrador
    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos, email, claveAcceso);
    }

    // Agrega un nuevo vehículo a la flota
    public void agregarVehiculo(Vehiculo vehiculo) {
        // Lógica para agregar el vehículo al sistema
    }

    // Modifica un atributo específico de un vehículo existente
    public void modificarVehiculo(Vehiculo vehiculo, String atributo, Object nuevoValor) {
        // Lógica para modificar el vehículo según el atributo y el nuevo valor
    }

    // Elimina un vehículo de la flota
    public void eliminarVehiculo(Vehiculo vehiculo) {
        // Lógica para eliminar el vehículo del sistema
    }
}
