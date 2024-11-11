/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Trabajadores extends Persona {
    private String fechaNacimiento;
    private String direccion;

    public Trabajadores(String nombre, String apellidos, String email, String claveAcceso, String fechaNacimiento, String direccion) {
        super(nombre, apellidos, email, claveAcceso);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    // Getters y Setters
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

    // Métodos sobrescritos con acceso restringido
    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        System.out.println("Operación no permitida: los trabajadores no pueden agregar vehículos.");
    }

    @Override
    public void modificarVehiculo(String matricula, String nuevaMarca, String nuevoModelo, float nuevoPrecioPorDia) {
        System.out.println("Operación no permitida: los trabajadores no pueden modificar vehículos.");
    }

    @Override
    public void eliminarVehiculo(String matricula) {
        System.out.println("Operación no permitida: los trabajadores no pueden eliminar vehículos.");
    }

    @Override
    public void listarVehiculos() {
        System.out.println("Operación no permitida: los trabajadores no pueden listar vehículos.");
    }
}
