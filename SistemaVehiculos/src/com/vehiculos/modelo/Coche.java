package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Motorizado;
import com.vehiculos.interfaces.Vehiculo;

/**
 * SRP: Esta clase solo se encarga de representar un Coche
 * LSP: Puede sustituir a Vehiculo sin problemas
 */
public class Coche implements Vehiculo, Conducible, Motorizado {
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
        System.out.println("=== COCHE ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Puertas: " + numeroPuertas);
        System.out.println("Ruedas: " + getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        if (motorEncendido) {
            System.out.println("🚗 El coche está acelerando...");
        } else {
            System.out.println("⚠️ Debes encender el motor primero");
        }
    }

    @Override
    public void frenar() {
        System.out.println("🛑 El coche está frenando...");
    }

    @Override
    public void girar(String direccion) {
        System.out.println("↩️ El coche gira a la " + direccion);
    }

    @Override
    public void encenderMotor() {
        motorEncendido = true;
        System.out.println("🔥 Motor del coche encendido");
    }

    @Override
    public void apagarMotor() {
        motorEncendido = false;
        System.out.println("🔌 Motor del coche apagado");
    }

    @Override
    public String getTipoCombustible() {
        return "Gasolina";
    }
}