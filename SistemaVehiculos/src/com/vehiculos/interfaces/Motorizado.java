package com.vehiculos.interfaces;

/**
 * ISP: Interfaz específica para vehículos con motor
 */
public interface Motorizado {
    void encenderMotor();
    void apagarMotor();
    String getTipoCombustible();
}