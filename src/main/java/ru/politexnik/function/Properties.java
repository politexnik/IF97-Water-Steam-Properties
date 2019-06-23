package ru.politexnik.function;

public interface Properties {
    public double volume(double pressure, double temperature);

    public double internalEnergy(double pressure, double temperature);

    public double entropy(double pressure, double temperature);

    public double enthalpy(double pressure, double temperature);

    public double isobaricHeatCapacity(double pressure, double temperature);

    public double isochoricHeatCapacity(double pressure, double temperature);

    public double speedOfSound(double pressure, double temperature);

    public double temperaturePH(double pressure, double enthalpy);

    public double temperaturePS(double pressure, double entropy);
}
