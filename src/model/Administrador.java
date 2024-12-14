package model;

public class Administrador extends Persona{
    private String email;
    private String claveAcceso;

    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos);
        this.email = email;
        this.claveAcceso = claveAcceso;
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
