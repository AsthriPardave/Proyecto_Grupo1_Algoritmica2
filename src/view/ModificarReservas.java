package view;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * Clase ModificarReservas convertida para extender JFrame
 * @author alvarocrak
 */
public class ModificarReservas extends JFrame {

    private JButton btnModificar;
    private JButton btnCancelar;
    private JTextField textIdReserva;
    private JTextField textPago;

    /**
     * Constructor que inicializa los componentes de la ventana
     */
    public ModificarReservas() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setTitle("Modificar Reserva");
    }

    public JTextField getTextIdReserva() {
        return textIdReserva;
    }

    public JTextField getTextPago() {
        return textPago;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * Método que inicializa los componentes de la ventana.
     */
    private void initComponents() {

        // Crear componentes
        btnModificar = new JButton();
        btnCancelar = new JButton();
        textIdReserva = new JTextField();
        textPago = new JTextField();

        var jLabel1 = new javax.swing.JLabel();
        var jLabel2 = new javax.swing.JLabel();
        var jLabel3 = new javax.swing.JLabel();

        // Configuración de etiquetas
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 66, 76));
        jLabel1.setText("MODIFICAR RESERVA");

        jLabel2.setText("ID Reserva:");

        jLabel3.setText("Monto a Pagar:");

        // Configuración de botones
        btnModificar.setBackground(new java.awt.Color(0, 153, 51));
        btnModificar.setFont(new java.awt.Font("IosevkaTerm NFP ExtraBold", 0, 15));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("IosevkaTerm NFM ExtraBold", 0, 15));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");

        // Configuración del layout
        var layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textIdReserva)
                                .addComponent(textPago, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(213, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel1)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnCancelar))
                    .addGap(55, 55, 55))
        );

        pack(); // Ajusta el tamaño de la ventana automáticamente
    }

    /**
     * Método principal para probar la ventana.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ModificarReservas().setVisible(true);
        });
    }
}

