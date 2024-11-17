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
public class RegistroController {
    RegistroView frame;

    public RegistroController(RegistroView fr) {
        this.frame = fr;
        this.frame.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView login = new LoginView();
                LoginController controlador = new LoginController(login);
                frame.setVisible(false);
                controlador.run();
                
            }
        });
    }
    
    public void run(){
        this.frame.setVisible(true);
    }
    
}
