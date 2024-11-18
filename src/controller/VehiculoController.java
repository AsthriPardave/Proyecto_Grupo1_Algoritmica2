package controller;

import model.Vehiculo;
import model.Auto;
import model.Camion;
import model.Motocicleta;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VehiculoController {

    private VehiculosView vehiculoView;
    private RegistroVehiculoView registroVehiculoView;
    private ModalAutoView modalAutoView;
    private ModalCamionView modalCamionView;
    private ModalMotoView modalMotoView;

    private Vehiculo[] listaVehiculos;
    private int totalVehiculos;
    private final int CAPACIDAD_MAXIMA = 100;

    public VehiculoController(VehiculosView vehiculoView, RegistroVehiculoView registroVehiculoView,
                              ModalAutoView modalAutoView, ModalCamionView modalCamionView, ModalMotoView modalMotoView) {
        this.vehiculoView = vehiculoView;
        this.registroVehiculoView = registroVehiculoView;
        this.modalAutoView = modalAutoView;
        this.modalCamionView = modalCamionView;
        this.modalMotoView = modalMotoView;
        this.listaVehiculos = new Vehiculo[CAPACIDAD_MAXIMA];
        this.totalVehiculos = 0;

        initVehiculoView();
        initRegistroVehiculoView();
        initModalAutoView();
        initModalCamionView();
        initModalMotoView();
    }

    // Inicializar eventos en VehiculoView
    private void initVehiculoView() {
        vehiculoView.getBtnAñadirVehiculo().addActionListener(e -> {
            vehiculoView.setVisible(false);
            registroVehiculoView.setVisible(true);
        });

        vehiculoView.getjButton2().addActionListener(e -> buscarVehiculo());
    }

    // Inicializar eventos en RegistroVehiculoView
    private void initRegistroVehiculoView() {
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

    // Inicializar eventos en ModalAutoView
    private void initModalAutoView() {
        modalAutoView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                int numAsientos = (Integer) modalAutoView.getSpinnerNumAsientos().getValue();
                float capacidadMaletero = (Float) modalAutoView.getSpinnerCapMaletero().getValue();

                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalAutoView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo auto = new Auto(matricula, marca, modelo, precioPorDia, true, numAsientos, capacidadMaletero);
                listaVehiculos[totalVehiculos++] = auto;
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

    // Inicializar eventos en ModalCamionView
    private void initModalCamionView() {
        modalCamionView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                float capacidadCarga = Float.parseFloat(modalCamionView.getTxtCapCarga().getText());
                boolean dobleCabina = modalCamionView.getCheckboxDobleCabina().isSelected();

                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalCamionView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo camion = new Camion(matricula, marca, modelo, precioPorDia, true, capacidadCarga, dobleCabina);
                listaVehiculos[totalVehiculos++] = camion;
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

    // Inicializar eventos en ModalMotoView
    private void initModalMotoView() {
        modalMotoView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                int cilindraje = (Integer) modalMotoView.getSpinnerCilindraje().getValue();

                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalMotoView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo moto = new Motocicleta(matricula, marca, modelo, precioPorDia, true, cilindraje);
                listaVehiculos[totalVehiculos++] = moto;
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

        for (int i = 0; i < totalVehiculos; i++) {
            Vehiculo vehiculo = listaVehiculos[i];
            model.addRow(new Object[]{
                    vehiculo.getClass().getSimpleName(),
                    vehiculo.getMatricula(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getPrecioPorDia()
            });
        }
    }

    private void buscarVehiculo() {
        String matricula = vehiculoView.getTxtBuscarVehiculo().getText();

        for (int i = 0; i < totalVehiculos; i++) {
            if (listaVehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                JOptionPane.showMessageDialog(vehiculoView, listaVehiculos[i].toString());
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
}
