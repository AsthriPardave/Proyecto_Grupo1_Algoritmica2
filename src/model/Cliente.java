/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cliente extends Persona {
    private String dni;

    // Constructor para inicializar los atributos de Cliente
    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}

/*VERSION ORIGINAL:

package model;

public class Cliente extends Persona {
    private String dni;

    public Cliente(String nombre, String apellidos, String email, String claveAcceso, String dni) {
        super(nombre, apellidos, email, claveAcceso);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
*/