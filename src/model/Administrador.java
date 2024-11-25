package model;

public class Administrador {
    private String nombre;
    private String apellidos;
    private String email;
    private String claveAcceso;

    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
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

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
}
