package Function.Boundary;

public class SaturationLine {
    private static double n[] = {0,
            0.11670521452767e+4,
            -0.72421316703206e+6,
            -0.17073846940092e+2,
            0.12020824702470e+5,
            -0.32325550322333e+7,
            0.14915108613530e+2,
            -0.48232657361591e+4,
            0.40511340542057e+6,
            -0.23855557567849,
            0.65017534844798e+3};

    public static double pressure(double temperature) {
        if (temperature >= 273.15 && temperature <= 647.096) {
            double tetha = temperature + n[9] / (temperature - n[10]);
            double A = tetha * tetha + n[1] * tetha + n[2];
            double B = n[3] * tetha * tetha + n[4] * tetha + n[5];
            double C = n[6] * tetha * tetha + n[7] * tetha + n[8];

            return Math.pow(2 * C / (-B + Math.pow(B * B - 4 * A * C, 0.5)), 4) * 1e6;
        }
        return 0;
    }

    public static double temperature(double pressure) {
        if (pressure >= pressure(273.15) && pressure <= pressure(647.096)) {
            double p_ = 1e+6;
            double beta = Math.pow(pressure / p_, 0.25);
            double E = beta * beta + n[3] * beta + n[6];
            double F = n[1] * beta * beta + n[4] * beta + n[7];
            double G = n[2] * beta * beta + n[5] * beta + n[8];
            double D = 2 * G / (-F - Math.pow(F * F - 4 * E * G, 0.5));
            return (n[10] + D - Math.pow(Math.pow(n[10] + D, 2) - 4 * (n[9] + n[10] * D), 0.5)) / 2;
        }
        return 0;
    }
}
