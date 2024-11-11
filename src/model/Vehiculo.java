/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private float precioPorDia;
    private boolean disponible;

    // Constructor que inicializa todos los atributos
    public Vehiculo(String matricula, String marca, String modelo, float precioPorDia, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.disponible = disponible;
    }

    // Getters y Setters para cada atributo
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método para calcular el costo de la reserva basado en los días
    public float calcularCostoReserva(int dias) {
        return precioPorDia * dias;
    }

    // Método para verificar si el vehículo está disponible
    public boolean verificarDisponibilidad() {
        return disponible;
    }

    // Método para representar el vehículo en formato de cadena
    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + 
               ", precioPorDia=" + precioPorDia + ", disponible=" + disponible + "]";
    }
}

/*VERSION ORIGINAL:

package model;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private float precioPorDia;
    private boolean disponible;

    public Vehiculo(String matricula, String marca, String modelo, float precioPorDia, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.disponible = disponible;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
*/