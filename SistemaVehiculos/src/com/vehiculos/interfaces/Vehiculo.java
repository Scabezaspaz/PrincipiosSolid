package com.vehiculos.interfaces;

/**
 * DIP: Interfaz general de la que dependerán otras clases
 */
public interface Vehiculo {
    String getTipo();
    int getNumeroRuedas();
    void mostrarInformacion();
}