/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Trabajadores extends Persona {

    private String fechaNacimiento;
    private String direccion;

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Trabajadores(String nombre, String apellidos, String email, String claveAcceso, String fechaNacimiento, String direccion) {
        super(nombre, apellidos, email, claveAcceso);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    @Override
    public void agregarVehiculo() {
        // Lógica limitada para agregar un vehículo o un mensaje de acceso restringido
        System.out.println("Trabajador agregado en el sistema.");
    }

    @Override
    public void modificarVehiculo() {
        // Lógica limitada para modificar un vehículo
        System.out.println("Modificación de vehículo restringida para trabajadores.");
    }

    @Override
    public void eliminarVehiculo() {
        // Lógica limitada para eliminar un vehículo
        System.out.println("Eliminación de vehículo restringida para trabajadores.");
    }
}

/*VERSION ORIGINAL

package model;

import java.util.Date;

public class Trabajadores extends Persona{
    private String dni;
    private Date fechaNacimiento;
    private String direccion;

    public Trabajadores(String nombre, String apellidos, String email, String claveAcceso, Date fechaNacimiento, String dni, String direccion) {
        super(nombre, apellidos, email, claveAcceso);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
*/