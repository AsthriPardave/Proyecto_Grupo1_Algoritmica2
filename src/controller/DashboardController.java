package controller;

import view.DashboardView;

public class DashboardController {

    private DashboardView dashboardView;
    private VehiculoController vehiculoController;
    private ReservasController reservasController;
    private ClienteController clienteController;

    public DashboardController(
        DashboardView dashboardView,
        VehiculoController vehiculoController,
        ReservasController reservasController,
        ClienteController clienteController) {
            this.dashboardView = dashboardView;
            this.vehiculoController = vehiculoController;
            this.reservasController = reservasController;
            this.clienteController = clienteController;

            initDashboardView();
        }

    private void initDashboardView() {
        dashboardView.setVisible(true);

        // Configurar eventos de los botones en el Dashboard
        dashboardView.getBtnVehiculo().addActionListener(e -> cambiarVista(() -> vehiculoController.start()));
        dashboardView.getBtnReserva().addActionListener(e -> cambiarVista(() -> reservasController.start()));
        dashboardView.getBtnInicio().addActionListener(e -> mostrarInicio());
        dashboardView.getBtnPago().addActionListener(e -> mostrarPago());
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

    private void mostrarPago() {
        // Aquí puedes implementar la lógica para el módulo de pagos
        System.out.println("Mostrando el módulo de pagos...");
    }
}
