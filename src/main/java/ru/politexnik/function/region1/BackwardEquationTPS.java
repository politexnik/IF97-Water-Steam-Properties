package ru.politexnik.function.region1;

public class BackwardEquationTPS {
    private static double[] n = {0,
            0.17478268058307e+3,
            0.34806930892873e+2,
            0.65292584978455e+1,
            0.33039981775489,
            -0.19281382923196e-6,
            -0.24909197244573e-22,
            -0.26107636489332,
            0.22592965981586,
            -0.64256463395226e-1,
            0.78876289270526e-2,
            0.35672110607366e-9,
            0.17332496994895e-23,
            0.56608900654837e-3,
            -0.32635483139717e-3,
            0.44778286690632e-4,
            -0.51322156908507e-9,
            -0.42522657042207e-25,
            0.26400441360689e-12,
            0.78124600459723e-28,
            -0.30732199903668e-30
    };

    private static double[] I = {0,
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
            4,
    };

    private static double[] J = {0,
            0,
            1,
            2,
            3,
            11,
            31,
            0,
            1,
            2,
            3,
            12,
            31,
            0,
            1,
            2,
            9,
            31,
            10,
            32,
            32,
    };

    public static double temperature(double pressure, double entropy) {
        double p_ = 1e+6;           //1МПа
        double pi = pressure / p_;
        double s_ = 1e+3;            // 1 кДж/(кг·К)
        double sigma = entropy / s_;
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(sigma + 2, J[i]);
        }
        return sum;
    }
}
