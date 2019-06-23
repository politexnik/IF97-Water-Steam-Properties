package ru.politexnik.function.region2.BackwardEquation.temperaturePS;

public class Zone2C {
    private static double p_ = 1e+6;    //1МПа
    private static double s_ = 2.9251e+3;    // 2 кДж/(кг·К)

    private static double[] n = {0,
            0.90968501005365e+3    ,
            0.24045667088420e+4		,
            -0.59162326387130e+3	,
            0.54145404128074e+3		,
            -0.27098308411192e+3	,
            0.97976525097926e+3		,
            -0.46966772959435e+3	,
            0.14399274604723e+2		,
            -0.19104204230429e+2	,
            0.53299167111971e+1		,
            -0.21252975375934e+2	,
            -0.31147334413760		,
            0.60334840894623		,
            -0.42764839702509e-1	,
            0.58185597255259e-2		,
            -0.14597008284753e-1   ,
            0.56631175631027e-2    ,
            -0.76155864584577e-4   ,
            0.22440342919332e-3    ,
            -0.12561095013413e-4   ,
            0.63323132660934e-6    ,
            -0.20541989675375e-5   ,
            0.36405370390082e-7    ,
            -0.29759897789215e-8   ,
            0.10136618529763e-7    ,
            0.59925719692351e-11   ,
            -0.20677870105164e-10  ,
            -0.20874278181886e-10  ,
            0.10162166825089e-9    ,
            -0.16429828281347e-9
    };

    public static double[] I = {0,
            -2	,
            -2	,
            -1	,
            0	,
            0	,
            0	,
            0	,
            1	,
            1	,
            1	,
            1	,
            2	,
            2	,
            2	,
            3	,
            3	,
            3	,
            4	,
            4	,
            4	,
            5	,
            5	,
            5	,
            6	,
            6	,
            7	,
            7	,
            7	,
            7	,
            7
    };

    public static double[] J = {0,
            0	,
            1	,
            0	,
            0	,
            1	,
            2	,
            3	,
            0	,
            1	,
            3	,
            4	,
            0	,
            1	,
            2	,
            0	,
            1	,
            5	,
            0	,
            1	,
            4	,
            0	,
            1	,
            2	,
            0	,
            1	,
            0	,
            1	,
            3	,
            4	,
            5
    };

    public static double temperature(double pressure, double entropy) {
        double pi = pressure / p_;
        double sigma = entropy / s_;
        double sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(2 - sigma, J[i]);
        }
        return sum;
    }
}
