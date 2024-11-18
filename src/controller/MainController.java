package controller;

import view.LoginView;
import view.RegistroView;

import javax.swing.*;
import model.Persona;
import model.Administrador;

public class MainController {

    private LoginView loginView;
    private RegistroView registroView;
    private Persona[] usuarios;
    private int totalUsuarios;
    private final int MAX_USUARIOS = 100;

    public MainController() {
        // Inicializar vistas
        loginView = new LoginView();
        registroView = new RegistroView();

        // Inicializar datos
        usuarios = new Persona[MAX_USUARIOS];
        totalUsuarios = 0;

        // Configurar eventos
        initLoginView();
        initRegistroView();

        // Mostrar la primera vista
        loginView.setVisible(true);
    }

    private void initLoginView() {
        loginView.getBtnRegister().addActionListener(e -> {
            loginView.setVisible(false);
            registroView.setVisible(true);
        });

        loginView.getBtnLogin().addActionListener(e -> {
            String email = loginView.getTxtEmail().getText();
            String password = loginView.getTxtContraseña().getText();

            if (validarCampos(email, password)) {
                if (verificarCredenciales(email, password)) {
                    JOptionPane.showMessageDialog(loginView, "Login exitoso. ¡Bienvenido!");
                } else {
                    JOptionPane.showMessageDialog(loginView, "Credenciales incorrectas.");
                }
            }
        });
    }

    private void initRegistroView() {
        registroView.getBtnLogin().addActionListener(e -> {
            registroView.setVisible(false);
            loginView.setVisible(true);
        });

        registroView.getBtnRegister().addActionListener(e -> {
            String nombre = registroView.getTxtNombres().getText();
            String apellidos = registroView.getTxtApellidos().getText();
            String email = registroView.getTxtEmail().getText();
            String password = registroView.getTxtContraseña().getText();

            if (validarCamposRegistro(nombre, apellidos, email, password)) {
                if (registrarUsuario(nombre, apellidos, email, password)) {
                    JOptionPane.showMessageDialog(registroView, "Registro exitoso. Ahora puedes iniciar sesión.");
                } else {
                    JOptionPane.showMessageDialog(registroView, "El email ya está registrado.");
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

    private boolean validarCamposRegistro(String nombre, String apellidos, String email, String password) {
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(registroView, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    private boolean verificarCredenciales(String email, String password) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getEmail().equals(email) && usuarios[i].getClaveAcceso().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean registrarUsuario(String nombre, String apellidos, String email, String password) {
        if (totalUsuarios >= MAX_USUARIOS) {
            JOptionPane.showMessageDialog(registroView, "No se pueden registrar más usuarios.");
            return false;
        }

        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                return false;
            }
        }

        usuarios[totalUsuarios++] = new Administrador(nombre, apellidos, email, password);
        return true;
    }
}
