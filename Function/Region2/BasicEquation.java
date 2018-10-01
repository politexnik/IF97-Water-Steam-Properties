package Function.Region2;

import Function.Constants;


public class BasicEquation {
    private static double p_ = 1e+6;
    private static double t_ = 540;
    private static double R = Constants.specificGasConstant;

    private static double nO[] = {0,
            -0.96927686500217e+1,
            0.10086655968018e+2,
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
            -0.17731742473213e-2,
            -0.17834862292358e-1,
            -0.45996013696365e-1,
            -0.57581259083432e-1,
            -0.50325278727930e-1,
            -0.33032641670203e-4,
            -0.18948987516315e-3,
            -0.39392777243355e-2,
            -0.43797295650573e-1,
            -0.26674547914087e-4,
            0.20481737692309e-7,
            0.43870667284435e-6,
            -0.32277677238570e-4,
            -0.15033924542148e-2,
            -0.40668253562649e-1,
            -0.78847309559367e-9,
            0.12790717852285e-7,
            0.48225372718507e-6,
            0.22922076337661e-5,
            -0.16714766451061e-10,
            -0.21171472321355e-2,
            -0.23895741934104e+2,
            -0.59059564324270e-17,
            -0.12621808899101e-5,
            -0.38946842435739e-1,
            0.11256211360459e-10,
            -0.82311340897998e+1,
            0.19809712802088e-7,
            0.10406965210174e-18,
            -0.10234747095929e-12,
            -0.10018179379511e-8,
            -0.80882908646985e-10,
            0.10693031879409,
            -0.33662250574171,
            0.89185845355421e-24,
            0.30629316876232e-12,
            -0.42002467698208e-5,
            -0.59056029685639e-25,
            0.37826947613457e-5,
            -0.12768608934681e-14,
            0.73087610595061e-28,
            0.55414715350778e-16,
            -0.94369707241210e-6
    };

    private static double I[] = {0,
            1,
            1,
            1,
            1,
            1,
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
            5,
            6,
            6,
            6,
            7,
            7,
            7,
            8,
            8,
            9,
            10,
            10,
            10,
            16,
            16,
            18,
            20,
            20,
            20,
            21,
            22,
            23,
            24,
            24,
            24
    };

    private static double J[] = {0,
            0,
            1,
            2,
            3,
            6,
            1,
            2,
            4,
            7,
            36,
            0,
            1,
            3,
            6,
            35,
            1,
            2,
            3,
            7,
            3,
            16,
            35,
            0,
            11,
            25,
            8,
            36,
            13,
            4,
            10,
            14,
            29,
            50,
            57,
            20,
            35,
            48,
            21,
            53,
            39,
            26,
            40,
            58,
    };

    private static double gammaR(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
            sum += n[i] * I[i] * Math.pow(pi, I[i] - 1) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * Math.pow(tau - 0.5, J[i] - 1);
        }
        return sum;
    }

    private static double gammaRPiPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
            sum += n[i] * I[i] * (I[i] - 1) * Math.pow(pi, I[i] - 2) * Math.pow(tau - 0.5, J[i]);
        }
        return sum;
    }

    private static double gammaRTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * J[i] * (J[i] - 1) * Math.pow(tau - 0.5, J[i] - 2);
        }
        return sum;
    }

    private static double gammaRPiTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 43; i++) {
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
