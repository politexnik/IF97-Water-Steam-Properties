package Function.Region5;

import Function.Constants;

public class BasicEquation {
    private static double p_ = 1e+6;
    private static double t_ = 1000;
    private static double R = Constants.specificGasConstant;

    private static double[] nO = {0,
            -0.13179983674201e+2,
            0.68540841634434e+1,
            -0.24805148933466e-1,
            0.36901534980333,
            -0.31161318213925e+1,
            -0.32961626538917
    };

    private static double[] JO = {0,
            0,
            1,
            -3,
            -2,
            -1,
            2
    };

    private static double[] n = {0,
            0.15736404855259e-2,
            0.90153761673944e-3,
            -0.50270077677648e-2,
            0.22440037409485e-5,
            -0.41163275453471e-5,
            0.37919454822955e-7
    };

    private static double[] J = {0,
            1,
            2,
            3,
            3,
            9,
            7
    };

    private static double[] I = {0,
            1,
            1,
            1,
            2,
            2,
            3
    };

    private static double gammaO(double pi, double tau) {
        double sum = Math.log(pi);
        for (int i = 1; i <= 6; i++) {
            sum += nO[i] * Math.pow(tau, JO[i]);
        }
        return sum;
    }

    private static double gammaOPi(double pi, double tau) {
        return 1 / pi;
    }

    private static double gammaOPiPi(double pi, double tau) {
        return -1 / (pi * pi);
    }

    private static double gammaOTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += nO[i] * JO[i] * Math.pow(tau, JO[i] - 1);
        }
        return sum;
    }

    private static double gammaOTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += nO[i] * JO[i] * (JO[i] - 1) * Math.pow(tau, JO[i] - 2);
        }
        return sum;
    }

    private static double gammaOPiTau(double pi, double tau) {
        return 0;
    }

    private static double gammaR(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double gammaRPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * I[i] * Math.pow(pi, I[i] - 1) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double gammaRPiPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * I[i] * (I[i] - 1) * Math.pow(pi, I[i] - 2) * Math.pow(tau, J[i]);
        }
        return sum;
    }

    private static double gammaRTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * Math.pow(tau, J[i] - 1);
        }
        return sum;
    }

    private static double gammaRTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * (J[i] - 1) * Math.pow(tau, J[i] - 2);
        }
        return sum;
    }

    private static double gammaRPiTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += n[i] * I[i] * Math.pow(pi, I[i] - 1) * J[i] * Math.pow(tau, J[i] - 1);
        }
        return sum;
    }

    public static double volume(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return pi * (gammaOPi(pi, tau) + gammaRPi(pi, tau)) * R * temperature / pressure;
    }

    public static double internalEnergy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (tau * (gammaOTau(pi, tau) + gammaRTau(pi, tau)) - pi * (gammaOPi(pi, tau) + gammaRPi(pi, tau))) * R * temperature;
    }

    public static double entropy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (tau * (gammaOTau(pi, tau) + gammaRTau(pi, tau)) - (gammaO(pi, tau) + gammaR(pi, tau))) * R;
    }

    public static double enthalpy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return tau * (gammaOTau(pi, tau) + gammaRTau(pi, tau)) * R * temperature;
    }

    public static double isobaricHeatCapacity(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return -tau * tau * (gammaOTauTau(pi, tau) + gammaRTauTau(pi, tau)) * R;
    }

    public static double isochoricHeatCapacity(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (-tau * tau * (gammaOTauTau(pi, tau) + gammaRTauTau(pi, tau))
                - Math.pow(1 + pi * gammaRPi(pi, tau) - tau * pi * gammaRPiTau(pi, tau)  , 2) / (1 - pi * pi * gammaRPiPi(pi, tau))) * R;
    }

    public static double speedOfSound(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return Math.sqrt(( (1 + 2 * pi * gammaRPi(pi, tau) + pi * pi * Math.pow(gammaRPi(pi,tau), 2)) /
                (1 - pi * pi * gammaRPiPi(pi, tau)
                        + Math.pow(1 + pi * gammaRPi(pi, tau) - tau * pi * gammaRPiTau(pi, tau) , 2) / (tau * tau * (gammaOTauTau(pi, tau) + gammaRTauTau(pi, tau)))
                )) * R * temperature);
    }



}
