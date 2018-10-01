package Function;

import Function.Region1.Properties1;
import Function.Region2.Properties2;
import Function.Region3.Properties3;
import Function.Region5.Properties5;
import Function.RegionOut.PropertiesOut;

public class Calc implements Properties{
    private Properties prop1 = new Properties1();
    private Properties prop2 = new Properties2();
    private Properties prop3 = new Properties3();
    private Properties prop5 = new Properties5();
    private Properties propOut = new PropertiesOut();
    private Properties propMain;

    private void setPropMain(double pressure, double temperature) {
        PropertyRegion zone = PropertyRegion.find(pressure, temperature);
        if (zone == PropertyRegion.Region1) {
            propMain = prop1;
        } else if (zone == PropertyRegion.Region2) {
            propMain = prop2;
        } else if (zone == PropertyRegion.Region3) {
            propMain = prop3;
        } else if (zone == PropertyRegion.Region5) {
            propMain = prop5;
        } else if (zone == PropertyRegion.RegionOut) {
            propMain = propOut;
        }
    }


    public double volume(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.volume(pressure, temperature);
    }

    public double internalEnergy(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.internalEnergy(pressure, temperature);
    }

    public double entropy(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.entropy(pressure, temperature);
    }

    public double enthalpy(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.enthalpy(pressure, temperature);
    }

    public double isobaricHeatCapacity(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.isobaricHeatCapacity(pressure, temperature);
    }

    public double isochoricHeatCapacity(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.isochoricHeatCapacity(pressure, temperature);
    }

    public double speedOfSound(double pressure, double temperature) {
        setPropMain(pressure, temperature);
        return propMain.speedOfSound(pressure, temperature);
    }

    public double temperaturePH(double pressure, double enthalpy) {

        return 0;
    }

    public double temperaturePS(double pressure, double entropy) {
        return 0;
    }
}
