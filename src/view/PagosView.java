/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class PagosView extends javax.swing.JFrame {

    /**
     * Creates new form VehiculosView
     */
    public PagosView() {
        initComponents();

        this.setLocationRelativeTo(null); // Centra la ventana
        this.setTitle("Modificar Reserva");
    }


    public JButton getjButton2() {
        return btnBuscarReserva; // Botón de búsqueda
    }

    public JTextField getTxtBuscarVehiculo() {
        return txtBuscarReserva;
    }

    public JTable getjTable1() {
        return jTable1; // Tabla de vehículos
    }

    public JButton getBtnRegisterPago() {
    return btnRegisterPago; // Botón para registrar el pago
}

public JButton getBtnCancelarRegisterPago() {
    return btnCancelarRegisterPago; // Botón para cancelar el registro del pago
}

public JButton getBtnReservasView() {
    return btnReservasView; // Botón para cambiar a la vista de reservas
}

public JButton getBtnVehiculosView() {
    return btnVehiculosView; // Botón para cambiar a la vista de vehículos
}

public JButton getBtnTrabajadoresView() {
    return btnClientesView; // Botón para cambiar a la vista de vehículos
}


public JComboBox<String> getComboboxIDreserva() {
    return comboboxIDreserva; // ComboBox para seleccionar el ID de reserva
}

public JComboBox<String> getComboboxMetodoPago() {
    return comboboxMetodoPago; // ComboBox para seleccionar el método de pago
}

public JTextField getTxtFechaPago() {
    return txtFechaPago; // Campo de texto para mostrar la fecha de pago
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnRegister = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnReservasView = new javax.swing.JButton();
        btnVehiculosView = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnPagoOventa = new javax.swing.JButton();
        btnClientesView = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBuscarReserva = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarReserva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboboxMetodoPago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFechaPago = new javax.swing.JTextField();
        comboboxIDreserva = new javax.swing.JComboBox<>();
        btnRegisterPago = new javax.swing.JButton();
        btnCancelarRegisterPago = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        btnRegister.setBackground(new java.awt.Color(0, 153, 51));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTRAR");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(242, 66, 76));

        btnReservasView.setBackground(new java.awt.Color(242, 66, 76));
        btnReservasView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-reserva-30.png"))); // NOI18N
        btnReservasView.setBorder(null);
        btnReservasView.setBorderPainted(false);
        btnReservasView.setContentAreaFilled(false);
        btnReservasView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasViewActionPerformed(evt);
            }
        });

        btnVehiculosView.setBackground(new java.awt.Color(242, 66, 76));
        btnVehiculosView.setForeground(new java.awt.Color(255, 255, 255));
        btnVehiculosView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-híbrido-30.png"))); // NOI18N
        btnVehiculosView.setBorder(null);
        btnVehiculosView.setBorderPainted(false);
        btnVehiculosView.setContentAreaFilled(false);

        jButton6.setBackground(new java.awt.Color(242, 66, 76));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-diseño-del-tablero-30.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);

        btnPagoOventa.setBackground(new java.awt.Color(242, 66, 76));
        btnPagoOventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pago-30.png"))); // NOI18N
        btnPagoOventa.setToolTipText("");
        btnPagoOventa.setBorder(null);
        btnPagoOventa.setBorderPainted(false);
        btnPagoOventa.setContentAreaFilled(false);
        btnPagoOventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoOventaActionPerformed(evt);
            }
        });

        btnClientesView.setBackground(new java.awt.Color(242, 66, 76));
        btnClientesView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClientesView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cliente-30.png"))); // NOI18N
        btnClientesView.setAutoscrolls(true);
        btnClientesView.setBorder(null);
        btnClientesView.setBorderPainted(false);
        btnClientesView.setContentAreaFilled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Vehículo", "Fecha de Pago", "Método de pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarReservaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pagos");

        btnBuscarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-10.png"))); // NOI18N
        btnBuscarReserva.setToolTipText("");

        jLabel2.setText("Método de pago:");

        comboboxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Yape", "Plin", "Tarjeta Débito" }));
        comboboxMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxMetodoPagoActionPerformed(evt);
            }
        });

        jLabel9.setText("Reserva:");

        jLabel4.setText("Fecha de pago:");

        comboboxIDreserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID reserva" }));
        comboboxIDreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxIDreservaActionPerformed(evt);
            }
        });

        btnRegisterPago.setBackground(new java.awt.Color(0, 153, 51));
        btnRegisterPago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegisterPago.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterPago.setText("REGISTRAR");

        btnCancelarRegisterPago.setBackground(new java.awt.Color(242, 66, 76));
        btnCancelarRegisterPago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarRegisterPago.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarRegisterPago.setText("CANCELAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboboxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxIDreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegisterPago)
                            .addComponent(btnCancelarRegisterPago, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboboxIDreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRegisterPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarRegisterPago)
                        .addGap(61, 61, 61)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReservasView, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPagoOventa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVehiculosView, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnClientesView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClientesView, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVehiculosView, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnReservasView, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPagoOventa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarReservaActionPerformed

    private void btnPagoOventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoOventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagoOventaActionPerformed

    private void btnReservasViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservasViewActionPerformed

    private void comboboxMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxMetodoPagoActionPerformed

    private void comboboxIDreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxIDreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxIDreservaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarReserva;
    private javax.swing.JButton btnCancelarRegisterPago;
    private javax.swing.JButton btnClientesView;
    private javax.swing.JButton btnPagoOventa;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterPago;
    private javax.swing.JButton btnReservasView;
    private javax.swing.JButton btnVehiculosView;
    private javax.swing.JComboBox<String> comboboxIDreserva;
    private javax.swing.JComboBox<String> comboboxMetodoPago;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscarReserva;
    private javax.swing.JTextField txtFechaPago;
    // End of variables declaration//GEN-END:variables
}
