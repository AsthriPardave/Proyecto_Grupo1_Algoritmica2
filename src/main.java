import controller.VehiculoController;
import model.ArregloVehiculo;
import view.VehiculosView;

public class main {
    public static void main(String[] args) {
        // Crear la vista
        VehiculosView view = new VehiculosView();

        // Crear el modelo con una capacidad de 100 vehículos
        ArregloVehiculo arregloVehiculo = new ArregloVehiculo(100);

        // Crear el controlador, que manejará la lógica entre la vista y el modelo
        VehiculoController controller = new VehiculoController(view, arregloVehiculo);

        // Mostrar la vista
        view.setVisible(true);
    }
}
