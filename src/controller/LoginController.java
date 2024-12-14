package controller;

import view.LoginView;
import view.DashboardView;
import model.Administrador;

import java.io.IOException;

import javax.swing.JOptionPane;

public class LoginController {

    private LoginView loginView;
    private DashboardView dashboardView;
    private Administrador administrador;

    public LoginController(LoginView loginView, DashboardView dashboardView) {
        this.loginView = loginView;
        this.dashboardView = dashboardView;

        // Crear el administrador con credenciales predeterminadas
        this.administrador = new Administrador("Juan", "Santiago", "admin", "12345");

        initLoginEvents();
    }

    private void initLoginEvents() {
        // Acción para el botón de login
        loginView.getBtnLogin().addActionListener(e -> {
            String email = loginView.getTxtEmail().getText();
            String password = loginView.getTxtContraseña().getText();

            if (validarCampos(email, password)) {
                if (autenticarAdministrador(email, password)) {
                    JOptionPane.showMessageDialog(loginView, "Login exitoso. ¡Bienvenido, " + administrador.getNombre() + "!");
                    loginView.setVisible(false); // Ocultar la vista de login

                    try {
                        // Iniciar el DashboardController con los controladores necesarios
                        VehiculoController vehiculoController = VehiculoController.getInstance();
                        ReservasController reservasController = ReservasController.getInstance();
                        ClienteController clienteController = ClienteController.getInstance();
                        PagoController pagoController = PagoController.getInstance();
                        new DashboardController(dashboardView, vehiculoController, reservasController, clienteController, pagoController);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(loginView, "Error al inicializar el sistema: " + ex.getMessage());
                        loginView.setVisible(true); // Volver al login en caso de error
                    }
                } else {
                    JOptionPane.showMessageDialog(loginView, "Credenciales incorrectas. Inténtalo de nuevo.");
                }
            }
        });
    }
    private boolean validarCampos(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    private boolean autenticarAdministrador(String email, String password) {
        // Comparar las credenciales con las del administrador
        return administrador.getEmail().equals(email) && administrador.getClaveAcceso().equals(password);
    }
}
