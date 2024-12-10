package controller;

import model.Cliente;
import model.FileManager;
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
        // Configurar eventos
        clientesView.getBtnAnhadirCliente().addActionListener(e -> agregarCliente());
        clientesView.getBtnBuscarCliente().addActionListener(e -> buscarCliente());
        clientesView.getJComboBox().addActionListener(e -> filtrarClientes());
        actualizarTablaClientes(); // Mostrar clientes al iniciar
    }

    private void agregarCliente() {
        try {
            String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente:");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
            String email = JOptionPane.showInputDialog("Ingrese el email del cliente:");
            String numero = JOptionPane.showInputDialog("Ingrese el número de teléfono del cliente:");

            if (dni == null || nombre == null || apellidos == null || email == null || numero == null) {
                JOptionPane.showMessageDialog(clientesView, "Datos incompletos. No se agregó el cliente.");
                return;
            }

            Cliente cliente = new Cliente(nombre, apellidos, email, dni, numero);
            clientes.add(cliente);

            //Insertando linea de codigo para el Clientes.txt
            FileManager.escribirCliente(clientes); // Guardar lista actualizada

            actualizarTablaClientes();
            JOptionPane.showMessageDialog(clientesView, "Cliente agregado con éxito.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientesView, "Error al agregar cliente: " + ex.getMessage());
        }
    }

    private void buscarCliente() {
        String dni = clientesView.getTxtBuscarCliente().getText();

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
            // No hay tipos definidos para clientes; se filtran todos
            if (tipoSeleccionado.equals("Todos")) {
                model.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido()});
            }
        }
    }

    private void actualizarTablaClientes() {
        DefaultTableModel model = (DefaultTableModel) clientesView.getjTable().getModel();
        model.setRowCount(0); // Limpiar tabla

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido()});
        }
    }

    public void start() {
        clientesView.setVisible(true);
        actualizarTablaClientes();
    }
}
