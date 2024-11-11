/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    // Constructor para inicializar los atributos específicos de Motocicleta
    public Motocicleta(String matricula, String marca, String modelo, float precioPorDia, boolean disponible, int cilindraje) {
        super(matricula, marca, modelo, precioPorDia, disponible);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}

