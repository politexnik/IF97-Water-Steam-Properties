package ru.politexnik.IF97Library.function.region3;


import ru.politexnik.IF97Library.function.Constants;

public class BasicEquation {
    public static double ro_ = Constants.criticalDensity;
    public static double t_ = Constants.criticalTemperature;
    public static double R = Constants.specificGasConstant;

    private static double[] n = {0,
            1.0658070028513E+00,
                    -1.5732845290239E+01,
            2.0944396974307E+01,
                    -7.6867707878716E+00,
            2.6185947787954E+00,
                    -2.8080781148620E+00,
            1.2053369696517E+00,
                    -8.4566812812502E-03,
                    -1.2654315477714E+00,
                    -1.1524407806681E+00,
            8.8521043984318E-01,
                    -6.4207765181607E-01,
            3.8493460186671E-01,
                    -8.5214708824206E-01,
            4.8972281541877E+00,
                    -3.0502617256965E+00,
            3.9420536879154E-02,
            1.2558408424308E-01,
                    -2.7999329698710E-01,
            1.3899799569460E+00,
                    -2.0189915023570E+00,
                    -8.2147637173963E-03,
                    -4.7596035734923E-01,
            4.3984074473500E-02,
                    -4.4476435428739E-01,
            9.0572070719733E-01,
            7.0522450087967E-01,
            1.0770512626332E-01,
                    -3.2913623258954E-01,
                    -5.0871062041158E-01,
                    -2.2175400873096E-02,
            9.4260751665092E-02,
            1.6436278447961E-01,
                    -1.3503372241348E-02,
                    -1.4834345352472E-02,
            5.7922953628084E-04,
            3.2308904703711E-03,
            8.0964802996215E-05,
                    -1.6557679795037E-04,
                    -4.4923899061815E-05
    };

    private static double[] I = {0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            1,
            1,
            1,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
            3,
            3,
            3,
            3,
            4,
            4,
            4,
            4,
            5,
            5,
            5,
            6,
            6,
            6,
            7,
            8,
            9,
            9,
            10,
            10,
            11
    };

    private static double[] J = {0,
            0,
            0,
            1,
            2,
            7,
            10,
            12,
            23,
            2,
            6,
            15,
            17,
            0,
            2,
            6,
            7,
            22,
            26,
            0,
            2,
            4,
            16,
            26,
            0,
            2,
            4,
            26,
            1,
            3,
            26,
            0,
            2,
            26,
            2,
            26,
            2,
            26,
            0,
            1,
            26
    };

    private static double phi(double delta, double tau) {
        double sum = n[1] * Math.log(delta);
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * Math.pow(delta, I[i]) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double phiDelta(double delta, double tau) {
        double sum = n[1] / delta;
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * I[i] * Math.pow(delta, I[i] - 1) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double phiTau(double delta, double tau) {
        double sum = 0;
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * Math.pow(delta, I[i]) * J[i] * Math.pow(tau, J[i] - 1);
        }
        return sum;
    }

    private static double phiDeltaDelta(double delta, double tau) {
        double sum = -n[1] / (delta * delta);
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * I[i] * (I[i] - 1) * Math.pow(delta, I[i] - 2) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double phiTauTau(double delta, double tau) {
        double sum = 0;
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * Math.pow(delta, I[i]) * J[i] * (J[i] - 1) * Math.pow(tau, J[i] - 2);
        }
        return sum;
    }

    private static double phiDeltaTau(double delta, double tau) {
        double sum = 0;
        for (int i = 2; i <= 40; i++) {
            sum += n[i] * I[i] * Math.pow(delta, I[i] - 1) * J[i] * Math.pow(tau, J[i] - 1);
        }
        return sum;
    }

    public static double pressure(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return delta * phiDelta(delta, tau) * density * R * temperature;
    }

    public static double internalEnergy(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return tau * phiTau(delta, tau) * R * temperature;
    }

    public static double entropy(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return (tau * phiTau(delta, tau) - phi(delta, tau)) * R;
    }

    public static double enthalpy(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return (tau * phiTau(delta, tau) + delta * phiDelta(delta, tau)) * R * temperature;
    }

    public static double isochoricHeatCapacity(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return -tau * tau * phiTauTau(delta, tau) * R;
    }

    public static double isobaricHeatCapacity(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return (-tau * tau * phiTauTau(delta, tau) + Math.pow(delta * phiDelta(delta, tau) - delta * tau * phiDeltaTau(delta, tau), 2) /
                (2 * delta * phiDelta(delta, tau) + delta * delta * phiDeltaDelta(delta, tau))) * R;
    }

    public static double speedOfSound(double density, double temperature) {
        double delta = density / ro_;
        double tau = t_ / temperature;
        return Math.sqrt((2 * delta * phiDelta(delta, tau) + delta * delta * phiDeltaDelta(delta, tau)
                - Math.pow(delta * phiDelta(delta, tau) - delta * tau * phiDeltaTau(delta, tau), 2) / (tau * tau * phiTauTau(delta, tau))) * R * temperature);
    }
}
