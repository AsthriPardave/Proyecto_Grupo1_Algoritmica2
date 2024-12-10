package controller;

import model.Cliente;
import view.ClientesView;
import view.RegistroClienteView;
import model.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private static ClienteController instance;
    private ClientesView clientesView;
    private RegistroClienteView registroClienteView;

    private VehiculoController vehiculoController;
    private ReservasController reservasController;

    private List<Cliente> clientes;

    private ClienteController() {
        this.clientesView = new ClientesView();
        this.registroClienteView = new RegistroClienteView();

        try {
            this.clientes = FileManager.leerClientes();
        } catch (IOException e) {
            this.clientes = new ArrayList<>();
        }

        initClienteView();
        initRegistroClienteView();
    }

    public static ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    public void setDependencies(VehiculoController vehiculoController, ReservasController reservasController) {
        this.vehiculoController = vehiculoController;
        this.reservasController = reservasController;
    }

    public void start() {
        clientesView.setVisible(true);
        actualizarTablaClientes();
    }

    private void initClienteView() {
        clientesView.getBtnAnhadirCliente().addActionListener(e -> {
            clientesView.setVisible(false);
            registroClienteView.setVisible(true);
        });

        clientesView.getBtnBuscarCliente().addActionListener(e -> buscarCliente());

        clientesView.getBtnVehiculosView().addActionListener(e -> mostrarVehiculosView());
        clientesView.getBtnReservaView().addActionListener(e -> mostrarReservasView());
        clientesView.getBtnInicio().addActionListener(e -> mostrarInicio());
        clientesView.getBtnPago().addActionListener(e -> mostrarPago());
    }

    private void initRegistroClienteView() {
        registroClienteView.getBtnRegister().addActionListener(e -> registrarCliente());
        registroClienteView.getBtnCancelarRegister().addActionListener(e -> {
            registroClienteView.setVisible(false);
            clientesView.setVisible(true);
        });
    }

    private void registrarCliente() {
        try {
            String dni = registroClienteView.getTxtDNI().getText();
            String nombres = registroClienteView.getTxtNombres().getText();
            String apellidos = registroClienteView.getTxtApellido().getText();
            String telefono = registroClienteView.getTxtTelefono().getText();

            if (dni.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(registroClienteView, "Todos los campos son obligatorios.");
                return;
            }

            Cliente cliente = new Cliente(nombres, apellidos, telefono, dni, telefono);
            clientes.add(cliente);
            FileManager.escribirCliente(clientes);

            JOptionPane.showMessageDialog(registroClienteView, "Cliente registrado exitosamente.");
            registroClienteView.setVisible(false);
            clientesView.setVisible(true);
            actualizarTablaClientes();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(registroClienteView, "Error al registrar cliente: " + ex.getMessage());
        }
    }

    private void buscarCliente() {
        String dni = clientesView.getTxtBuscarCliente().getText();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(clientesView, "Ingrese un DNI para buscar.");
            return;
        }

        Cliente cliente = clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            JOptionPane.showMessageDialog(clientesView, cliente.toString());
        } else {
            JOptionPane.showMessageDialog(clientesView, "Cliente no encontrado.");
        }
    }

    private void actualizarTablaClientes() {
        DefaultTableModel model = (DefaultTableModel) clientesView.getjTable().getModel();
        model.setRowCount(0);

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{
                    cliente.getDni(),
                    cliente.getNombre(),
                    cliente.getApellido()
            });
        }
    }

    private void mostrarVehiculosView() {
        if (vehiculoController != null) {
            vehiculoController.start();
        }
        clientesView.setVisible(false);
    }

    private void mostrarReservasView() {
        if (reservasController != null) {
            reservasController.start();
        }
        clientesView.setVisible(false);
    }

    private void mostrarInicio() {
        System.out.println("Mostrando la pantalla de inicio...");
    }

    private void mostrarPago() {
        System.out.println("Mostrando el módulo de pagos...");
    }
}
