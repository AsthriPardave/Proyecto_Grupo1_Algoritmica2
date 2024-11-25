/*package controller;

import view.LoginView;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;
import model.Administrador;

import javax.swing.*;

public class MainController {

    private LoginView loginView;
    private VehiculosView vehiculosView;
    private Administrador administrador; // Usuario administrador


    private RegistroVehiculoView registroVehiculoView;
    private ModalAutoView modalAutoView;
    private ModalCamionView modalCamionView;
    private ModalMotoView modalMotoView;

    private VehiculoController vehiculoController;

    public MainController(
        LoginView loginView,
        VehiculosView vehiculosView,
        RegistroVehiculoView registroVehiculoView,
        ModalAutoView modalAutoView,
        ModalCamionView modalCamionView,
        ModalMotoView modalMotoView
    ) {
        this.loginView = loginView;
        this.vehiculosView = vehiculosView;
        this.registroVehiculoView = registroVehiculoView;
        this.modalAutoView = modalAutoView;
        this.modalCamionView = modalCamionView;
        this.modalMotoView = modalMotoView;

         // Crear el administrador predeterminado
         this.administrador = new Administrador("Juan", "Santiago", "a", "a"); // Usuario: "a", Contraseña: "a"

        initLoginView();
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

                    vehiculosView.setVisible(true); // Mostrar la vista de vehículos
                } else {
                    JOptionPane.showMessageDialog(loginView, "Credenciales incorrectas. Inténtalo de nuevo.");
                }
            }
        });
    }

    private boolean validarCamposLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    private boolean verificarCredenciales(String email, String password) {
        // Credenciales predefinidas del administrador
        String adminEmail = "admin@empresa.com";
        String adminPassword = "admin123";

        return email.equals(adminEmail) && password.equals(adminPassword);
    }
}
*/