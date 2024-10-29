/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Camion extends Vehiculo {
    private float capacidadCarga;
    private boolean dobleCabina;

    public Camion(String matricula, String marca, String modelo, float precioPorDia, boolean disponible, float capacidadCarga, boolean dobleCabina) {
        super(matricula, marca, modelo, precioPorDia, disponible);
        this.capacidadCarga = capacidadCarga;
        this.dobleCabina = dobleCabina;
    }

    public boolean isDobleCabina() {
        return dobleCabina;
    }

    public void setDobleCabina(boolean dobleCabina) {
        this.dobleCabina = dobleCabina;
    }

    public float getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}

 /*VERSION ORIGINAL:

package model;

public class Camion extends Vehiculo {
    private float capacidadCarga;
    private boolean dobleCabina;

    public Camion(String matricula, String marca, String modelo, float precioPorDia, boolean disponible, float capacidadCarga, boolean dobleCabina) {
        super(matricula, marca, modelo, precioPorDia, disponible);
    }

    public boolean isDobleCabina() {
        return dobleCabina;
    }

    public void setDobleCabina(boolean dobleCabina) {
        this.dobleCabina = dobleCabina;
    }

    public float getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
}
*/