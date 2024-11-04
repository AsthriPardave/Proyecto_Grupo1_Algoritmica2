/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/*import model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArregloReserva arregloReserva = new ArregloReserva();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Agregar algunos vehículos de ejemplo al sistema
        inicializarVehiculos();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    realizarReserva();
                    break;
                case 2:
                    confirmarPago();
                    break;
                case 3:
                    listarReservas();
                    break;
                case 4:
                    gestionarVehiculos(); // Opciones de administrador
                    break;
                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Alquiler de Vehículos ---");
        System.out.println("1. Realizar una reserva");
        System.out.println("2. Confirmar pago de una reserva");
        System.out.println("3. Listar todas las reservas");
        System.out.println("4. Gestionar vehículos (Administrador)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarVehiculos() {
        // Añadir algunos vehículos al sistema
        vehiculos.add(new Auto("A1234", "Toyota", "Corolla", 50.0f, true, 5, 400.0f));
        vehiculos.add(new Motocicleta("M5678", "Yamaha", "R15", 30.0f, true, 150));
        vehiculos.add(new Camion("C91011", "Ford", "Ranger", 80.0f, true, 1000.0f, true));
    }

    private static void realizarReserva() {
        System.out.println("Seleccione un vehículo para reservar:");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            System.out.println(i + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " - " + (vehiculo.isDisponible() ? "Disponible" : "No Disponible"));
        }
        int indiceVehiculo = scanner.nextInt();
        scanner.nextLine();

        if (indiceVehiculo >= 0 && indiceVehiculo < vehiculos.size()) {
            Vehiculo vehiculo = vehiculos.get(indiceVehiculo);
            if (vehiculo.verificarDisponibilidad()) {
                System.out.print("Ingrese la cantidad de días de alquiler: ");
                int dias = scanner.nextInt();
                scanner.nextLine();
                Date fechaInicio = new Date(); // Ejemplo de fecha actual
                Date fechaFin = new Date(fechaInicio.getTime() + (dias * 86400000L)); // Fecha de fin
                Reserva reserva = new Reserva(fechaInicio, fechaFin, dias, vehiculo);
                arregloReserva.agregarReserva(reserva);
                System.out.println("Reserva creada con éxito. Total: $" + reserva.getMontoTotal());
            } else {
                System.out.println("El vehículo no está disponible.");
            }
        } else {
            System.out.println("Opción de vehículo inválida.");
        }
    }

    private static void confirmarPago() {
        System.out.print("Ingrese el índice de la reserva a confirmar: ");
        int indiceReserva = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = arregloReserva.buscarReservaPorIndice(indiceReserva);
        if (reserva != null && !reserva.isConfirmada()) {
            System.out.print("Ingrese el monto del pago: ");
            float monto = scanner.nextFloat();
            scanner.nextLine();
            Date fechaPago = new Date(); // Fecha actual
            System.out.print("Ingrese el método de pago (Ej: Tarjeta, Efectivo): ");
            String metodoPago = scanner.nextLine();
            Pago pago = new Pago(monto, fechaPago, metodoPago);
            if (pago.procesarPago()) {
                reserva.confirmarReserva();
                System.out.println("Pago procesado y reserva confirmada.");
            } else {
                System.out.println("Error en el procesamiento del pago.");
            }
        } else {
            System.out.println("Reserva no encontrada o ya confirmada.");
        }
    }

    private static void listarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (int i = 0; i < arregloReserva.getCantidadReservas(); i++) {
            Reserva reserva = arregloReserva.buscarReservaPorIndice(i);
            System.out.println("Reserva " + i + ": Vehículo " + reserva.getVehiculo().getMarca() + " " + reserva.getVehiculo().getModelo() +
                    ", Días: " + reserva.getDiasReservados() + ", Monto Total: $" + reserva.getMontoTotal() + ", Confirmada: " + (reserva.isConfirmada() ? "Sí" : "No"));
        }
    }

    private static void gestionarVehiculos() {
        System.out.println("\n--- Gestión de Vehículos ---");
        System.out.println("1. Agregar Vehículo");
        System.out.println("2. Modificar Vehículo");
        System.out.println("3. Eliminar Vehículo");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                // Lógica para agregar un nuevo vehículo
                System.out.println("Funcionalidad de agregar vehículo pendiente de implementación.");
                break;
            case 2:
                // Lógica para modificar un vehículo existente
                System.out.println("Funcionalidad de modificar vehículo pendiente de implementación.");
                break;
            case 3:
                // Lógica para eliminar un vehículo existente
                System.out.println("Funcionalidad de eliminar vehículo pendiente de implementación.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
*/