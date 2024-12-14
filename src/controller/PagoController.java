package controller;

import model.*;
import view.PagosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PagoController {
    private static PagoController instance;

    private PagosView pagosView;
    private ArrayList<Reserva> reservas;
    private ArrayList<Pago> pagos;

    private boolean initialized;

    private PagoController() {
        this.pagosView = new PagosView();
        try {
            this.reservas = new ArrayList<>(FileManager.leerReservas(VehiculoController.getInstance().getVehiculos(), FileManager.leerClientes()));
            this.pagos = new ArrayList<>(FileManager.leerPagos());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar reservas o pagos: " + e.getMessage());
            this.reservas = new ArrayList<>();
            this.pagos = new ArrayList<>();
        }
    }

    public static PagoController getInstance() {
        if (instance == null) {
            instance = new PagoController();
        }
        return instance;
    }

    public void start() {
        if (!initialized) {
            initView();
            initialized = true;
        }
        cargarReservasEnComboBox();
        actualizarTablaPagos();
        pagosView.setVisible(true);
    }

    private void initView() {
        pagosView.getBtnRegisterPago().addActionListener(e -> registrarPago());
        pagosView.getBtnCancelarRegisterPago().addActionListener(e -> cancelarPago());
        pagosView.getjButton2().addActionListener(e -> buscarReserva());

        // Navegación a otras vistas
        pagosView.getBtnReservasView().addActionListener(e -> {
            pagosView.setVisible(false);
            ReservasController reservasController = ReservasController.getInstance();
            reservasController.start();
        });

        pagosView.getBtnTrabajadoresView().addActionListener(e -> {
            pagosView.setVisible(false);
            ClienteController clienteController = ClienteController.getInstance();
            clienteController.start();
        });

        pagosView.getBtnVehiculosView().addActionListener(e -> {
            pagosView.setVisible(false);
            try {
                VehiculoController vehiculoController = VehiculoController.getInstance();
                vehiculoController.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(pagosView, "Error al abrir la vista de vehículos: " + ex.getMessage());
            }
        });
    }

    private void registrarPago() {
        try {
            String idReserva = (String) pagosView.getComboboxIDreserva().getSelectedItem();
            if (idReserva == null || idReserva.equals("ID reserva")) {
                throw new Exception("Seleccione una reserva válida.");
            }

            String metodoPago = (String) pagosView.getComboboxMetodoPago().getSelectedItem();
            if (metodoPago == null) {
                throw new Exception("Seleccione un método de pago.");
            }

            Date fechaPago = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            pagosView.getTxtFechaPago().setText(dateFormat.format(fechaPago));

            // Buscar reserva asociada
            Reserva reserva = reservas.stream()
                    .filter(r -> r.getId().equals(idReserva))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Reserva no encontrada"));

            if (!reserva.getVehiculo().isDisponible()) {
                throw new Exception("El vehículo ya no está disponible.");
            }

            // Calcular el monto del pago
            float monto = reserva.getDiasReservados() * reserva.getVehiculo().getPrecioPorDia();

            // Verificar si ya existe un pago registrado para esta reserva
            if (pagos.stream().anyMatch(p -> p.getIdReserva().equals(idReserva))) {
                throw new Exception("Ya existe un pago registrado para esta reserva.");
            }

            // Crear el pago
            Pago pago = new Pago(idReserva, monto, fechaPago, metodoPago);

            // Guardar el pago en archivo
            FileManager.escribirPago(pago);
            pagos.add(pago);

            // Actualizar la disponibilidad del vehículo
            reserva.getVehiculo().setDisponible(false);
            FileManager.escribirVehiculo(VehiculoController.getInstance().getVehiculos());

            // Actualizar la tabla de pagos
            actualizarTablaPagos();
            JOptionPane.showMessageDialog(pagosView, "Pago registrado exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pagosView, "Error al registrar el pago: " + ex.getMessage());
        }
    }

    private void cancelarPago() {
        pagosView.setVisible(false);
        ReservasController reservasController = ReservasController.getInstance();
        reservasController.start();
    }

    private void buscarReserva() {
        try {
            String idBusqueda = pagosView.getTxtBuscarVehiculo().getText();

            Reserva reserva = reservas.stream()
                    .filter(r -> r.getId().equals(idBusqueda))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Reserva no encontrada"));

            JOptionPane.showMessageDialog(pagosView, reserva.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pagosView, "Error al buscar reserva: " + ex.getMessage());
        }
    }

    private void cargarReservasEnComboBox() {
        try {
            // Actualizar la lista de reservas desde el archivo
            reservas = new ArrayList<>(FileManager.leerReservas(
                    VehiculoController.getInstance().getVehiculos(),
                    FileManager.leerClientes()
            ));
    
            // Limpiar y llenar el ComboBox
            JComboBox<String> comboBox = pagosView.getComboboxIDreserva();
            comboBox.removeAllItems();
            comboBox.addItem("ID reserva");
    
            for (Reserva reserva : reservas) {
                if (reserva.getVehiculo().isDisponible()) { // Solo mostrar vehículos disponibles
                    comboBox.addItem(reserva.getId());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(pagosView, "Error al cargar reservas: " + e.getMessage());
        }
    }
    

    private void actualizarTablaPagos() {
        // Sincronizar pagos desde archivo
        pagos = new ArrayList<>(FileManager.leerPagos());
    
        // Obtener el modelo de la tabla y limpiar datos existentes
        DefaultTableModel model = (DefaultTableModel) pagosView.getjTable1().getModel();
        model.setRowCount(0);
    
        // Llenar la tabla con datos de los pagos
        for (Pago pago : pagos) {
            model.addRow(new Object[]{
                    pago.getIdReserva(),
                    pago.getMonto(),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pago.getFechaPago()),
                    pago.getMetodoPago()
            });
        }
    }
    
}
