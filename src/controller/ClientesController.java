package controller;

import model.Cliente;
import view.ClientesView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ClientesController {

    private ClientesView clientesView;
    private ArrayList<Cliente> clientes;

    public ClientesController(ClientesView clientesView) {
        this.clientesView = clientesView;
        this.clientes = new ArrayList<>();
        initClientesView();
    }

    private void initClientesView() {
        // Inicializar eventos de la vista
        clientesView.getBtnAnhadirTrabajador().addActionListener(e -> agregarCliente());
        clientesView.getBtnBuscarTrabajador().addActionListener(e -> buscarCliente());
        clientesView.getJComboBox().addActionListener(e -> filtrarClientes());
    }

    private void agregarCliente() {
        try {
            String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente:");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
            String email = JOptionPane.showInputDialog("Ingrese el email del cliente:");
            String claveAcceso = JOptionPane.showInputDialog("Ingrese la clave de acceso del cliente:");
            String tipo = (String) JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de cliente:",
                    "Tipo de Cliente",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Administrador", "Contador", "Limpieza", "Cliente"},
                    "Cliente");

            if (dni == null || nombre == null || apellidos == null || email == null || claveAcceso == null || tipo == null) {
                JOptionPane.showMessageDialog(clientesView, "Datos incompletos. No se agregó el cliente.");
                return;
            }

            Cliente cliente = new Cliente(nombre, apellidos, email, claveAcceso, dni, tipo);
            clientes.add(cliente);

            actualizarTablaClientes();
            JOptionPane.showMessageDialog(clientesView, "Cliente agregado con éxito.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientesView, "Error al agregar cliente: " + ex.getMessage());
        }
    }

    private void buscarCliente() {
        String dni = clientesView.getTxtBuscarTrabajador().getText();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(clientesView, "Ingrese un DNI para buscar.");
            return;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                JOptionPane.showMessageDialog(clientesView, cliente.toString());
                return;
            }
        }

        JOptionPane.showMessageDialog(clientesView, "Cliente no encontrado.");
    }

    private void filtrarClientes() {
        String tipoSeleccionado = (String) clientesView.getJComboBox().getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) clientesView.getjTable().getModel();
        model.setRowCount(0);

        for (Cliente cliente : clientes) {
            if (tipoSeleccionado.equals("Todos") || cliente.getTipo().equals(tipoSeleccionado)) {
                model.addRow(new Object[]{cliente.getDni(), cliente.getTipo(), cliente.getNombre(), cliente.getApellidos()});
            }
        }
    }

    private void actualizarTablaClientes() {
        DefaultTableModel model = (DefaultTableModel) clientesView.getjTable().getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{cliente.getDni(), cliente.getTipo(), cliente.getNombre(), cliente.getApellidos()});
        }
    }

    public void start() {
        clientesView.setVisible(true);
        actualizarTablaClientes(); // Mostrar los clientes al iniciar la vista
    }
}
