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

    private boolean temp1 = false;
    private boolean temp2 = false;
    private boolean temp3 = false;

    private ArrayList<Reserva> reservas;

    public static ReservasController getInstance() {
        if (instance == null) {
            instance = new ReservasController();
        }
        return instance;
    }

    public ReservasController() {
        this.reservasView = new ReservasView();
        this.registroReservasView = new RegistroReservaView();
        this.modificarReservasView = new ModificarReservaView();
        this.reservas = new ArrayList<>();
    }

    public void start() {
        initReservasView();
        initRegistroReservaView();
        initModificarReservasView();
        reservasView.setVisible(true);
    }

    private void initReservasView() {
        if (temp1) return; // Evita inicializaciones múltiples
        temp1 = true;

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

        // ==PARA EL CAMBIO ENTRE VISTAS==

        reservasView.getBtnVehiculos().addActionListener(e -> {
            try {
                reservasView.setVisible(false);
                VehiculoController vehiculoController = VehiculoController.getInstance(); // Lanza IOException
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

        /* PARA EL CAMBIAR A LA VISTA DE PAGO CONTROLLER(cuando exista)

        reservasView.getBtnPagoOventa().addActionListener(e -> {
            reservasView.setVisible(false);
            PagoController pagoController = PagoController.getInstance();
            pagoController.start();
  
          });
          */

        // ==============================
    }

    private void initModificarReservasView() {
        if (temp2) return;
        temp2 = true;

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

    private void initRegistroReservaView() {
        if (temp3) return;
        temp3 = true;

        registroReservasView.getBtnRegister().addActionListener(e -> {
            try {
                int diasReservados = (Integer) registroReservasView.getSpinner().getValue();
                String matriculaVehiculo = registroReservasView.getTextVehiculo().getText();
                String dniCliente = registroReservasView.getTextCliente().getText();
                
                Vehiculo vehiculo = buscarVehiculo(matriculaVehiculo);
                Cliente cliente = Cliente.buscarCliente(dniCliente, FileManager.leerClientes());

                if (vehiculo == null) {
                    throw new Exception("No se encontró un vehículo con esa matrícula.");
                }

                if (!vehiculo.isDisponible()) {
                    throw new Exception("El vehículo no está disponible.");
                }

                Reserva reserva = new Reserva("id",diasReservados, vehiculo, cliente);
                reservas.add(reserva);

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

    private void actualizarTablaReserva() {
        DefaultTableModel model = (DefaultTableModel) reservasView.getTabla().getModel();
        model.setRowCount(0);

        for (Reserva reserva : reservas) {
            model.addRow(new Object[]{
                    reserva.getId(),
                    reserva.getFecha(),
                    reserva.getFechaFin(),
                    reserva.getMontoTotal()
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
