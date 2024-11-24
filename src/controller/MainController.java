package controller;

import view.LoginView;
import view.RegistroView;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;
import model.Trabajadores;

import javax.swing.*;


public class MainController {

    private LoginView loginView;
    private RegistroView registroView;
    private VehiculosView vehiculosView;
    private RegistroVehiculoView registroVehiculoView;
    private ModalAutoView modalAutoView;
    private ModalCamionView modalCamionView;
    private ModalMotoView modalMotoView;

    private VehiculoController vehiculoController;

    private TrabajadoresController trabajadoresController;
    //private Persona[] usuarios; // Arreglo para almacenar usuarios registrados
    //private int totalUsuarios; // Contador para usuarios registrados
    private final int MAX_USUARIOS = 100; // Capacidad máxima de usuarios

    public MainController(LoginView loginView, RegistroView registroView, VehiculosView vehiculosView,
                          RegistroVehiculoView registroVehiculoView, ModalAutoView modalAutoView,
                          ModalCamionView modalCamionView, ModalMotoView modalMotoView) {
        this.loginView = loginView;
        this.registroView = registroView;
        this.vehiculosView = vehiculosView;
        this.registroVehiculoView = registroVehiculoView;
        this.modalAutoView = modalAutoView;
        this.modalCamionView = modalCamionView;
        this.modalMotoView = modalMotoView;
        //this.usuarios = new Persona[MAX_USUARIOS];
        //this.totalUsuarios = 1;
        trabajadoresController = TrabajadoresController.getInstance();



        initLoginView();
        initRegistroView();
    }

    // Inicializar eventos en LoginView
    private void initLoginView() {
        loginView.getBtnLogin().addActionListener(e -> {
            String email = loginView.getTxtEmail().getText();
            String password = loginView.getTxtContraseña().getText();

            if (validarCamposLogin(email, password)) {
                if (verificarCredenciales(email, password)) {
                    JOptionPane.showMessageDialog(loginView, "Login exitoso. ¡Bienvenido!");
                    loginView.setVisible(false); // Ocultar la vista de login

                    // Patron Singleton
                    vehiculoController = VehiculoController.getInstance();
                    vehiculoController.start();

                } else {
                    JOptionPane.showMessageDialog(loginView, "Credenciales incorrectas. Inténtalo de nuevo.");
                }
            }
        });

        loginView.getBtnRegister().addActionListener(e -> {
            loginView.setVisible(false);
            registroView.setVisible(true);
        });
    }

    // Inicializar eventos en RegistroView
    private void initRegistroView() {
        registroView.getBtnRegister().addActionListener(e -> {
            String nombre = registroView.getTxtNombres().getText();
            String apellidos = registroView.getTxtApellidos().getText();
            String email = registroView.getTxtEmail().getText();
            String password = registroView.getTxtContraseña().getText();

            if (validarCamposRegistro(nombre, apellidos, email, password)) {
                if (registrarUsuario(nombre, apellidos, email, password)) {
                    JOptionPane.showMessageDialog(registroView, "Registro exitoso. Ahora puedes iniciar sesión.");
                    registroView.setVisible(false);
                    loginView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(registroView, "El email ya está registrado.");
                }
            }
        });

        registroView.getBtnLogin().addActionListener(e -> {
            registroView.setVisible(false);
            loginView.setVisible(true);
        });
    }

    private boolean validarCamposLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    private boolean validarCamposRegistro(String nombre, String apellidos, String email, String password) {
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(registroView, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    private boolean verificarCredenciales(String email, String password) {
        for (int i = 0; i < trabajadoresController.trabajadores.size(); i++) {
            if (trabajadoresController.trabajadores.get(i).getEmail().equals(email) && trabajadoresController.trabajadores.get(i).getClaveAcceso().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean registrarUsuario(String nombre, String apellidos, String email, String password) {
        if (trabajadoresController.trabajadores.size() > 200) {
            JOptionPane.showMessageDialog(registroView, "No se pueden registrar más usuarios.");
            return false;
        }

        for (int i = 0; i < trabajadoresController.trabajadores.size(); i++) {
            if (trabajadoresController.trabajadores.get(i).getEmail().equals(email)) {
                return false;
            }
        }
        trabajadoresController.trabajadores.add(new Trabajadores
            (nombre, apellidos, email, password, "NINGUNO", "NINGUNO", "NINGUNO" ));

        //usuarios[totalUsuarios++] = new Administrador(nombre, apellidos, email, password);
        return true;
    }
}
