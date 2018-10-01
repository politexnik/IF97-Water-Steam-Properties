package Function.Region2;

import Function.PropertyRegion;
import Function.Region2.BackwardEquation.Border2BC;

public class BackwardEquationTPH {
    public static double temperature(double pressure, double enthalpy){
        PropertyRegion region = Border2BC.findZoneForPH(pressure, enthalpy);
            if (region == PropertyRegion.Region2A) {
                return Function.Region2.BackwardEquation.temperaturePH.Zone2A.temperature(pressure, enthalpy);
            } else if (region == PropertyRegion.Region2B) {
                return Function.Region2.BackwardEquation.temperaturePH.Zone2B.temperature(pressure, enthalpy);
            } else {
                return Function.Region2.BackwardEquation.temperaturePH.Zone2C.temperature(pressure, enthalpy);
            }
    }
}
