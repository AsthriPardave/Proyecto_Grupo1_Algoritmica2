package view;

import controller.ClienteController;
import controller.ReservaController;
import model.Cliente;
import model.Reserva;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {
    private ClienteController clienteController;
    private ReservaController reservaController;
    private Vehiculo[] flota; // La flota de vehículos disponibles
    private Cliente cliente;

    private JTextArea vehiculosDisponiblesArea;
    private JTextField vehiculoIDField;
    private JTextField diasField;

    public ClienteView(ClienteController clienteController, ReservaController reservaController, Cliente cliente, Vehiculo[] flota) {
        this.clienteController = clienteController;
        this.reservaController = reservaController;
        this.cliente = cliente;
        this.flota = flota; // Inicializa la flota en el constructor

        setTitle("Cliente - Realizar Reserva");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para ver vehículos disponibles
        vehiculosDisponiblesArea = new JTextArea(10, 30);
        vehiculosDisponiblesArea.setEditable(false);
        JButton verVehiculosButton = new JButton("Ver Vehículos Disponibles");
        verVehiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verVehiculosDisponibles();
            }
        });

        // Panel de reserva
        JPanel reservaPanel = new JPanel();
        reservaPanel.setLayout(new GridLayout(3, 2));
        reservaPanel.add(new JLabel("ID Vehículo (Matrícula):"));
        vehiculoIDField = new JTextField();
        reservaPanel.add(vehiculoIDField);
        reservaPanel.add(new JLabel("Días de Reserva:"));
        diasField = new JTextField();
        reservaPanel.add(diasField);
        
        JButton reservarButton = new JButton("Realizar Reserva");
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarReserva();
            }
        });

        // Agregar componentes al frame
        add(new JScrollPane(vehiculosDisponiblesArea), BorderLayout.NORTH);
        add(verVehiculosButton, BorderLayout.CENTER);
        add(reservaPanel, BorderLayout.SOUTH);
        add(reservarButton, BorderLayout.SOUTH);
    }

    // Muestra la lista de vehículos disponibles en el área de texto
    private void verVehiculosDisponibles() {
        vehiculosDisponiblesArea.setText(""); // Limpiar el área de texto antes de mostrar
        Vehiculo[] disponibles = clienteController.verVehiculosDisponibles(flota);
        for (Vehiculo vehiculo : disponibles) {
            vehiculosDisponiblesArea.append(vehiculo.toString() + "\n");
        }
    }

    // Realiza una reserva para el cliente
    private void realizarReserva() {
        try {
            int dias = Integer.parseInt(diasField.getText()); // Convertir los días a entero
            Vehiculo vehiculo = buscarVehiculoPorID(vehiculoIDField.getText()); // Buscar el vehículo por matrícula

            if (vehiculo != null) {
                Reserva reserva = reservaController.crearReserva(cliente, vehiculo, dias);
                if (reserva != null) {
                    JOptionPane.showMessageDialog(this, "Reserva realizada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la reserva.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vehículo no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido de días.");
        }
    }

    // Método auxiliar para buscar el vehículo por su matrícula (ID)
    private Vehiculo buscarVehiculoPorID(String id) {
        // Usa la flota proporcionada para buscar el vehículo
        for (Vehiculo v : flota) {
            if (v.getMatricula().equals(id)) {
                return v;
            }
        }
        return null; // Si no encuentra el vehículo
    }
}
