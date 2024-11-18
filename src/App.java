import controller.MainController;
import view.LoginView;
import view.RegistroView;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;

public class App {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        RegistroView registroView = new RegistroView();
        VehiculosView vehiculosView = new VehiculosView();
        RegistroVehiculoView registroVehiculoView = new RegistroVehiculoView();
        ModalAutoView modalAutoView = new ModalAutoView();
        ModalCamionView modalCamionView = new ModalCamionView();
        ModalMotoView modalMotoView = new ModalMotoView();

        new MainController(
            loginView,
            registroView,
            vehiculosView,
            registroVehiculoView,
            modalAutoView,
            modalCamionView,
            modalMotoView
        );

        loginView.setVisible(true);
    }
}
