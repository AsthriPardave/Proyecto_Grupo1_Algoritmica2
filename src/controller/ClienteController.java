/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Vehiculo;
import view.ClientesView;
import view.RegistroClienteView;

/**
 *
 * @author HP
 */
public class ClienteController {

    private static ClienteController instance;
    private ClientesView clienteView;
    private RegistroClienteView registroClienteView;
    private VehiculoController vehiculoController;
    private ReservasController reservasController;

    public ClienteController() {
        this.clienteView = new ClientesView();
        this.registroClienteView = new RegistroClienteView();

            initClienteView();
        }
    
    public void start () {
      instance.initClienteView();
      //instance.initRegistroClienteView();

      clienteView.setVisible(true);
    }

    public static ClienteController getInstance() throws IOException {
      if ( instance == null ) 
        instance = new ClienteController ();


      return instance;
    }
    
    private ArrayList<Vehiculo> vehiculos;
    
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    private void initClienteView() {
        clienteView.setVisible(true);

        clienteView.getBtnVehiculosView().addActionListener(e -> mostrarVehiculosView());
        clienteView.getBtnReservaView().addActionListener(e -> mostrarReservasView());
        clienteView.getBtnInicio().addActionListener(e -> mostrarInicio());
        clienteView.getBtnPago().addActionListener(e -> mostrarPago());
    }
    
    private void mostrarVehiculosView() {
        vehiculoController.start(); 
        clienteView.setVisible(false); 
    }
    
    private void mostrarReservasView() {
        vehiculoController.start(); 
        clienteView.setVisible(false);
    }

    private void mostrarInicio() {
        // Aquí puedes implementar la lógica para el botón "Inicio"
        System.out.println("Mostrando la pantalla de inicio...");
    }

    private void mostrarPago() {
        // Aquí puedes implementar la lógica para el módulo de pagos
        System.out.println("Mostrando el módulo de pagos...");
    }
}
