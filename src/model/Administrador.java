/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Administrador extends Persona {
    private Vehiculo[] listaVehiculos;
    private int totalVehiculos;
    private final int CAPACIDAD_MAXIMA = 100;

    public Administrador(String nombre, String apellidos, String email, String claveAcceso) {
        super(nombre, apellidos, email, claveAcceso);
        this.listaVehiculos = new Vehiculo[CAPACIDAD_MAXIMA];
        this.totalVehiculos = 0;
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (totalVehiculos < CAPACIDAD_MAXIMA) {
            listaVehiculos[totalVehiculos] = vehiculo;
            totalVehiculos++;
            System.out.println("Vehículo agregado exitosamente por el administrador.");
        } else {
            System.out.println("Capacidad máxima alcanzada. No se puede agregar más vehículos.");
        }
    }

    @Override
    public void modificarVehiculo(String matricula, String nuevaMarca, String nuevoModelo, float nuevoPrecioPorDia) {
        for (int i = 0; i < totalVehiculos; i++) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                listaVehiculos[i].setMarca(nuevaMarca);
                listaVehiculos[i].setModelo(nuevoModelo);
                listaVehiculos[i].setPrecioPorDia(nuevoPrecioPorDia);
                System.out.println("Vehículo modificado exitosamente por el administrador.");
                return;
            }
        }
        System.out.println("Vehículo con matrícula " + matricula + " no encontrado.");
    }

    @Override
    public void eliminarVehiculo(String matricula) {
        for (int i = 0; i < totalVehiculos; i++) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                for (int j = i; j < totalVehiculos - 1; j++) {
                    listaVehiculos[j] = listaVehiculos[j + 1];
                }
                listaVehiculos[totalVehiculos - 1] = null;
                totalVehiculos--;
                System.out.println("Vehículo eliminado exitosamente por el administrador.");
                return;
            }
        }
        System.out.println("Vehículo con matrícula " + matricula + " no encontrado.");
    }

    @Override
    public void listarVehiculos() {
        if (totalVehiculos == 0) {
            System.out.println("No hay vehículos registrados.");
        } else {
            System.out.println("Lista de vehículos:");
            for (int i = 0; i < totalVehiculos; i++) {
                Vehiculo vehiculo = listaVehiculos[i];
                System.out.println("Matrícula: " + vehiculo.getMatricula() + ", Marca: " + vehiculo.getMarca() +
                                   ", Modelo: " + vehiculo.getModelo() + ", Precio por día: " + vehiculo.getPrecioPorDia());
            }
        }
    }

    // Método adicional para obtener el total de vehículos
    public int getTotalVehiculos() {
        return totalVehiculos;
    }
}

