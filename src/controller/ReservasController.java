package controller;

import model.Reserva;
import model.Vehiculo;
import view.ModificarReservaView;
import view.RegistroReservaView;
import view.ReservasView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.FileManager;

public class ReservasController {
    private static ReservasController instance;

    private ReservasView reservasView;
    private RegistroReservaView registroReservasView;
    private ModificarReservaView modificarReservasView;

    private ArrayList<Reserva> reservas;

    private ReservasController() {
        this.reservasView = new ReservasView();
        this.registroReservasView = new RegistroReservaView();
        this.modificarReservasView = new ModificarReservaView();
        this.reservas = new ArrayList<>();

        // Cargar reservas desde archivo al iniciar
        try {
            List<Vehiculo> vehiculos = FileManager.leerVehiculos();
            List<Cliente> clientes = FileManager.leerClientes();
            this.reservas = new ArrayList<>(FileManager.leerReservas(vehiculos, clientes));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos de reservas: " + e.getMessage());
        }
    }

    public static ReservasController getInstance() {
        if (instance == null) {
            instance = new ReservasController();
        }
        return instance;
    }

    public void start() {
        initReservasView();
        initRegistroReservaView();
        initModificarReservasView();
        actualizarTablaReserva(); // Mostrar reservas al iniciar
        reservasView.setVisible(true);
    }

    private void initReservasView() {
        reservasView.getBtnAnhadir().addActionListener(e -> {
            reservasView.setVisible(false);
            registroReservasView.setVisible(true);
        });

        reservasView.getBtnBuscar().addActionListener(e -> buscarReserva());

        reservasView.getBtnModificar().addActionListener(e -> {
            try {
                String id = reservasView.getTextField().getText();
                Reserva reserva = reservas.stream()
                        .filter(r -> r.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new Exception("Reserva no encontrada."));

                modificarReservasView.getSpinnerNumAsientos().setValue(reserva.getDiasReservados());
                modificarReservasView.setVisible(true);
                reservasView.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(reservasView, "Error: " + ex.getMessage());
            }
        });

        reservasView.getBtnVehiculos().addActionListener(e -> {
            try {
                reservasView.setVisible(false);
                VehiculoController vehiculoController = VehiculoController.getInstance();
                vehiculoController.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(reservasView, "Error al abrir la vista de vehículos: " + ex.getMessage());
            }
        });

        reservasView.getBtnTrabajadores().addActionListener(e -> {
            reservasView.setVisible(false);
            ClienteController clienteController = ClienteController.getInstance();
            clienteController.start();
        });

        reservasView.getBtnPagoOventa().addActionListener(e -> {
            reservasView.setVisible(false);
            PagoController pagoController = PagoController.getInstance();
            pagoController.start();
        });
    }

    private void initRegistroReservaView() {
        registroReservasView.getBtnRegister().addActionListener(e -> {
            try {
                int diasReservados = (Integer) registroReservasView.getSpinner().getValue();
                String matriculaVehiculo = registroReservasView.getTextVehiculo().getText();
                String dniCliente = registroReservasView.getTextCliente().getText();

                // Validar Vehículo
                Vehiculo vehiculo = buscarVehiculo(matriculaVehiculo);
                if (vehiculo == null) {
                    throw new Exception("No se encontró un vehículo con esa matrícula.");
                }

                if (!vehiculo.isDisponible()) {
                    throw new Exception("El vehículo no está disponible.");
                }

                // Validar Cliente
                Cliente cliente = Cliente.buscarCliente(dniCliente, FileManager.leerClientes());
                if (cliente == null) {
                    throw new Exception("No se encontró un cliente con ese DNI.");
                }

                // Verificar si ya existe una reserva para el mismo vehículo
                boolean existeReserva = reservas.stream()
                .anyMatch(r -> r.getVehiculo().getMatricula().equals(vehiculo.getMatricula()));
                if (existeReserva) {
                throw new Exception("Este cliente ya tiene una reserva para este vehículo.");
                }


                // Crear ID único para la reserva
                String idReserva = "R" + vehiculo.getMatricula().hashCode();

                // Crear y guardar reserva
                Reserva reserva = new Reserva(idReserva, diasReservados, vehiculo, cliente);
                reservas.add(reserva);

                FileManager.escribirReserva(reservas); // Guardar reservas en archivo

                actualizarTablaReserva();
                registroReservasView.setVisible(false);
                reservasView.setVisible(true);
                JOptionPane.showMessageDialog(reservasView, "Reserva registrada con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(registroReservasView, "Error al registrar reserva: " + ex.getMessage());
            }
        });

        registroReservasView.getBtnCancelar().addActionListener(e -> {
            registroReservasView.setVisible(false);
            reservasView.setVisible(true);
        });
    }

    private void initModificarReservasView() {
        modificarReservasView.getBtnModificar().addActionListener(e -> {
            try {
                String id = reservasView.getTextField().getText();
                int nuevosDias = (Integer) modificarReservasView.getSpinnerNumAsientos().getValue();

                Reserva reserva = reservas.stream()
                        .filter(r -> r.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new Exception("Reserva no encontrada."));

                if (nuevosDias <= 0) {
                    throw new Exception("El número de días debe ser mayor a cero.");
                }

                reserva.setDiasReservados(nuevosDias);
                reserva.calcular();

                FileManager.escribirReserva(reservas); // Guardar cambios
                actualizarTablaReserva();
                modificarReservasView.setVisible(false);
                reservasView.setVisible(true);
                JOptionPane.showMessageDialog(reservasView, "Reserva modificada exitosamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modificarReservasView, "Error al modificar la reserva: " + ex.getMessage());
            }
        });

        modificarReservasView.getBtnCancelar().addActionListener(e -> {
            modificarReservasView.setVisible(false);
            reservasView.setVisible(true);
        });
    }

    private void buscarReserva() {
        String id = reservasView.getTextField().getText();

        Reserva reserva = reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (reserva != null) {
            JOptionPane.showMessageDialog(reservasView, reserva.toString());
        } else {
            JOptionPane.showMessageDialog(reservasView, "Reserva no encontrada.");
        }
    }

    private void actualizarTablaReserva() {
        DefaultTableModel model = (DefaultTableModel) reservasView.getTabla().getModel();
        model.setRowCount(0);

        for (Reserva reserva : reservas) {
            float montoPorPagar = reserva.getDiasReservados() * reserva.getVehiculo().getPrecioPorDia();

            model.addRow(new Object[]{
                    reserva.getId(),
                    reserva.getDiasReservados(),
                    reserva.getVehiculo().getMatricula(),
                    reserva.getCliente().getDni(),
                    montoPorPagar
            });
        }
    }

    private Vehiculo buscarVehiculo(String matricula) {
        try {
            VehiculoController vehiculoController = VehiculoController.getInstance();
            return vehiculoController.getVehiculos().stream()
                    .filter(vehiculo -> vehiculo.getMatricula().equals(matricula))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
