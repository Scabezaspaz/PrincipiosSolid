package com.vehiculos.interfaces;

/**
 * ISP: Interfaz segregada para vehículos que pueden ser conducidos
 */
public interface Conducible {
    void acelerar();
    void frenar();
    void girar(String direccion);
}