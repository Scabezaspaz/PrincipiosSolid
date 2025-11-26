package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Vehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SRP: Esta clase solo se encarga de representar una Bicicleta
 * ISP: Solo implementa las interfaces que necesita (no implementa Motorizado)
 */
public class Bicicleta implements Vehiculo, Conducible {
    private static final Logger logger = Logger.getLogger(Bicicleta.class.getName());

    private String marca;
    private String tipo;
    private int numeroMarchas;

    public Bicicleta(String marca, String tipo, int numeroMarchas) {
        this.marca = marca;
        this.tipo = tipo;
        this.numeroMarchas = numeroMarchas;
    }

    @Override
    public String getTipo() {
        return "Bicicleta";
    }

    @Override
    public int getNumeroRuedas() {
        return 2;
    }

    @Override
    public void mostrarInformacion() {
        logger.info("=== BICICLETA ===");
        logger.log(Level.INFO, "Marca: {0}", marca);
        logger.log(Level.INFO, "Tipo: {0}", tipo);
        logger.log(Level.INFO, "Marchas: {0}", numeroMarchas);
        logger.log(Level.INFO, "Ruedas: {0}", getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        logger.info("🚴 Pedaleando más rápido...");
    }

    @Override
    public void frenar() {
        logger.info("🛑 La bicicleta está frenando...");
    }

    @Override
    public void girar(String direccion) {
        logger.log(Level.INFO, "↩️ La bicicleta gira a la {0}", direccion);
    }

    public void cambiarMarcha(int marcha) {
        if (marcha >= 1 && marcha <= numeroMarchas) {
            logger.log(Level.INFO, "⚙️ Cambiando a la marcha {0}", marcha);
        } else {
            logger.warning("⚠️ Marcha no válida");
        }
    }
}