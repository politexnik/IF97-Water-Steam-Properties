package ru.politexnik.IF97Library.function.region2.BackwardEquation.temperaturePH;

public class Zone2C {
    private static double p_ = 1e+6;    //1МПа
    private static double h_ = 2e+6;    // 2000 кДж/кг

    private static double[] n = {0,
            -0.32368398555242e+13,
            0.73263350902181e+13,
            0.35825089945447e+12,
            -0.58340131851590e+12,
            -0.10783068217470e+11,
            0.20825544563171e+11,
            0.61074783564516e+6,
            0.85977722535580e+6,
            -0.25745723604170e+5,
            0.31081088422714e+5,
            0.12082315865936e+4,
            0.48219755109255e+3,
            0.37966001272486e+1,
            -0.10842984880077e+2,
            -0.45364172676660e-1,
            0.14559115658698e-12,
            0.11261597407230e-11,
            -0.17804982240686e-10,
            0.12324579690832e-6,
            -0.11606921130984e-5,
            0.27846367088554e-4,
            -0.59270038474176e-3,
            0.12918582991878e-2

    };

    public static double[] I = {0,
            -7,
            -7,
            -6,
            -6,
            -5,
            -5,
            -2,
            -2,
            -1,
            -1,
            0,
            0,
            1,
            1,
            2,
            6,
            6,
            6,
            6,
            6,
            6,
            6,
            6,
    };

    public static double[] J = {0,
            0,
            4,
            0,
            2,
            0,
            2,
            0,
            1,
            0,
            2,
            0,
            1,
            4,
            8,
            4,
            0,
            1,
            4,
            10,
            12,
            16,
            20,
            22
    };

    public static double temperature(double pressure, double enthalpy) {
        double nu = enthalpy / h_;
        double pi = pressure / p_;
        double sum = 0;
        for (int i = 1; i <= 23; i++) {
            sum += n[i] * Math.pow(pi + 25, I[i]) * Math.pow(nu - 1.8, J[i]);
        }
        return sum;
    }
}
