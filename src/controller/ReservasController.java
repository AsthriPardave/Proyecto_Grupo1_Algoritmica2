package controller;

import model.Reserva;
import model.Vehiculo;
import view.ModificarReservas;
import view.RegistroReservaView;
import view.ReservasView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.util.ArrayList;

public class ReservasController {
    private static ReservasController instance;

    private ReservasView reservasView;
    private RegistroReservaView registroReservasView;
    private ModificarReservas modificarReservasView;

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
        this.modificarReservasView = new ModificarReservas();
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
        reservasView.getComboBox().addActionListener(e -> filtrarReserva());

        reservasView.getBtnModificar().addActionListener(e -> {
            reservasView.setVisible(false);
            modificarReservasView.setVisible(true);
        });
    }

    private void initModificarReservasView() {
        if (temp2) return;
        temp2 = true;

        modificarReservasView.getBtnModificar().addActionListener(e -> {
            try {
                String id = modificarReservasView.getTextIdReserva().getText();
                double pago = Double.parseDouble(modificarReservasView.getTextPago().getText());

                Reserva reserva = reservas.stream()
                        .filter(r -> r.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new Exception("No se encontró una reserva con ese ID"));

                if (pago <= 0) {
                    throw new Exception("El pago es incorrecto");
                }

                reserva.setMontoActual(reserva.getMontoActual() + pago);

                if (reserva.getMontoActual() >= reserva.getMontoTotal()) {
                    reserva.setCancelado(true);
                    reserva.setMontoActual(reserva.getMontoTotal());

                    double vuelto = reserva.getMontoActual() - reserva.getMontoTotal();
                    if (vuelto > 0) {
                        JOptionPane.showMessageDialog(modificarReservasView,
                                "Pago completo. Vuelto: " + vuelto);
                    } else {
                        JOptionPane.showMessageDialog(modificarReservasView, "Pago completo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(modificarReservasView,
                            "Pago parcial. Monto restante: " + (reserva.getMontoTotal() - reserva.getMontoActual()));
                }

                modificarReservasView.setVisible(false);
                reservasView.setVisible(true);
                actualizarTablaReserva();

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

    private void filtrarReserva() {
        String tipoReserva = (String) reservasView.getComboBox().getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) reservasView.getTabla().getModel();
        model.setRowCount(0);

        for (Reserva reserva : reservas) {
            String tipo = reserva.getCancelado() ? "Cancelados" : "Por Cancelar";

            if (tipoReserva.equals("Todos") || tipoReserva.equals(tipo)) {
                model.addRow(new Object[]{
                        reserva.getId(),
                        reserva.getFechaInicio(),
                        reserva.getFechaFin(),
                        reserva.getMontoActual(),
                        reserva.getMontoTotal()
                });
            }
        }
    }

    private void initRegistroReservaView() {
        if (temp3) return;
        temp3 = true;

        registroReservasView.getBtnRegister().addActionListener(e -> {
            try {
                int diasReservados = (Integer) registroReservasView.getSpinner().getValue();
                String matriculaVehiculo = registroReservasView.getTextVehiculo().getText();

                Vehiculo vehiculo = buscarVehiculo(matriculaVehiculo);

                if (vehiculo == null) {
                    throw new Exception("No se encontró un vehículo con esa matrícula.");
                }

                if (!vehiculo.isDisponible()) {
                    throw new Exception("El vehículo no está disponible.");
                }

                Reserva reserva = new Reserva(diasReservados, vehiculo);
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
                    reserva.getFechaInicio(),
                    reserva.getFechaFin(),
                    reserva.getMontoActual(),
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
