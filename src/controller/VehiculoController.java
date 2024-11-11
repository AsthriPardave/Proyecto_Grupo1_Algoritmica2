package controller;

import model.Vehiculo;
import model.ArregloVehiculo;
import view.VehiculosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class VehiculoController {
    private VehiculosView view;
    private ArregloVehiculo arregloVehiculo;

    public VehiculoController(VehiculosView view, ArregloVehiculo arregloVehiculo) {
        this.view = view;
        this.arregloVehiculo = arregloVehiculo;

        // Inicializar la tabla con los datos de vehículos
        cargarTablaVehiculos();

        // Configurar listeners en los botones
        configurarListeners();
    }

    // Método para cargar datos en la tabla
    private void cargarTablaVehiculos() {
        JTable jTable1 = (JTable) obtenerComponente(view, "jTable1");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla

        // Cambiar List<Vehiculo> a Vehiculo[]
        Vehiculo[] listaVehiculos = arregloVehiculo.getListaVehiculos();
        for (Vehiculo vehiculo : listaVehiculos) {
            model.addRow(new Object[]{
                vehiculo.getMatricula(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPrecioPorDia(),
                vehiculo.isDisponible()
            });
        }
    }

    // Método para configurar los listeners de los botones
    private void configurarListeners() {
        JButton jButton1 = (JButton) obtenerComponente(view, "jButton1");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirVehiculo();
            }
        });

        JButton jButton2 = (JButton) obtenerComponente(view, "jButton2");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarVehiculo();
            }
        });
    }

    // Método para añadir un vehículo
    private void añadirVehiculo() {
        String matricula = JOptionPane.showInputDialog(view, "Ingrese matrícula:");
        String marca = JOptionPane.showInputDialog(view, "Ingrese marca:");
        String modelo = JOptionPane.showInputDialog(view, "Ingrese modelo:");
        float precioPorDia = Float.parseFloat(JOptionPane.showInputDialog(view, "Ingrese precio por día:"));
        boolean disponible = true; // Puede ser ingresado como un valor booleano también

        Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, precioPorDia, disponible);
        arregloVehiculo.agregar(nuevoVehiculo);

        // Actualizar la tabla después de añadir el vehículo
        cargarTablaVehiculos();
    }

    // Método para buscar un vehículo
    private void buscarVehiculo() {
        JTextField jTextField1 = (JTextField) obtenerComponente(view, "jTextField1");
        String matricula = jTextField1.getText();
        Vehiculo vehiculo = arregloVehiculo.buscar(matricula);

        JTable jTable1 = (JTable) obtenerComponente(view, "jTable1");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (vehiculo != null) {
            model.addRow(new Object[]{
                vehiculo.getMatricula(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPrecioPorDia(),
                vehiculo.isDisponible()
            });
        } else {
            JOptionPane.showMessageDialog(view, "Vehículo no encontrado.");
        }
    }

    // Método para obtener un componente privado mediante reflexión
    private Object obtenerComponente(Object objeto, String nombreComponente) {
        try {
            Field campo = objeto.getClass().getDeclaredField(nombreComponente);
            campo.setAccessible(true); // Permitir acceso a campos privados
            return campo.get(objeto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
