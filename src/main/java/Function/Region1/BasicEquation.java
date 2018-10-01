package Function.Region1;

import Function.Constants;

public class BasicEquation {
    private static double p_ = 16.53e+6;
    private static double t_ = 1386;
    private static double R = Constants.specificGasConstant;

    private static double n[] = {0,
            1.4632971213167E-01,
            -8.4548187169114E-01,
            -3.7563603672040E+00,
            3.3855169168385E+00,
            -9.5791963387872E-01,
            1.5772038513228E-01,
            -1.6616417199501E-02,
            8.1214629983568E-04,
            2.8319080123804E-04,
            -6.0706301565874E-04,
            -1.8990068218419E-02,
            -3.2529748770505E-02,
            -2.1841717175414E-02,
            -5.2838357969930E-05,
            -4.7184321073267E-04,
            -3.0001780793026E-04,
            4.7661393906987E-05,
            -4.4141845330846E-06,
            -7.2694996297594E-16,
            -3.1679644845054E-05,
            -2.8270797985312E-06,
            -8.5205128120103E-10,
            -2.2425281908000E-06,
            -6.5171222895601E-07,
            -1.4341729937924E-13,
            -4.0516996860117E-07,
            -1.2734301741641E-09,
            -1.7424871230634E-10,
            -6.8762131295531E-19,
            1.4478307828521E-20,
            2.6335781662795E-23,
            -1.1947622640071E-23,
            1.8228094581404E-24,
            -0.93537087292458e-25
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
            4,
            4,
            4,
            5,
            8,
            8,
            21,
            23,
            29,
            30,
            31,
            32
    };

    private static double[] J = {0,
            -2,
            -1,
            0,
            1,
            2,
            3,
            4,
            5,
            -9,
            -7,
            -1,
            0,
            1,
            3,
            -3,
            0,
            1,
            3,
            17,
            -4,
            0,
            6,
            -5,
            -2,
            10,
            -8,
            -11,
            -6,
            -29,
            -31,
            -38,
            -39,
            -40,
            -41
    };


    private static double gamma(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += n[i] * Math.pow(7.1 - pi, I[i]) * Math.pow(tau - 1.222, J[i]);
        }
        return sum;
    }

    private static double gammaPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += -n[i] * I[i] * Math.pow(7.1 - pi, I[i] - 1) * Math.pow(tau - 1.222, J[i]);
        }
        return sum;
    }

    private static double gammaTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += n[i] * Math.pow(7.1 - pi, I[i]) * J[i] * Math.pow(tau - 1.222, J[i] - 1);
        }
        return sum;
    }

    private static double gammaPiPi(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += n[i] * I[i] * (I[i] - 1) * Math.pow(7.1 - pi, I[i] - 2) * Math.pow(tau - 1.222, J[i]);
        }
        return sum;
    }

    private static double gammaTauTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += n[i] * Math.pow(7.1 - pi, I[i]) * J[i] * (J[i] - 1) * Math.pow(tau - 1.222, J[i] - 2);
        }
        return sum;
    }

    private static double gammaPiTau(double pi, double tau) {
        double sum = 0;
        for (int i = 1; i <= 34; i++) {
            sum += -n[i] * I[i] * Math.pow(7.1 - pi, I[i] - 1) * J[i] * Math.pow(tau - 1.222, J[i] - 1);
        }
        return sum;
    }

    public static double volume(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return pi * gammaPi(pi, tau) * R * temperature / pressure;
    }

    public static double internalEnergy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (tau * gammaTau(pi, tau) - pi * gammaPi(pi, tau)) * R * temperature;
    }

    public static double entropy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (tau * gammaTau(pi, tau) - gamma(pi, tau)) * R;
    }

    public static double enthalpy(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return tau * gammaTau(pi, tau) * R * temperature;
    }

    public static double isobaricHeatCapacity(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return -tau * tau * gammaTauTau(pi, tau) * R;
    }

    public static double isochoricHeatCapacity(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return (-tau * tau * gammaTauTau(pi, tau) + Math.pow(gammaPi(pi, tau) - tau * gammaPiTau(pi, tau), 2) / gammaPiPi(pi, tau)) * R;
    }

    public static double speedOfSound(double pressure, double temperature) {
        double pi = pressure / p_;
        double tau = t_ / temperature;
        return Math.sqrt(( Math.pow(gammaPi(pi, tau), 2) / ( Math.pow(gammaPi(pi, tau)- tau* gammaPiTau(pi, tau),2) /
                ( tau*tau * gammaTauTau(pi, tau) ) -gammaPiPi(pi, tau) ) ) * R * temperature);
    }

}
