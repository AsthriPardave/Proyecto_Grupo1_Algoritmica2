package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Auto;
import model.Camion;
import model.FileManager;
import model.Motocicleta;
import model.Reserva;
import model.Vehiculo;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;
import view.RegistroVehiculoView;
import view.VehiculosView;

public class VehiculoController {
    private boolean temp1 = false;
    private boolean temp2 = false;
    private boolean temp3 = false;
    private boolean temp4 = false;
    private boolean temp5 = false;

    private static VehiculoController instance;

    private VehiculosView vehiculoView;
    private RegistroVehiculoView registroVehiculoView;
    private ModalAutoView modalAutoView;
    private ModalCamionView modalCamionView;
    private ModalMotoView modalMotoView;

    private ArrayList<Vehiculo> vehiculos;
    private final int CAPACIDAD_MAXIMA = 100;

    public static VehiculoController getInstance() throws IOException {
        if (instance == null) {
            instance = new VehiculoController();
        }
        return instance;
    }

    private VehiculoController() throws IOException {
        this.vehiculoView = new VehiculosView();
        this.registroVehiculoView = new RegistroVehiculoView();
        this.modalAutoView = new ModalAutoView();
        this.modalCamionView = new ModalCamionView();
        this.modalMotoView = new ModalMotoView();

        this.vehiculos = (ArrayList<Vehiculo>) FileManager.leerVehiculos();

        this.totalVehiculos = vehiculos.size();
        this.trabajadorView = new ClientesView();

    }

    public void start() {
        initVehiculoView();
        initRegistroVehiculoView();
        initModalAutoView();
        initModalCamionView();
        initModalMotoView();

        vehiculoView.setVisible(true);
    }

    private void initVehiculoView() {
        if (temp1) return;
        temp1 = true;

        actualizarTablaVehiculos();

        vehiculoView.getBtnAñadirVehiculo().addActionListener(e -> {
            vehiculoView.setVisible(false);
            registroVehiculoView.setVisible(true);
        });

        vehiculoView.getjButton2().addActionListener(e -> buscarVehiculo());
        vehiculoView.getJComboBox().addActionListener(e -> filtrarVehiculos());
    }

    private void initRegistroVehiculoView() {
        if (temp2) return;
        temp2 = true;

        registroVehiculoView.getBtnSiguiente().addActionListener(e -> {
            String tipoVehiculo = (String) registroVehiculoView.getComboboxTipoVehiculo().getSelectedItem();

            switch (tipoVehiculo) {
                case "Auto":
                    abrirModalAuto();
                    break;
                case "Camión":
                    abrirModalCamion();
                    break;
                case "Motocicleta":
                    abrirModalMoto();
                    break;
                default:
                    JOptionPane.showMessageDialog(registroVehiculoView, "Selecciona un tipo de vehículo válido.");
            }
        });

        registroVehiculoView.getBtnCancelarRegister().addActionListener(e -> {
            registroVehiculoView.setVisible(false);
            vehiculoView.setVisible(true);
        });
    }

    private void initModalAutoView() {
        if (temp3) return;
        temp3 = true;

        modalAutoView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                int numAsientos = (Integer) modalAutoView.getSpinnerNumAsientos().getValue();
                int capacidadMaletero = (Integer) modalAutoView.getSpinnerCapMaletero().getValue();
                boolean disponible = registroVehiculoView.getCheckBox().isSelected();

                if (vehiculos.stream().anyMatch(v -> v.getMatricula().equals(matricula))) {
                    throw new Exception("No se puede registrar otro vehículo con la misma matrícula.");
                }

                if (vehiculos.size() >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalAutoView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo auto = new Auto(matricula, marca, modelo, precioPorDia, disponible, numAsientos, capacidadMaletero);
                vehiculos.add(auto);
                FileManager.escribirVehiculo(vehiculos);
                totalVehiculos++;

                actualizarTablaVehiculos();
                modalAutoView.setVisible(false);
                registroVehiculoView.setVisible(false);
                vehiculoView.setVisible(true);
                JOptionPane.showMessageDialog(vehiculoView, "Auto registrado con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modalAutoView, "Error al registrar el auto: " + ex.getMessage());
            }
        });

        modalAutoView.getBtnCancelar().addActionListener(e -> modalAutoView.setVisible(false));
    }

    private void initModalCamionView() {
        if (temp4) return;
        temp4 = true;

        modalCamionView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                float capacidadCarga = Float.parseFloat(modalCamionView.getTxtCapCarga().getText());
                boolean dobleCabina = modalCamionView.getCheckboxDobleCabina().isSelected();
                boolean disponible = registroVehiculoView.getCheckBox().isSelected();

                if (vehiculos.stream().anyMatch(v -> v.getMatricula().equals(matricula))) {
                    throw new Exception("No se puede registrar otro vehículo con la misma matrícula.");
                }

                if (vehiculos.size() >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalCamionView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo camion = new Camion(matricula, marca, modelo, precioPorDia, disponible, capacidadCarga, dobleCabina);
                vehiculos.add(camion);

                actualizarTablaVehiculos();
                modalCamionView.setVisible(false);
                registroVehiculoView.setVisible(false);
                vehiculoView.setVisible(true);
                JOptionPane.showMessageDialog(vehiculoView, "Camión registrado con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modalCamionView, "Error al registrar el camión: " + ex.getMessage());
            }
        });

        modalCamionView.getBtnCancelar().addActionListener(e -> modalCamionView.setVisible(false));
    }

    private void initModalMotoView() {
        if (temp5) return;
        temp5 = true;

        modalMotoView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                int cilindraje = (Integer) modalMotoView.getSpinnerCilindraje().getValue();
                boolean disponible = registroVehiculoView.getCheckBox().isSelected();

                if (vehiculos.stream().anyMatch(v -> v.getMatricula().equals(matricula))) {
                    throw new Exception("No se puede registrar otro vehículo con la misma matrícula.");
                }

                if (vehiculos.size() >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalMotoView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo moto = new Motocicleta(matricula, marca, modelo, precioPorDia, disponible, cilindraje);
                vehiculos.add(moto);

                actualizarTablaVehiculos();
                modalMotoView.setVisible(false);
                registroVehiculoView.setVisible(false);
                vehiculoView.setVisible(true);
                JOptionPane.showMessageDialog(vehiculoView, "Motocicleta registrada con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modalMotoView, "Error al registrar la motocicleta: " + ex.getMessage());
            }
        });

        modalMotoView.getBtnCancelar().addActionListener(e -> modalMotoView.setVisible(false));
    }

    private void actualizarTablaVehiculos() {
        DefaultTableModel model = (DefaultTableModel) vehiculoView.getjTable1().getModel();
        model.setRowCount(0);

        for (Vehiculo vehiculo : vehiculos) {
            model.addRow(new Object[]{
                    vehiculo.getMatricula(),
                    vehiculo.getClass().getSimpleName(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getPrecioPorDia()
            });
        }
    }

    private void buscarVehiculo() {
        String matricula = vehiculoView.getTxtBuscarVehiculo().getText();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                JOptionPane.showMessageDialog(vehiculoView, vehiculo.toString());
                return;
            }
        }

        JOptionPane.showMessageDialog(vehiculoView, "Vehículo no encontrado.");
    }

    private void abrirModalAuto() {
        modalAutoView.setVisible(true);
    }

    private void abrirModalCamion() {
        modalCamionView.setVisible(true);
    }

    private void abrirModalMoto() {
        modalMotoView.setVisible(true);
    }

    private void filtrarVehiculos() {
        String tipoSeleccionado = (String) vehiculoView.getJComboBox().getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) vehiculoView.getjTable1().getModel();
        model.setRowCount(0);

        for (Vehiculo vehiculo : vehiculos) {
            boolean coincide = tipoSeleccionado.equals("Todos") ||
                    (tipoSeleccionado.equals("Autos") && vehiculo instanceof Auto) ||
                    (tipoSeleccionado.equals("Camiones") && vehiculo instanceof Camion) ||
                    (tipoSeleccionado.equals("Motocicletas") && vehiculo instanceof Motocicleta);

            if (coincide) {
                model.addRow(new Object[]{
                        vehiculo.getMatricula(),
                        vehiculo.getClass().getSimpleName(),
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.getPrecioPorDia()
                });
            }
        }
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
}
