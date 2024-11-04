/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Trabajadores extends Persona {
    private String dni;
    private Date fechaNacimiento;
    private String direccion;

    // Constructor para inicializar los atributos de Trabajadores
    public Trabajadores(String nombre, String apellidos, String email, String claveAcceso, Date fechaNacimiento, String dni, String direccion) {
        super(nombre, apellidos, email, claveAcceso);
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
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

    // Actualiza la información del perfil del trabajador
    public void actualizarPerfil(String nuevaDireccion, Date nuevaFechaNacimiento) {
        this.direccion = nuevaDireccion;
        this.fechaNacimiento = nuevaFechaNacimiento;
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