import controller.LoginController;
import view.DashboardView;
import view.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        // Crear vistas principales
        LoginView loginView = new LoginView();
        DashboardView dashboardView = new DashboardView();

        // Crear controladores existentes
        new LoginController(loginView, dashboardView);

        // Mostrar la pantalla de Login al iniciar
        loginView.setVisible(true);
    }
}
