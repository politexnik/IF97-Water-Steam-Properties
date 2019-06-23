package ru.politexnik.function.region1;

public class BackwardEquationTPH {
    private static double[] n = {0,
            -0.23872489924521e+3,
            0.40421188637945e+3,
            0.11349746881718e+3,
            -0.58457616048039e+1,
            -0.15285482413140e-3,
            -0.10866707695377e-5,
            -0.13391744872602e+2,
            0.43211039183559e+2,
            -0.54010067170506e+2,
            0.30535892203916e+2,
            -0.65964749423638e+1,
            0.93965400878363e-2,
            0.11573647505340e-6,
            -0.25858641282073e-4,
            -0.40644363084799e-8,
            0.66456186191635e-7,
            0.80670734103027e-10,
            -0.93477771213947e-12,
            0.58265442020601e-14,
            -0.15020185953503e-16
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
            1,
            2,
            2,
            3,
            3,
            4,
            5,
            6
    };

    private static double[] J = {0,
            0,
            1,
            2,
            6,
            22,
            32,
            0,
            1,
            2,
            3,
            4,
            10,
            32,
            10,
            32,
            10,
            32,
            32,
            32,
            32,
    };

    public static double temperature(double pressure, double enthalpy) {
        double h_ = 2500e+3;            //Дж/кг
        double nu = enthalpy / h_;
        double p_ = 1e+6;               //  Па
        double pi = pressure / p_;
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += n[i] * Math.pow(pi, I[i]) * Math.pow(nu + 1, J[i]);
        }
        return sum;
    }

}





















