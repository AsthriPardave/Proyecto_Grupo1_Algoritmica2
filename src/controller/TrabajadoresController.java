package controller;

import java.io.IOException;
import model.Trabajadores;
import view.ClientesView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.VehiculosView;

public class TrabajadoresController {
  private static TrabajadoresController instance;


  private ClientesView trabajadorView;
  private boolean isTrabajadorViewInitialized = false;
  private boolean isRegistroTrabajadorViewInitialized = false;

  public ArrayList<Trabajadores> trabajadores;
  //private int totalTrabajadores;

  
  public static TrabajadoresController getInstance() {
    if ( instance == null ) 
      instance = new TrabajadoresController ();


    return instance;
  }

  private TrabajadoresController () {
    this.trabajadorView = new ClientesView();
    this.trabajadores = new ArrayList<>();
    //this.totalTrabajadores = 0;

    trabajadores.add(new Trabajadores("Juan", "Santiago", 
              "a", "a", "fecha", "12342314", "Administrador"));
    actualizarTablaTrabajadores();


  }

  public void start () {
    instance.initTrabajadorView();

    trabajadorView.setVisible(true);
  }
  
  private void initTrabajadorView () {
    if (isTrabajadorViewInitialized) return; // Evita múltiples inicializaciones
    isTrabajadorViewInitialized = true;

    trabajadorView.getBtnAnhadirTrabajador().addActionListener ( e -> {
      trabajadorView.setVisible(false);
    });

    trabajadorView.getBtnBuscarTrabajador().addActionListener ( e -> buscarTrabajador() );
    trabajadorView.getJComboBox().addActionListener ( e -> filtrarTrabajador() );

    trabajadorView.getBtnVehiculosView().addActionListener ( e -> {
      trabajadorView.setVisible(false);
      
      VehiculoController vehiculoController;
        try {
            vehiculoController = VehiculoController.getInstance();
            vehiculoController.start();
        } catch (IOException ex) {
            Logger.getLogger(TrabajadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    });
    trabajadorView.getBtnReservaView().addActionListener(e -> {
          trabajadorView.setVisible(false);
          ReservasController reservasController = ReservasController.getInstance();
          reservasController.start();
    });

   
  }

  private void buscarTrabajador() {

    String dni = (String) trabajadorView.getTxtBuscarTrabajador().getText();
    for ( int i = 0; i < trabajadores.size(); i++ ) {
      if ( trabajadores.get(i).getDni().equalsIgnoreCase(dni) ){
        JOptionPane.showMessageDialog(trabajadorView, trabajadores.get(i).toString());
        return;
      }
    }
    JOptionPane.showMessageDialog(trabajadorView, "Trabajador no encontrado.");

  }
  private void filtrarTrabajador() {
    String tipoTrabajador = (String) trabajadorView.getJComboBox().getSelectedItem();
    DefaultTableModel model = (DefaultTableModel) trabajadorView.getjTable().getModel();
    model.setRowCount(0);

    for ( int i = 0; i < trabajadores.size(); i++ ) {
      Trabajadores trabajador = trabajadores.get(i);

      boolean coincide = false;
      if ( trabajador.getTipoTrabajador().equals(tipoTrabajador) || 
          "Todos".equalsIgnoreCase(tipoTrabajador))
        coincide = true;
      
      if ( coincide ) {
        model.addRow(new Object[]{
              trabajador.getDni(),
              trabajador.getTipoTrabajador(),
              trabajador.getNombre(),
              trabajador.getApellido(),
        });
      }

    }
  }
  
  private void actualizarTablaTrabajadores () {
    DefaultTableModel model = (DefaultTableModel) trabajadorView.getjTable().getModel();
    model.setRowCount(0);

    for ( int i = 0; i < trabajadores.size(); i++ ) {
      Trabajadores trabajador = trabajadores.get(i);
      model.addRow(new Object[]{
              trabajador.getDni(),
              trabajador.getTipoTrabajador(),
              trabajador.getNombre(),
              trabajador.getApellido(),
      });
    }
  }



}

