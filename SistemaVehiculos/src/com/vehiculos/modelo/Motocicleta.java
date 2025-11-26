package com.vehiculos.modelo;

import com.vehiculos.interfaces.Conducible;
import com.vehiculos.interfaces.Motorizado;
import com.vehiculos.interfaces.Vehiculo;

/**
 * SRP: Esta clase solo se encarga de representar una Motocicleta
 * LSP: Puede sustituir a Vehiculo sin problemas
 */
public class Motocicleta implements Vehiculo, Conducible, Motorizado {
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
        System.out.println("=== MOTOCICLETA ===");
        System.out.println("Marca: " + marca);
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.println("Ruedas: " + getNumeroRuedas());
    }

    @Override
    public void acelerar() {
        if (motorEncendido) {
            System.out.println("🏍️ La motocicleta está acelerando...");
        } else {
            System.out.println("⚠️ Debes encender el motor primero");
        }
    }

    @Override
    public void frenar() {
        System.out.println("🛑 La motocicleta está frenando...");
    }

    @Override
    public void girar(String direccion) {
        System.out.println("↩️ La motocicleta se inclina a la " + direccion);
    }

    @Override
    public void encenderMotor() {
        motorEncendido = true;
        System.out.println("🔥 Motor de la motocicleta encendido");
    }

    @Override
    public void apagarMotor() {
        motorEncendido = false;
        System.out.println("🔌 Motor de la motocicleta apagado");
    }

    @Override
    public String getTipoCombustible() {
        return "Gasolina";
    }
}