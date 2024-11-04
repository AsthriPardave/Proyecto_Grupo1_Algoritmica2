package controller;

import model.Vehiculo;

public class AdministradorController {
    private Vehiculo[] flota;
    private int cantidad;

    public AdministradorController() {
        this.flota = new Vehiculo[10];
        this.cantidad = 0;
    }

    public boolean agregarVehiculo(String matricula, String marca, String modelo, float precioPorDia, boolean disponible) {
        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, precioPorDia, disponible);
        if (!existeVehiculo(vehiculo)) {
            if (cantidad == flota.length) {
                expandirCapacidad();
            }
            flota[cantidad++] = vehiculo;
            return true;
        }
        return false;
    }

    public boolean modificarVehiculo(String matricula, String atributo, Object nuevoValor) {
        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        if (vehiculo != null) {
            switch (atributo.toLowerCase()) {
                case "marca":
                    vehiculo.setMarca((String) nuevoValor);
                    break;
                case "modelo":
                    vehiculo.setModelo((String) nuevoValor);
                    break;
                case "precio":
                    vehiculo.setPrecioPorDia((Float) nuevoValor);
                    break;
                case "disponible":
                    vehiculo.setDisponible((Boolean) nuevoValor);
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String matricula) {
        for (int i = 0; i < cantidad; i++) {
            if (flota[i].getMatricula().equals(matricula)) {
                for (int j = i; j < cantidad - 1; j++) {
                    flota[j] = flota[j + 1];
                }
                flota[--cantidad] = null;
                return true;
            }
        }
        return false;
    }

    private Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (int i = 0; i < cantidad; i++) {
            if (flota[i].getMatricula().equals(matricula)) {
                return flota[i];
            }
        }
        return null;
    }

    private void expandirCapacidad() {
        Vehiculo[] nuevoArreglo = new Vehiculo[flota.length * 2];
        System.arraycopy(flota, 0, nuevoArreglo, 0, flota.length);
        flota = nuevoArreglo;
    }

    private boolean existeVehiculo(Vehiculo vehiculo) {
        return buscarVehiculoPorMatricula(vehiculo.getMatricula()) != null;
    }

    public Vehiculo[] obtenerFlota() {
        Vehiculo[] copiaFlota = new Vehiculo[cantidad];
        System.arraycopy(flota, 0, copiaFlota, 0, cantidad);
        return copiaFlota;
    }
}
