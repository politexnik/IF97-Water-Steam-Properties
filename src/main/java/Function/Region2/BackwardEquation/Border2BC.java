package Function.Region2.BackwardEquation;

import Function.PropertyRegion;

public class Border2BC {
    public static PropertyRegion findZoneForPH(double pressure, double enthalpy) {
        if (pressure <= 4e+6) {
            return PropertyRegion.Region2A;
        } else if (pressure <= pressure(enthalpy)) {  //Добавить границу
            return PropertyRegion.Region2B;
        } else {
            return PropertyRegion.Region2C;
        }
    }

    public static double pressure(double enthalpy) {
        double nu = enthalpy / 1e+3;
        return (0.90584278514723e+3 - 0.67955786399241 * nu +  0.12809002730136e-3  * nu * nu) * 1e+6;
    }

    public static PropertyRegion findZoneForPS(double pressure, double entropy) {
        if (pressure <= 4e+6) {
            return PropertyRegion.Region2A;
        } else if (entropy >= 5.85e+3) {  //Добавить границу
            return PropertyRegion.Region2B;
        } else {
            return PropertyRegion.Region2C;
        }
    }
}
