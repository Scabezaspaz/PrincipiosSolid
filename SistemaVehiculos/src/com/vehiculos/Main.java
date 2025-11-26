package com.vehiculos;

import com.vehiculos.modelo.Bicicleta;
import com.vehiculos.modelo.Coche;
import com.vehiculos.modelo.Motocicleta;
import com.vehiculos.servicio.Estacionamiento;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private Main() {
        // Constructor privado para evitar instanciación
    }

    public static void main(String[] args) {
        logger.info("🚗🏍️🚴 SISTEMA DE CONTROL DE VEHÍCULOS 🚴🏍️🚗\n");

        // Crear vehículos
        Coche coche = new Coche("Toyota", "Corolla", 4);
        Motocicleta moto = new Motocicleta("Yamaha", 250);
        Bicicleta bici = new Bicicleta("Trek", "Montaña", 21);

        // Mostrar información de cada vehículo
        coche.mostrarInformacion();
        logger.info("");
        moto.mostrarInformacion();
        logger.info("");
        bici.mostrarInformacion();
        logger.info("\n");

        // Demostración de funcionalidades del Coche
        logger.info("--- PROBANDO COCHE ---");
        coche.encenderMotor();
        coche.acelerar();
        coche.girar("derecha");
        coche.frenar();
        coche.apagarMotor();
        logger.info("");

        // Demostración de funcionalidades de la Motocicleta
        logger.info("--- PROBANDO MOTOCICLETA ---");
        moto.encenderMotor();
        moto.acelerar();
        moto.girar("izquierda");
        moto.frenar();
        logger.info("");

        // Demostración de funcionalidades de la Bicicleta
        logger.info("--- PROBANDO BICICLETA ---");
        bici.acelerar();
        bici.cambiarMarcha(5);
        bici.girar("derecha");
        bici.frenar();
        logger.info("");

        // Crear estacionamiento
        Estacionamiento estacionamiento = new Estacionamiento("Parking Central", 5);

        // Estacionar vehículos
        logger.info("--- GESTIONANDO ESTACIONAMIENTO ---");
        estacionamiento.estacionarVehiculo(coche);
        estacionamiento.estacionarVehiculo(moto);
        estacionamiento.estacionarVehiculo(bici);

        estacionamiento.mostrarEstado();

        // Retirar un vehículo
        estacionamiento.retirarVehiculo(moto);
        estacionamiento.mostrarEstado();

        // Crear más vehículos para probar la capacidad
        logger.info("--- PROBANDO CAPACIDAD ---");
        Coche coche2 = new Coche("Honda", "Civic", 4);
        Coche coche3 = new Coche("Ford", "Focus", 4);
        Bicicleta bici2 = new Bicicleta("Giant", "Ruta", 18);

        estacionamiento.estacionarVehiculo(coche2);
        estacionamiento.estacionarVehiculo(coche3);
        estacionamiento.estacionarVehiculo(bici2);

        // Intentar estacionar cuando está lleno
        Motocicleta moto2 = new Motocicleta("Honda", 150);
        estacionamiento.estacionarVehiculo(moto2);

        estacionamiento.mostrarEstado();
    }
}