package model;

public class ArregloVehiculo {
    private Vehiculo[] vehiculos;
    private int totalVehiculos; // Contador de vehículos en el arreglo
    private final int CAPACIDAD_MAXIMA;

    // Constructor que inicializa la capacidad máxima y el arreglo de vehículos
    public ArregloVehiculo(int capacidadMaxima) {
        this.CAPACIDAD_MAXIMA = capacidadMaxima;
        this.vehiculos = new Vehiculo[capacidadMaxima];
        this.totalVehiculos = 0;
    }

    // Método para agregar un vehículo al arreglo
    public boolean agregar(Vehiculo vehiculo) {
        if (totalVehiculos < CAPACIDAD_MAXIMA) {
            vehiculos[totalVehiculos] = vehiculo;
            totalVehiculos++;
            return true;
        } else {
            System.out.println("No se pueden agregar más vehículos, capacidad máxima alcanzada.");
            return false;
        }
    }

    // Método para buscar un vehículo por matrícula
    public Vehiculo buscar(String matricula) {
        for (int i = 0; i < totalVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                return vehiculos[i];
            }
        }
        return null; // Retorna null si el vehículo no se encuentra
    }

    // Método para obtener la lista de vehículos como un arreglo de vehículos existentes
    public Vehiculo[] getListaVehiculos() {
        Vehiculo[] lista = new Vehiculo[totalVehiculos];
        System.arraycopy(vehiculos, 0, lista, 0, totalVehiculos);
        return lista;
    }
}
