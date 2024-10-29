/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Auto extends Vehiculo{
    private int numeroAsientos;
    private float capacidadMaletero;

    public Auto(String matricula, String marca, String modelo, float precioPorDia, boolean disponible, int numeroAsientos, float capacidadMaletero) {
        super(matricula, marca, modelo, precioPorDia, disponible);
    }

    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
}
