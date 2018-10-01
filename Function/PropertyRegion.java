package Function;

import Function.Boundary.*;

public enum PropertyRegion {
    Region1("1"), Region2("2"), Region2A("2A"), Region2B("2B"), Region2C("2C"),
    Region3("3"), Region5("5"), RegionOut("OUT");

    private String name;

    private PropertyRegion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PropertyRegion find(double pressure, double temperature) {
        //определение вылета за границы
        if ( temperature <= 273.15 || temperature > 2273.15 || pressure <= 0 || pressure > 100e+6 ||
                (pressure > 50e+6 && pressure < 100e+6 && temperature > 1073.15 && temperature < 2273.15) ) {
            return RegionOut;
        } else if  (temperature > 1073.15) {       //Зона 5
                return Region5;
        } else if (temperature <= 623.15) {     //Зона 1 или 2
            if (pressure > SaturationLine.pressure(temperature)) {
                return Region1;
            } else return Region2;
        } else if (temperature>RegionBetween2And3.boundaryTemperatureBetweenRegions2And3(100e+6)) {      // Зона 2 вне действия границы между 2 и 3
            return Region2;
        } else if (pressure > RegionBetween2And3.boundaryPressureBetweenRegions2And3(temperature)) {
                return Region3;
        } else return Region2;
    }

    @Override
    public String toString() {
        return name;
    }
}
