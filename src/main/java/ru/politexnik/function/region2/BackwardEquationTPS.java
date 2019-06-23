package ru.politexnik.function.region2;

import ru.politexnik.function.PropertyRegion;
import ru.politexnik.function.region2.BackwardEquation.Border2BC;
import ru.politexnik.function.region2.BackwardEquation.temperaturePS.Zone2A;
import ru.politexnik.function.region2.BackwardEquation.temperaturePS.Zone2B;
import ru.politexnik.function.region2.BackwardEquation.temperaturePS.Zone2C;

public class BackwardEquationTPS {
    public static double temperature(double pressure, double entropy){
        PropertyRegion region = Border2BC.findZoneForPS(pressure, entropy);
        if (region == PropertyRegion.Region2A) {
            return Zone2A.temperature(pressure, entropy);
        } else if (region == PropertyRegion.Region2B) {
            return Zone2B.temperature(pressure, entropy);
        } else {
            return Zone2C.temperature(pressure, entropy);
        }
    }
}
