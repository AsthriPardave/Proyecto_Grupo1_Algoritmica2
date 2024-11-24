/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Trabajadores extends Persona {
    private String fechaNacimiento;
    private String dni;
    private String tipoTrabajador;

    public Trabajadores(String nombre, String apellidos, String email, String claveAcceso, String fechaNacimiento, String dni, String tipoTrabajador ) {
        super(nombre, apellidos, email, claveAcceso);
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.tipoTrabajador = tipoTrabajador;
    }
    // Getters y Setters
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTipoTrabajador () {
      return tipoTrabajador;
    }
    public void setTipoTrabajador ( String tipoTrabajador ) {
      this.tipoTrabajador = tipoTrabajador;
    }
    @Override 
    public String toString() {
      return "Persona: <Tipo: " + tipoTrabajador + ", Nombre: " + super.getNombre() + ", Apellido: " +
        super.getApellido() + ", Email: " + super.getEmail() + ", fechaNacimiento: " + fechaNacimiento + 
        ", DNI: " + dni;
    }

}
