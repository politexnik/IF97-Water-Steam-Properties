package ru.politexnik.IF97Library.function.region2;

import ru.politexnik.IF97Library.function.region2.BackwardEquation.Border2BC;
import ru.politexnik.IF97Library.function.region2.BackwardEquation.temperaturePH.Zone2A;
import ru.politexnik.IF97Library.function.region2.BackwardEquation.temperaturePH.Zone2B;
import ru.politexnik.IF97Library.function.region2.BackwardEquation.temperaturePH.Zone2C;
import ru.politexnik.IF97Library.function.PropertyRegion;

public class BackwardEquationTPH {
    public static double temperature(double pressure, double enthalpy){
        PropertyRegion region = Border2BC.findZoneForPH(pressure, enthalpy);
            if (region == PropertyRegion.Region2A) {
                return Zone2A.temperature(pressure, enthalpy);
            } else if (region == PropertyRegion.Region2B) {
                return Zone2B.temperature(pressure, enthalpy);
            } else {
                return Zone2C.temperature(pressure, enthalpy);
            }
    }
}
