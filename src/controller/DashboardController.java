package controller;

import view.DashboardView;

public class DashboardController {

    private DashboardView dashboardView;
    private VehiculoController vehiculoController;
    private ReservasController reservasController;
    private ClienteController clienteController;
    private PagoController pagoController;

    public DashboardController(
        DashboardView dashboardView,
        VehiculoController vehiculoController,
        ReservasController reservasController,
        ClienteController clienteController,
        PagoController pagoController) {
            this.dashboardView = dashboardView;
            this.vehiculoController = vehiculoController;
            this.reservasController = reservasController;
            this.clienteController = clienteController;
            this.pagoController = pagoController;

            initDashboardView();
        }

    private void initDashboardView() {
        dashboardView.setVisible(true);

        // Configurar eventos de los botones en el Dashboard
        dashboardView.getBtnVehiculo().addActionListener(e -> cambiarVista(() -> vehiculoController.start()));
        dashboardView.getBtnReserva().addActionListener(e -> cambiarVista(() -> reservasController.start()));
        dashboardView.getBtnInicio().addActionListener(e -> mostrarInicio());
        dashboardView.getBtnPago().addActionListener(e -> cambiarVista(() -> pagoController.start()));
        dashboardView.getBtnCliente().addActionListener(e -> cambiarVista(() -> clienteController.start()));
    }

    private void cambiarVista(Runnable accion) {
        dashboardView.setVisible(false); // Oculta el Dashboard antes de cambiar de vista
        accion.run(); // Ejecuta la acción del controlador asociado
    }

    private void mostrarInicio() {
        // Aquí puedes implementar la lógica para el botón "Inicio"
        System.out.println("Mostrando la pantalla de inicio...");
        dashboardView.setVisible(true);
    }
}
