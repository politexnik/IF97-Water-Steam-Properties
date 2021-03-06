package ru.politexnik.IF97Library.function.region2.BackwardEquation.temperaturePH;

public class Zone2A {
    private static double p_ = 1e+6;    //1МПа
    private static double h_ = 2e+6;    // 2000 кДж/кг

    private static double[] n = {0,
            0.10898952318288e+4,
            0.84951654495535e+3,
            -0.10781748091826e+3,
            0.33153654801263e+2,
            -0.74232016790248e+1,
            0.11765048724356e+2,
            0.18445749355790e+1,
            -0.41792700549624e+1,
            0.62478196935812e+1,
            -0.17344563108114e+2,
            -0.20058176862096e+3,
            0.27196065473796e+3,
            -0.45511318285818e+3,
            0.30919688604755e+4,
            0.25226640357872e+6,
            -0.61707422868339e-2,
            -0.31078046629583,
            0.11670873077107e+2,
            0.12812798404046e+9,
            -0.98554909623276e+9,
            0.28224546973002e+10,
            -0.35948971410703e+10,
            0.17227349913197e+10,
            -0.13551334240775e+5,
            0.12848734664650e+8,
            0.13865724283226e+1,
            0.23598832556514e+6,
            -0.13105236545054e+8,
            0.73999835474766e+4,
            -0.55196697030060e+6,
            0.37154085996233e+7,
            0.19127729239660e+5,
            -0.41535164835634e+6,
            -0.62459855192507e+2,
    };

    public static double[] I = {0,
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
            1,
            1,
            1,
            2,
            2,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
            3,
            4,
            4,
            4,
            5,
            5,
            5,
            6,
            6,
            7,
    };

    public static double[] J = {0,
            0,
            1,
            2,
            3,
            7,
            20,
            0,
            1,
            2,
            3,
            7,
            9,
            11,
            18,
            44,
            0,
            2,
            7,
            36,
            38,
            40,
            42,
            44,
            24,
            44,
            12,
            32,
            44,
            32,
            36,
            42,
            34,
            44,
            28,
    };

    public static double temperature(double pressure, double enthalpy) {
        double nu = enthalpy / h_;
        double pi = pressure / p_;
        double sum =0;
        for (int i = 1; i <= 34; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(nu - 2.1, J[i]);
        }
        return sum;
    }

}
