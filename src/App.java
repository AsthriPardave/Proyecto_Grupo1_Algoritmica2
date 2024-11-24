import controller.MainController;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import view.LoginView;
import view.RegistroView;
import view.VehiculosView;
import view.RegistroVehiculoView;
import view.ModalAutoView;
import view.ModalCamionView;
import view.ModalMotoView;
import model.Vehiculo;
import model.Cliente;
import model.FileManager;
import model.Pago;
import model.Reserva;

public class App {
    public static void main(String[] args) throws IOException {
        
        List<Vehiculo> vehiculos = FileManager.leerVehiculos();
        List<Cliente> clientes = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Pago> pagos = new ArrayList<>();
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

    }

}

