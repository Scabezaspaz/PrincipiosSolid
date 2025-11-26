package com.vehiculos.servicio;

import com.vehiculos.interfaces.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 * DIP: Depende de la interfaz Vehiculo, no de clases concretas
 * SRP: Solo se encarga de gestionar el estacionamiento
 */
public class Estacionamiento {
    private String nombre;
    private int capacidadMaxima;
    private List<Vehiculo> vehiculosEstacionados;

    public Estacionamiento(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculosEstacionados = new ArrayList<>();
    }

    /**
     * Estaciona un vehículo (cualquier tipo que implemente Vehiculo)
     */
    public boolean estacionarVehiculo(Vehiculo vehiculo) {
        if (vehiculosEstacionados.size() < capacidadMaxima) {
            vehiculosEstacionados.add(vehiculo);
            System.out.println("✅ " + vehiculo.getTipo() + " estacionado correctamente");
            return true;
        } else {
            System.out.println("❌ Estacionamiento lleno. No se puede estacionar el " + vehiculo.getTipo());
            return false;
        }
    }

    /**
     * Retira un vehículo del estacionamiento
     */
    public boolean retirarVehiculo(Vehiculo vehiculo) {
        if (vehiculosEstacionados.remove(vehiculo)) {
            System.out.println("✅ " + vehiculo.getTipo() + " retirado del estacionamiento");
            return true;
        } else {
            System.out.println("❌ El vehículo no está en el estacionamiento");
            return false;
        }
    }

    /**
     * Muestra información del estacionamiento
     */
    public void mostrarEstado() {
        System.out.println("\n=================================");
        System.out.println("🅿️ ESTACIONAMIENTO: " + nombre);
        System.out.println("=================================");
        System.out.println("Capacidad: " + vehiculosEstacionados.size() + "/" + capacidadMaxima);
        System.out.println("\nVehículos estacionados:");

        if (vehiculosEstacionados.isEmpty()) {
            System.out.println("  - Ninguno");
        } else {
            for (int i = 0; i < vehiculosEstacionados.size(); i++) {
                Vehiculo v = vehiculosEstacionados.get(i);
                System.out.println("  " + (i + 1) + ". " + v.getTipo() +
                        " (" + v.getNumeroRuedas() + " ruedas)");
            }
        }
        System.out.println("=================================\n");
    }

    public int getEspaciosDisponibles() {
        return capacidadMaxima - vehiculosEstacionados.size();
    }
}