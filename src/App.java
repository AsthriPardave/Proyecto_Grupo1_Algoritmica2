import controller.DashboardController;
import controller.LoginController;
import controller.VehiculoController;
import controller.ReservasController;
import view.DashboardView;
import view.LoginView;
import view.ReservasView;
import view.VehiculosView;

public class App {
    public static void main(String[] args) throws Exception {
        // Crear vistas principales
        LoginView loginView = new LoginView();
        DashboardView dashboardView = new DashboardView();
        VehiculosView vehiculosView = new VehiculosView();
        ReservasView reservasView = new ReservasView();

        // Crear controladores existentes
        VehiculoController vehiculoController = VehiculoController.getInstance(); // Controlador de Vehículos
        ReservasController reservasController = ReservasController.getInstance(); // Controlador de Reservas
        new LoginController(loginView, dashboardView);

        // Mostrar la pantalla de Login al iniciar
        loginView.setVisible(true);
    }
}
