package controller;

import model.Trabajadores;
import view.TrabajadoresView;
import view.RegistroTrabajadorView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import view.VehiculosView;

public class TrabajadoresController {
  private static TrabajadoresController instance;


  private TrabajadoresView trabajadorView;
  private boolean isTrabajadorViewInitialized = false;
  private RegistroTrabajadorView registroTrabajadorView;
  private boolean isRegistroTrabajadorViewInitialized = false;

  public ArrayList<Trabajadores> trabajadores;
  //private int totalTrabajadores;

  
  public static TrabajadoresController getInstance() {
    if ( instance == null ) 
      instance = new TrabajadoresController ();


    return instance;
  }

  private TrabajadoresController () {
    this.trabajadorView = new TrabajadoresView();
    this.registroTrabajadorView = new RegistroTrabajadorView();
    this.trabajadores = new ArrayList<>();
    //this.totalTrabajadores = 0;

    trabajadores.add(new Trabajadores("Juan", "Santiago", 
              "a", "a", "fecha", "12342314", "Administrador"));
    actualizarTablaTrabajadores();


  }

  public void start () {
    instance.initTrabajadorView();
    instance.initRegistroTrabajadorView();
    trabajadorView.setVisible(true);
  }
  
  private void initTrabajadorView () {
    if (isTrabajadorViewInitialized) return; // Evita múltiples inicializaciones
    isTrabajadorViewInitialized = true;

    trabajadorView.getBtnAnhadirTrabajador().addActionListener ( e -> {
      trabajadorView.setVisible(false);
      registroTrabajadorView.setVisible(true);
    });

    trabajadorView.getBtnBuscarTrabajador().addActionListener ( e -> buscarTrabajador() );
    trabajadorView.getJComboBox().addActionListener ( e -> filtrarTrabajador() );

    trabajadorView.getBtnVehiculosView().addActionListener ( e -> {
      trabajadorView.setVisible(false);
      
      VehiculoController vehiculoController = VehiculoController.getInstance();
      vehiculoController.start();
      

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
  private void initRegistroTrabajadorView() {
    if (isRegistroTrabajadorViewInitialized) return; // Evita inicializaciones múltiples
      isRegistroTrabajadorViewInitialized = true;

    registroTrabajadorView.getBtnRegister().addActionListener(e -> {
        try {
          String nombre = registroTrabajadorView.getTxtNombre().getText();
          String apellido = registroTrabajadorView.getTxtApellido().getText();
          String email = registroTrabajadorView.getTxtCorreo().getText();
          String clave = registroTrabajadorView.getTxtContrasenha().getText();
          String dni = registroTrabajadorView.getTxtFechaNacimiento().getText();
          String fechaNacimiento = registroTrabajadorView.getTxtDNI().getText();
          String tipoTrabajador = (String) registroTrabajadorView.getJComboBox().getSelectedItem();

          for (int i = 0; i < trabajadores.size(); i++) {
              if (trabajadores.get(i).getDni().equals(dni)) {
                  throw new Exception("No se puede registrar otra persona con el mismo DNI");
              }
              System.out.println("llega");
          }

          Trabajadores trabajador = new Trabajadores( nombre, apellido, email, clave, fechaNacimiento, dni, tipoTrabajador);
          trabajadores.add(trabajador);
          //totalTrabajadores++;

          actualizarTablaTrabajadores();

          registroTrabajadorView.setVisible(false);
          trabajadorView.setVisible(true);
          JOptionPane.showMessageDialog(trabajadorView, "Trabajador registrado con exito.");

        } catch ( Exception ex ) {
          JOptionPane.showMessageDialog( registroTrabajadorView, "Error al registrar trabajador: " + ex.getMessage());
          
        }

    });

    registroTrabajadorView.getBtnCancelarRegister().addActionListener(e -> {
        registroTrabajadorView.setVisible(false);
        trabajadorView.setVisible(true);
    });

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
