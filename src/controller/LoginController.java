/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;
import view.RegistroView;

/**
 *
 * @author HP
 */
public class LoginController {
    LoginView frame;

    public LoginController(LoginView fr) {
        this.frame = fr;
        this.frame.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroView registro = new RegistroView();
                RegistroController controlador = new RegistroController(registro);
                frame.setVisible(false);
                controlador.run();
                
            }
        });
    }
    
    public void run(){
        this.frame.setVisible(true);
    }
}
