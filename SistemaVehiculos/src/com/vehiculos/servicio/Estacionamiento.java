package com.vehiculos.servicio;

import com.vehiculos.interfaces.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DIP: Depende de la interfaz Vehiculo, no de clases concretas
 * SRP: Solo se encarga de gestionar el estacionamiento
 */
public class Estacionamiento {
    private static final Logger logger = Logger.getLogger(Estacionamiento.class.getName());

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
            logger.log(Level.INFO, "✅ {0} estacionado correctamente", vehiculo.getTipo());
            return true;
        } else {
            logger.log(Level.WARNING, "❌ Estacionamiento lleno. No se puede estacionar el {0}", vehiculo.getTipo());
            return false;
        }
    }

    /**
     * Retira un vehículo del estacionamiento
     */
    public boolean retirarVehiculo(Vehiculo vehiculo) {
        if (vehiculosEstacionados.remove(vehiculo)) {
            logger.log(Level.INFO, "✅ {0} retirado del estacionamiento", vehiculo.getTipo());
            return true;
        } else {
            logger.warning("❌ El vehículo no está en el estacionamiento");
            return false;
        }
    }

    /**
     * Muestra información del estacionamiento
     */
    public void mostrarEstado() {
        logger.info("\n=================================");
        logger.log(Level.INFO, "🅿️ ESTACIONAMIENTO: {0}", nombre);
        logger.info("=================================");
        logger.log(Level.INFO, "Capacidad: {0}/{1}", new Object[]{vehiculosEstacionados.size(), capacidadMaxima});
        logger.info("\nVehículos estacionados:");

        if (vehiculosEstacionados.isEmpty()) {
            logger.info("  - Ninguno");
        } else {
            for (int i = 0; i < vehiculosEstacionados.size(); i++) {
                Vehiculo v = vehiculosEstacionados.get(i);
                logger.log(Level.INFO, "  {0}. {1} ({2} ruedas)",
                        new Object[]{i + 1, v.getTipo(), v.getNumeroRuedas()});
            }
        }
        logger.info("=================================\n");
    }

    public int getEspaciosDisponibles() {
        return capacidadMaxima - vehiculosEstacionados.size();
    }
}