/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class FileManager {
    
    public static void escribirVehiculo(List<Vehiculo> vehiculos){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Vehiculos.txt"))) {
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Auto) {
                    Auto auto = (Auto) vehiculo;
                    writer.write("Auto");
                    writer.newLine();
                    writer.write(auto.getMarca());
                    writer.newLine();
                    writer.write(auto.getMatricula());
                    writer.newLine();
                    writer.write(auto.getModelo());
                    writer.newLine();
                    writer.write(auto.getPrecioPorDia()+"");
                    writer.newLine();
                    writer.write((auto.isDisponible() ? "Sí" : "No"));
                    writer.newLine();
                    writer.write(auto.getNumeroAsientos()+"");
                    writer.newLine();
                    writer.write(auto.getCapacidadMaletero()+"");
                    writer.newLine();
                } else if (vehiculo instanceof Motocicleta) {
                    Motocicleta moto = (Motocicleta) vehiculo;
                    writer.write("Motocicleta");
                    writer.newLine();
                    writer.write(moto.getMarca());
                    writer.newLine();
                    writer.write(moto.getMatricula());
                    writer.newLine();
                    writer.write(moto.getModelo());
                    writer.newLine();
                    writer.write(moto.getPrecioPorDia()+"");
                    writer.newLine();
                    writer.write((moto.isDisponible() ? "Sí" : "No"));
                    writer.newLine();
                    writer.write(moto.getCilindraje()+"");
                    writer.newLine();
                } else if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    writer.write("Camión");
                    writer.newLine();
                    writer.write(camion.getMarca());
                    writer.newLine();
                    writer.write(camion.getMatricula());
                    writer.newLine();
                    writer.write(camion.getModelo());
                    writer.newLine();
                    writer.write(camion.getPrecioPorDia()+"");
                    writer.newLine();
                    writer.write((camion.isDisponible() ? "Sí" : "No"));
                    writer.newLine();
                    writer.write(camion.getCapacidadCarga()+"");
                    writer.newLine();
                    writer.write((camion.isDobleCabina() ? "Sí" : "No"));
                    writer.newLine();
                }
                writer.newLine(); // Línea en blanco entre vehículos
            }
            System.out.println("Lista de vehículos guardada en Vehiculos.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar los vehículos: " + e.getMessage());
        }
    }
    
    public static List<Vehiculo> leerVehiculos() throws FileNotFoundException, IOException{
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Vehiculos.txt"))) {
            String linea;
            Vehiculo v = null;
            String tipo = "";
            String matricula = "", marca = "", modelo = "";
            float precioPorDia = 0.0f;
            boolean disponible = false;

            while ((linea = reader.readLine()) != null) {
                tipo = linea;
                marca = reader.readLine();
                matricula = reader.readLine();
                modelo = reader.readLine();
                precioPorDia = Float.parseFloat(reader.readLine());
                disponible = reader.readLine().equalsIgnoreCase("Sí");
                
                if ("Auto".equals(tipo)){
                    int numeroAsientos = Integer.parseInt(reader.readLine());
                    float capacidadMaletero = Float.parseFloat(reader.readLine());
                    v = new Auto(matricula, marca, modelo, precioPorDia, disponible, numeroAsientos, capacidadMaletero);
                } else if ("Motocicleta".equals(tipo)) {
                    int cilindraje = Integer.parseInt(reader.readLine());
                    v = new Motocicleta(matricula, marca, modelo, precioPorDia, disponible, cilindraje);
                } else if ("Camión".equals(tipo)) {
                    float capacidadCarga = Float.parseFloat(reader.readLine());
                    boolean dobleCabina = reader.readLine().equalsIgnoreCase("Sí");
                    v = new Camion(matricula, marca, modelo, precioPorDia, disponible, capacidadCarga, dobleCabina);
                }

                if (v != null) {
                    vehiculos.add(v);
                    v = null; 
                }
              linea = reader.readLine();  
            }
        }
        return vehiculos;
    }
    
    //**********************CLIENTES**********************************
    
    public static void escribirCliente(List<Cliente> clientes){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clientes.txt"))) {
            for (Cliente cliente : clientes) {
                
                writer.write(cliente.getNombre());
                writer.newLine();
                writer.write(cliente.getApellido());
                writer.newLine();
                writer.write(cliente.getEmail());
                writer.newLine();
                writer.write(cliente.getDni());
                writer.newLine();
                writer.write(cliente.getNumero());
                writer.newLine();
                    
                writer.newLine(); // Línea en blanco entre vehículos
            }
            System.out.println("Lista de clientes guardada en Clientes.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar los clientes: " + e.getMessage());
        }
    }
    
    public static List<Cliente> leerClientes() throws FileNotFoundException, IOException{
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linea;
            Cliente cliente = null;
            String nombre = "", apellido = "", email = "", dni = "", numero = "";

            while ((linea = reader.readLine()) != null) {
                nombre = linea;
                apellido = reader.readLine();
                email = reader.readLine();
                dni = reader.readLine();
                numero = reader.readLine();
                cliente = new Cliente(nombre, apellido, email, dni, numero);

                if (cliente != null) {
                    clientes.add(cliente);
                    cliente = null; 
                }
              linea = reader.readLine();  
            }
        }
        return clientes;
    }
    
    //************************RESERVA*********************************
    
    public static void escribirReserva(List<Reserva> reservas){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reservas.txt"))) {
            for (Reserva reserva : reservas) {
                
                writer.write(reserva.getId());
                writer.newLine();
                writer.write(reserva.getDiasReservados());
                writer.newLine();
                writer.write(reserva.getVehiculo().getMatricula());
                writer.newLine();
                writer.write(reserva.getCliente().getDni());
                writer.newLine();    
                
                writer.newLine(); // Línea en blanco entre vehículos
            }
            System.out.println("Lista de clientes guardada en Reservas.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar los reservas: " + e.getMessage());
        }
    }
    
    public static List<Reserva> leerReservas(List<Vehiculo> vehiculos, List<Cliente> clientes) throws FileNotFoundException, IOException{
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linea;
            Reserva reserva = null;
            String id = "";
            int diasReservados = 0;
            Vehiculo vehiculo = null;
            Cliente cliente = null;
            String matricula = "";
            String dni = "";

            while ((linea = reader.readLine()) != null) {
                id = reader.readLine();
                diasReservados = Integer.parseInt(reader.readLine());
                matricula = reader.readLine();
                dni = reader.readLine();
                reserva = new Reserva(id, diasReservados,Vehiculo.buscarVehiculo(matricula, vehiculos),Cliente.buscarCliente(dni, clientes));
                if (reserva != null) {
                    reservas.add(reserva);
                    reserva = null; 
                }
              linea = reader.readLine();  
            }
        }
        return reservas;
    }
    
    //*************************PAGOS**********************************
}
