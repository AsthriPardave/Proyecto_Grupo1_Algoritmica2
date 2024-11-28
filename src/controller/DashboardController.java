package controller;

import view.DashboardView;

public class DashboardController {

    private DashboardView dashboardView;
    private VehiculoController vehiculoController;
    private ReservasController reservasController;

    public DashboardController(
            DashboardView dashboardView,
            VehiculoController vehiculoController,
            ReservasController reservasController) {
        this.dashboardView = dashboardView;
        this.vehiculoController = vehiculoController;
        this.reservasController = reservasController;

        initDashboardView();
    }

    private void initDashboardView() {
        dashboardView.setVisible(true);

        // Configurar eventos de los botones en el Dashboard
        dashboardView.getBtnVehiculo().addActionListener(e -> mostrarVehiculosView());
        dashboardView.getBtnReserva().addActionListener(e -> mostrarReservasView());
        dashboardView.getBtnInicio().addActionListener(e -> mostrarInicio());
        dashboardView.getBtnPago().addActionListener(e -> mostrarPago());
    }

    private void mostrarVehiculosView() {
        vehiculoController.start(); // Llama al método para mostrar la vista de Vehículos
        dashboardView.setVisible(false); // Opcional: oculta el Dashboard mientras se muestra la vista de Vehículos
    }

    private void mostrarReservasView() {
        reservasController.start(); // Llama al método para mostrar la vista de Reservas
        dashboardView.setVisible(false); // Opcional: oculta el Dashboard mientras se muestra la vista de Reservas
    }

    private void mostrarInicio() {
        // Aquí puedes implementar la lógica para el botón "Inicio"
        System.out.println("Mostrando la pantalla de inicio...");
    }

    private void mostrarPago() {
        // Aquí puedes implementar la lógica para el módulo de pagos
        System.out.println("Mostrando el módulo de pagos...");
    }
}


/*



private void mostrarPago() {
        // Aquí puedes implementar la lógica para el módulo de pagos
        System.out.println("Mostrando el módulo de pagos...");
    }



 */