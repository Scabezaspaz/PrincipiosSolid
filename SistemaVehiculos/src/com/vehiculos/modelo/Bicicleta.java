package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Vehiculo;

/**
 * SRP: Esta clase solo se encarga de representar una Bicicleta
 * ISP: Solo implementa las interfaces que necesita (no implementa Motorizado)
 */
public class Bicicleta implements Vehiculo, Conducible {
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
        System.out.println("=== BICICLETA ===");
        System.out.println("Marca: " + marca);
        System.out.println("Tipo: " + tipo);
        System.out.println("Marchas: " + numeroMarchas);
        System.out.println("Ruedas: " + getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        System.out.println("🚴 Pedaleando más rápido...");
    }

    @Override
    public void frenar() {
        System.out.println("🛑 La bicicleta está frenando...");
    }

    @Override
    public void girar(String direccion) {
        System.out.println("↩️ La bicicleta gira a la " + direccion);
    }

    public void cambiarMarcha(int marcha) {
        if (marcha >= 1 && marcha <= numeroMarchas) {
            System.out.println("⚙️ Cambiando a la marcha " + marcha);
        } else {
            System.out.println("⚠️ Marcha no válida");
        }
    }
}