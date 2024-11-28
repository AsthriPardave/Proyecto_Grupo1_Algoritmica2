import controller.DashboardController;
import controller.LoginController;
import controller.VehiculoController;
import controller.ReservasController;
import controller.ClientesController;
import view.DashboardView;
import view.LoginView;
import view.ReservasView;
import view.VehiculosView;
import view.ClientesView;

public class App {
    public static void main(String[] args) {
        try {
            // Crear vistas principales
            LoginView loginView = new LoginView();
            DashboardView dashboardView = new DashboardView();
            VehiculosView vehiculosView = new VehiculosView();
            ReservasView reservasView = new ReservasView();
            ClientesView clientesView = new ClientesView();

            // Crear controladores principales
            VehiculoController vehiculoController = VehiculoController.getInstance(); // Controlador de Vehículos
            ReservasController reservasController = ReservasController.getInstance(); // Controlador de Reservas
            ClientesController clientesController = new ClientesController(clientesView); // Controlador de Clientes
            DashboardController dashboardController = new DashboardController(dashboardView, vehiculoController, reservasController, clientesController);

            // Crear y configurar LoginController
            new LoginController(loginView, dashboardController);

            // Mostrar la pantalla de Login al iniciar
            loginView.setVisible(true);
        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Ocurrió un error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
