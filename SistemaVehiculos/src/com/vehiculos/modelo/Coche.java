package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Motorizado;
import com.vehiculos.interfaces.Vehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SRP: Esta clase solo se encarga de representar un Coche
 * LSP: Puede sustituir a Vehiculo sin problemas
 */
public class Coche implements Vehiculo, Conducible, Motorizado {
    private static final Logger logger = Logger.getLogger(Coche.class.getName());

    private String marca;
    private String modelo;
    private int numeroPuertas;
    private boolean motorEncendido;

    public Coche(String marca, String modelo, int numeroPuertas) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPuertas = numeroPuertas;
        this.motorEncendido = false;
    }

    @Override
    public String getTipo() {
        return "Coche";
    }

    @Override
    public int getNumeroRuedas() {
        return 4;
    }

    @Override
    public void mostrarInformacion() {
        logger.info("=== COCHE ===");
        logger.log(Level.INFO, "Marca: {0}", marca);
        logger.log(Level.INFO, "Modelo: {0}", modelo);
        logger.log(Level.INFO, "Puertas: {0}", numeroPuertas);
        logger.log(Level.INFO, "Ruedas: {0}", getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        if (motorEncendido) {
            logger.info("🚗 El coche está acelerando...");
        } else {
            logger.warning("⚠️ Debes encender el motor primero");
        }
    }

    @Override
    public void frenar() {
        logger.info("🛑 El coche está frenando...");
    }

    @Override
    public void girar(String direccion) {
        logger.log(Level.INFO, "↩️ El coche gira a la {0}", direccion);
    }

    @Override
    public void encenderMotor() {
        motorEncendido = true;
        logger.info("🔥 Motor del coche encendido");
    }

    @Override
    public void apagarMotor() {
        motorEncendido = false;
        logger.info("🔌 Motor del coche apagado");
    }

    @Override
    public String getTipoCombustible() {
        return "Gasolina";
    }
}