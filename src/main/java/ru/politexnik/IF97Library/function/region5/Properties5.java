package ru.politexnik.IF97Library.function.region5;

import ru.politexnik.IF97Library.function.Properties;

public class Properties5 implements Properties {
    public double volume(double pressure, double temperature) {
        return BasicEquation.volume(pressure, temperature);
    }

    public double internalEnergy(double pressure, double temperature) {
        return BasicEquation.internalEnergy(pressure, temperature);
    }

    public double entropy(double pressure, double temperature) {
        return BasicEquation.entropy(pressure, temperature);
    }

    public double enthalpy(double pressure, double temperature) {
        return BasicEquation.enthalpy(pressure, temperature);
    }

    public double isobaricHeatCapacity(double pressure, double temperature) {
        return BasicEquation.isobaricHeatCapacity(pressure, temperature);
    }

    public double isochoricHeatCapacity(double pressure, double temperature) {
        return BasicEquation.isochoricHeatCapacity(pressure, temperature);
    }

    public double speedOfSound(double pressure, double temperature) {
        return BasicEquation.speedOfSound(pressure, temperature);
    }

    public double temperaturePH(double pressure, double enthalpy) {
        return 0;
    }

    public double temperaturePS(double pressure, double entropy) {
        return 0;
    }
}
