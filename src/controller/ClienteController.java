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


    public void start() {
        clientesView.setVisible(true);
        actualizarTablaClientes();
    }

    private void initClienteView() {
        clientesView.getBtnAnhadirCliente().addActionListener(e -> {
            clientesView.setVisible(false);
            registroClienteView.setVisible(true);
        });

        // ==PARA EL CAMBIO ENTRE VISTAS==

        clientesView.getBtnBuscarCliente().addActionListener(e -> buscarCliente());

        clientesView.getBtnVehiculosView().addActionListener(e -> {
            try {
                clientesView.setVisible(false);
                VehiculoController vehiculoController = VehiculoController.getInstance(); // Lanza IOException
                vehiculoController.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(clientesView, "Error al abrir la vista de vehículos: " + ex.getMessage());
            }
        });
        

        clientesView.getBtnReservaView().addActionListener(e -> {
            clientesView.setVisible(false);
            ReservasController reservasController = ReservasController.getInstance();
            reservasController.start();
  
          });
        
        clientesView.getBtnInicio().addActionListener(e -> mostrarInicio());

        //PARA EL CAMBIAR A LA VISTA DE PAGO CONTROLLER (cuando exista)

        clientesView.getBtnPagoOventa().addActionListener(e -> {
            clientesView.setVisible(false);
            PagoController pagoController = PagoController.getInstance();
            pagoController.start();
  
          });

        // ===============================
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

            Cliente cliente = new Cliente(nombres, apellidos, dni, telefono);
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
                    cliente.getApellido(),
                    cliente.getNumero(),
            });
        }
    }
private void mostrarInicio() {
        System.out.println("Mostrando la pantalla de inicio...");
    }
}
