package ru.politexnik.IF97Library.function.region2;

import ru.politexnik.IF97Library.function.Constants;

public class MetastableVaporRegionSupplEquation {
    private static double p_ = 1e+6;
    private static double t_ = 540;
    private static double R = Constants.specificGasConstant;

    private static double nO[] = {0,
            -0.96937268393049e+1,
            0.10087275970006e+2,
            -0.56087911283020e-2,
            0.71452738081455e-1,
            -0.40710498223928,
            0.14240819171444e+1,
            -0.43839511319450e+1,
            -0.28408632460772,
            0.21268463753307e-1
    };

    private static double[] JO = {0,
            0,
            1,
            -5,
            -4,
            -3,
            -2,
            -1,
            2,
            3,
    };

    private static double gammaO(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += nO[i] * Math.pow(tau, JO[i]);
        }
        return Math.log(pi) + sum;
    }

    private static double gammaOPi(double pi, double tau) {
        return 1 / pi;
    }

    private static double gammaOPiPi(double pi, double tau) {
        return -1 / Math.pow(pi, 2);
    }

    private static double gammaOTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += nO[i] * JO[i] * Math.pow(tau, JO[i] - 1);
        }
        return sum;
    }

    private static double gammaOTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += nO[i] * JO[i] * (JO[i] - 1) * Math.pow(tau, JO[i] - 2);
        }
        return sum;
    }

    private static double gammaOPiTau(double pi, double tau) {
        return 0;
    }

    private static double n[] = {0,
            -0.73362260186506e-2,
            -0.88223831943146e-1,
            -0.72334555213245e-1,
            -0.40813178534455e-2,
            0.20097803380207e-2,
            -0.53045921898642e-1,
            -0.76190409086970e-2,
            -0.63498037657313e-2,
            -0.86043093028588e-1,
            0.75321581522770e-2,
            -0.79238375446139e-2,
            -0.22888160778447e-3,
            -0.26456501482810e-2,

    };

    private static double[] I = {0,
            1,
            1,
            1,
            1,
            2,
            2,
            2,
            3,
            3,
            4,
            4,
            5,
            5,

    };

    private static double[] J = {0,
            0,
            2,
            5,
            11,
            1,
            7,
            16,
            4,
            16,
            7,
            10,
            9,
            10,
    };

    private static double gammaR(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * I[i] * Math.pow(pi, I[i] - 1) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * Math.pow(tau - 0.5, J[i] - 1);
        }
        return sum;
    }

    private static double gammaRPiPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * I[i] * (I[i] - 1) * Math.pow(pi, I[i] - 2) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * (J[i] - 1) * Math.pow(tau - 0.5, J[i] - 2);
        }
        return sum;
    }

    private static double gammaRPiTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n[i] * I[i] * Math.pow(pi, I[i] - 1) * J[i] * Math.pow(tau - 0.5, J[i] - 1);
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
