package model;
public interface ClienteUsuario {

    public void agregarVehiculo(Vehiculo vehiculo);

    public void modificarVehiculo(String matricula, String nuevaMarca, String nuevoModelo, float nuevoPrecioPorDia);

    public void eliminarVehiculo(String matricula);

    public void listarVehiculos();

}
