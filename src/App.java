
import controller.LoginController;
import view.LoginView;


public class App {
    public static void main(String[] args) {
        LoginView frame = new LoginView();
        LoginController controlador = new LoginController(frame);
        
       controlador.run();
    }
}
