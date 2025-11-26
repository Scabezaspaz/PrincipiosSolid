package com.vehiculos;

import com.vehiculos.modelo.Bicicleta;
import com.vehiculos.modelo.Coche;
import com.vehiculos.modelo.Motocicleta;
import com.vehiculos.servicio.Estacionamiento;

class Main {
    public static void main(String[] args) {
        System.out.println("🚗🏍️🚴 SISTEMA DE CONTROL DE VEHÍCULOS 🚴🏍️🚗\n");

        // Crear vehículos
        Coche coche = new Coche("Toyota", "Corolla", 4);
        Motocicleta moto = new Motocicleta("Yamaha", 250);
        Bicicleta bici = new Bicicleta("Trek", "Montaña", 21);

        // Mostrar información de cada vehículo
        coche.mostrarInformacion();
        System.out.println();
        moto.mostrarInformacion();
        System.out.println();
        bici.mostrarInformacion();
        System.out.println("\n");

        // Demostración de funcionalidades del Coche
        System.out.println("--- PROBANDO COCHE ---");
        coche.encenderMotor();
        coche.acelerar();
        coche.girar("derecha");
        coche.frenar();
        coche.apagarMotor();
        System.out.println();

        // Demostración de funcionalidades de la Motocicleta
        System.out.println("--- PROBANDO MOTOCICLETA ---");
        moto.encenderMotor();
        moto.acelerar();
        moto.girar("izquierda");
        moto.frenar();
        System.out.println();

        // Demostración de funcionalidades de la Bicicleta
        System.out.println("--- PROBANDO BICICLETA ---");
        bici.acelerar();
        bici.cambiarMarcha(5);
        bici.girar("derecha");
        bici.frenar();
        System.out.println();

        // Crear estacionamiento
        Estacionamiento estacionamiento = new Estacionamiento("Parking Central", 5);

        // Estacionar vehículos
        System.out.println("--- GESTIONANDO ESTACIONAMIENTO ---");
        estacionamiento.estacionarVehiculo(coche);
        estacionamiento.estacionarVehiculo(moto);
        estacionamiento.estacionarVehiculo(bici);

        estacionamiento.mostrarEstado();

        // Retirar un vehículo
        estacionamiento.retirarVehiculo(moto);
        estacionamiento.mostrarEstado();

        // Crear más vehículos para probar la capacidad
        System.out.println("--- PROBANDO CAPACIDAD ---");
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
