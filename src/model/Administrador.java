/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Administrador extends Persona {

    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos, email, claveAcceso);
    }

    @Override
    public void agregarVehiculo() {
        // Lógica para agregar un vehículo
        System.out.println("Vehículo agregado por el administrador.");
    }

    @Override
    public void modificarVehiculo() {
        // Lógica para modificar un vehículo
        System.out.println("Vehículo modificado por el administrador.");
    }

    @Override
    public void eliminarVehiculo() {
        // Lógica para eliminar un vehículo
        System.out.println("Vehículo eliminado por el administrador.");
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