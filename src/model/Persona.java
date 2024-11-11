/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String email;
    private String claveAcceso;

    // Constructor para inicializar los atributos de Persona
    public Persona(String nombre, String apellidos, String email, String claveAcceso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.claveAcceso = claveAcceso;
    }

    // Método para autenticar a la persona mediante clave de acceso
    public boolean autenticar(String claveAcceso) {
        return this.claveAcceso.equals(claveAcceso);
    }

    // Métodos getters y setters para cada atributo
    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

