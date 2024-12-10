package model;

import java.util.List;

public class Cliente extends Persona implements ClienteUsuario {
    private String dni;
    private String numero;

    public Cliente(String nombre, String apellidos, String email, String dni, String numero) {
        super(nombre, apellidos, email);
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío.");
        }
        this.dni = dni;
        this.numero = numero;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        this.dni = dni;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío.");
        }
        this.numero = numero;
    }

    // Método específico de Cliente para realizar reservas
    public void realizarReserva(Vehiculo vehiculo, int dias) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("Los días reservados deben ser mayores a cero.");
        }
        if (!vehiculo.isDisponible()) {
            throw new IllegalArgumentException("El vehículo no está disponible.");
        }
        float costoTotal = vehiculo.getPrecioPorDia() * dias;
        System.out.println("Reserva realizada para el vehículo " + vehiculo.getMarca() + " por " + dias +
                " días. Costo total: " + costoTotal + " soles.");
    }

    // Métodos para acciones restringidas (opcional, pueden ser eliminados si no se usan)
    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Operación no permitida: los clientes no pueden agregar vehículos.");
    }

    @Override
    public void modificarVehiculo(String matricula, String nuevaMarca, String nuevoModelo, float nuevoPrecioPorDia) {
        throw new UnsupportedOperationException("Operación no permitida: los clientes no pueden modificar vehículos.");
    }

    @Override
    public void eliminarVehiculo(String matricula) {
        throw new UnsupportedOperationException("Operación no permitida: los clientes no pueden eliminar vehículos.");
    }

    @Override
    public void listarVehiculos() {
        throw new UnsupportedOperationException("Operación no permitida: los clientes no pueden listar vehículos.");
    }

    // Método para buscar un cliente por DNI
    public static Cliente buscarCliente(String dni, List<Cliente> clientes) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", numero='" + numero + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellido() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
