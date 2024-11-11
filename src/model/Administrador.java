/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Administrador extends Persona {

    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos, email, claveAcceso);
    }
    
    // Método para agregar un vehículo
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        // La implementación detallada estará en el controlador
        return true;
    }
    
    // Método para modificar un vehículo
    public boolean modificarVehiculo(Vehiculo vehiculo) {
        // La implementación detallada estará en el controlador
        return true;
    }
    
    // Método para eliminar un vehículo por matrícula
    public boolean eliminarVehiculo(String matricula) {
        // La implementación detallada estará en el controlador
        return true;
    }
}

/* VERSION ORIGINAL:

package model;

public class Administrador extends Persona {
    
    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos, email, claveAcceso);
    }
    
} 
*/