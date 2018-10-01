package Function.Region2;

import Function.PropertyRegion;
import Function.Region2.BackwardEquation.Border2BC;

public class BackwardEquationTPS {
    public static double temperature(double pressure, double entropy){
        PropertyRegion region = Border2BC.findZoneForPS(pressure, entropy);
        if (region == PropertyRegion.Region2A) {
            return Function.Region2.BackwardEquation.temperaturePS.Zone2A.temperature(pressure, entropy);
        } else if (region == PropertyRegion.Region2B) {
            return Function.Region2.BackwardEquation.temperaturePS.Zone2B.temperature(pressure, entropy);
        } else {
            return Function.Region2.BackwardEquation.temperaturePS.Zone2C.temperature(pressure, entropy);
        }
    }
}
