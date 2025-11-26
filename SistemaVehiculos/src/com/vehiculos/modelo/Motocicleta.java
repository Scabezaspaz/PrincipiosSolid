package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Motorizado;
import com.vehiculos.interfaces.Vehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SRP: Esta clase solo se encarga de representar una Motocicleta
 * LSP: Puede sustituir a Vehiculo sin problemas
 */
public class Motocicleta implements Vehiculo, Conducible, Motorizado {
    private static final Logger logger = Logger.getLogger(Motocicleta.class.getName());

    private String marca;
    private int cilindrada;
    private boolean motorEncendido;

    public Motocicleta(String marca, int cilindrada) {
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.motorEncendido = false;
    }

    @Override
    public String getTipo() {
        return "Motocicleta";
    }

    @Override
    public int getNumeroRuedas() {
        return 2;
    }

    @Override
    public void mostrarInformacion() {
        logger.info("=== MOTOCICLETA ===");
        logger.log(Level.INFO, "Marca: {0}", marca);
        logger.log(Level.INFO, "Cilindrada: {0} cc", cilindrada);
        logger.log(Level.INFO, "Ruedas: {0}", getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        if (motorEncendido) {
            logger.info("🏍️ La motocicleta está acelerando...");
        } else {
            logger.warning("⚠️ Debes encender el motor primero");
        }
    }

    @Override
    public void frenar() {
        logger.info("🛑 La motocicleta está frenando...");
    }

    @Override
    public void girar(String direccion) {
        logger.log(Level.INFO, "↩️ La motocicleta se inclina a la {0}", direccion);
    }

    @Override
    public void encenderMotor() {
        motorEncendido = true;
        logger.info("🔥 Motor de la motocicleta encendido");
    }

    @Override
    public void apagarMotor() {
        motorEncendido = false;
        logger.info("🔌 Motor de la motocicleta apagado");
    }

    @Override
    public String getTipoCombustible() {
        return "Gasolina";
    }
}