package view;

import controller.AdministradorController;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorView extends JFrame {
    private AdministradorController adminController;

    // Componentes de la interfaz
    private JTextField matriculaField;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JCheckBox disponibleCheckBox;
    private JTextArea flotaTextArea;

    public AdministradorView(AdministradorController adminController) {
        this.adminController = adminController;
        setTitle("Administrador - Gestión de Vehículos");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de ingreso de datos para agregar vehículos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        inputPanel.add(matriculaField);
        inputPanel.add(new JLabel("Marca:"));
        marcaField = new JTextField();
        inputPanel.add(marcaField);
        inputPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        inputPanel.add(modeloField);
        inputPanel.add(new JLabel("Precio por Día:"));
        precioField = new JTextField();
        inputPanel.add(precioField);
        inputPanel.add(new JLabel("Disponible:"));
        disponibleCheckBox = new JCheckBox();
        inputPanel.add(disponibleCheckBox);

        JButton agregarButton = new JButton("Agregar Vehículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        JButton verFlotaButton = new JButton("Ver Flota de Vehículos");
        verFlotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verFlota();
            }
        });

        // Área de texto para mostrar la flota de vehículos
        flotaTextArea = new JTextArea(10, 30);
        flotaTextArea.setEditable(false);

        // Agregar componentes al frame
        add(inputPanel, BorderLayout.NORTH);
        add(agregarButton, BorderLayout.CENTER);
        add(verFlotaButton, BorderLayout.SOUTH);
        add(new JScrollPane(flotaTextArea), BorderLayout.EAST);
    }

    private void agregarVehiculo() {
        try {
            // Captura de datos desde los campos de la interfaz
            String matricula = matriculaField.getText();
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            float precioPorDia = Float.parseFloat(precioField.getText());
            boolean disponible = disponibleCheckBox.isSelected();

            // Llamada al controlador para agregar el vehículo usando los datos ingresados
            if (adminController.agregarVehiculo(matricula, marca, modelo, precioPorDia, disponible)) {
                JOptionPane.showMessageDialog(this, "Vehículo agregado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "El vehículo ya existe o es inválido.");
            }

            // Limpiar los campos después de agregar
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número.");
        }
    }

    private void verFlota() {
        flotaTextArea.setText(""); // Limpiar el área de texto antes de mostrar
        Vehiculo[] flota = adminController.obtenerFlota();
        for (Vehiculo vehiculo : flota) {
            flotaTextArea.append(vehiculo.toString() + "\n");
        }
    }

    private void limpiarCampos() {
        matriculaField.setText("");
        marcaField.setText("");
        modeloField.setText("");
        precioField.setText("");
        disponibleCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        // Crear controlador y vista de administrador
        AdministradorController adminController = new AdministradorController();
        AdministradorView adminView = new AdministradorView(adminController);
        adminView.setVisible(true);
    }
}
