package controller;

import java.io.IOException;
import model.Vehiculo;
import model.Auto;
import model.Camion;
import model.Motocicleta;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;
import view.ReservasView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import model.FileManager;

import view.ClientesView;

public class VehiculoController {
  private boolean temp1 = false;
  private boolean temp2 = false; 
  private boolean temp3 = false; 
  private boolean temp4 = false; 
  private boolean temp5 = false; 

    private static VehiculoController instance;

    private VehiculosView vehiculoView = null;
    private RegistroVehiculoView registroVehiculoView;
    private ModalAutoView modalAutoView;
    private ModalCamionView modalCamionView;
    private ModalMotoView modalMotoView;

    public ArrayList<Vehiculo> vehiculos;
    private int totalVehiculos;
    private final int CAPACIDAD_MAXIMA = 100;

    public static VehiculoController getInstance() throws IOException {
      if ( instance == null ) 
        instance = new VehiculoController ();


      return instance;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    private VehiculoController() throws IOException {
        this.vehiculoView = new VehiculosView();
        this.registroVehiculoView = new RegistroVehiculoView();
        this.modalAutoView = new ModalAutoView();
        this.modalCamionView = new ModalCamionView();
        this.modalMotoView = new ModalMotoView();

        this.vehiculos = (ArrayList<Vehiculo>) FileManager.leerVehiculos();

        this.totalVehiculos = vehiculos.size();

    }
    public void start () {
      instance.initVehiculoView();
      instance.initRegistroVehiculoView();
      instance.initModalAutoView();
      instance.initModalCamionView();
      instance.initModalMotoView();

      vehiculoView.setVisible(true);
    }

    // Inicializar eventos en VehiculoView
    private void initVehiculoView() {
        
        if ( temp1 ) return;
        temp1 = true;
        actualizarTablaVehiculos();
        vehiculoView.getBtnAñadirVehiculo().addActionListener(e -> {
            vehiculoView.setVisible(false);
            registroVehiculoView.setVisible(true);
        });

        vehiculoView.getjButton2().addActionListener(e -> buscarVehiculo());

        vehiculoView.getJComboBox().addActionListener ( e -> filtrarVehiculos() );

        // ==PARA EL CAMBIO ENTRE VISTAS==

        vehiculoView.getBtnReservaView().addActionListener(e -> {
          vehiculoView.setVisible(false);
          ReservasController reservasController = ReservasController.getInstance();
          reservasController.start();

        });

        vehiculoView.getBtnTrabajadoresView().addActionListener(e -> {
            vehiculoView.setVisible(false);
            ClienteController clienteController = ClienteController.getInstance();
            clienteController.start();
  
          });

        // PARA EL CAMBIAR A LA VISTA DE PAGO CONTROLLER(cuando exista)

        vehiculoView.getBtnPagoOventa().addActionListener(e -> {
            vehiculoView.setVisible(false);
            PagoController pagoController = PagoController.getInstance();
            pagoController.start();
  
          });


        // ==============================
    }

    // Inicializar eventos en RegistroVehiculoView
    private void initRegistroVehiculoView() {
        if ( temp2 ) return;
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

    // Inicializar eventos en ModalAutoView
    private void initModalAutoView() {
        if ( temp3 ) return;
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
                
                for ( int i = 0; i < vehiculos.size(); i++ ) 
                  if ( matricula.equals(vehiculos.get(i).getMatricula()))
                    throw new Exception("No se puede registra otro vehiculo con la misma matricula");


                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
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

    // Inicializar eventos en ModalCamionView
    private void initModalCamionView() {
        if ( temp4 ) return;
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

                for ( int i = 0; i < vehiculos.size(); i++ ) 
                  if ( matricula.equals(vehiculos.get(i).getMatricula()))
                    throw new Exception("No se puede registra otro vehiculo con la misma matricula");

                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalCamionView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo camion = new Camion(matricula, marca, modelo, precioPorDia, disponible, capacidadCarga, dobleCabina);
                vehiculos.add(camion);
                totalVehiculos++;

                actualizarTablaVehiculos();
                modalCamionView.setVisible(false);
                registroVehiculoView.setVisible(false);
                vehiculoView.setVisible(true);
                JOptionPane.showMessageDialog(vehiculoView, "Camión registrado con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modalCamionView, "Error al registrar el camión: " + ex.getMessage());
            }
        });

        vehiculoView.getJComboBox().addActionListener(e -> filtrarVehiculos());
    }

    // Inicializar eventos en ModalMotoView
    private void initModalMotoView() {
        if ( temp5 ) return;
        temp5 = true;
        modalMotoView.getBtnAgregar().addActionListener(e -> {
            try {
                String matricula = registroVehiculoView.getTxtMatricula().getText();
                String marca = registroVehiculoView.getTxtMarca().getText();
                String modelo = registroVehiculoView.getTxtModelo().getText();
                float precioPorDia = Float.parseFloat(registroVehiculoView.getTxtPrecioPorDia().getText());
                int cilindraje = (Integer) modalMotoView.getSpinnerCilindraje().getValue();
                boolean disponible = registroVehiculoView.getCheckBox().isSelected();

                for ( int i = 0; i < vehiculos.size(); i++ ) 
                  if ( matricula.equals(vehiculos.get(i).getMatricula()))
                    throw new Exception("No se puede registra otro vehiculo con la misma matricula");

                if (totalVehiculos >= CAPACIDAD_MAXIMA) {
                    JOptionPane.showMessageDialog(modalMotoView, "Capacidad máxima alcanzada.");
                    return;
                }

                Vehiculo moto = new Motocicleta(matricula, marca, modelo, precioPorDia, disponible, cilindraje);
                vehiculos.add(moto);
                totalVehiculos++;

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
            Vehiculo vehiculo = vehiculos.get(i);
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

        for (int i = 0; i < totalVehiculos; i++) {
            if (vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                JOptionPane.showMessageDialog(vehiculoView, vehiculos.get(i).toString());
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
        model.setRowCount(0); // Limpiar la tabla antes de llenarla

        // Filtrar los vehículos según el tipo seleccionado
        for (int i = 0; i < totalVehiculos; i++) {
            Vehiculo vehiculo = vehiculos.get(i);

            // Filtrar por tipo de vehículo
            boolean coincide = false;
            switch (tipoSeleccionado) {
                case "Todos":
                    coincide = true;
                    break;
                case "Autos":
                    if (vehiculo instanceof Auto) coincide = true;
                    break;
                case "Camiones":
                    if (vehiculo instanceof Camion) coincide = true;
                    break;
                case "Motocicletas":
                    if (vehiculo instanceof Motocicleta) coincide = true;
                    break;
            }

            if (coincide) {
                // Agregar el vehículo a la tabla
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

}