package ru.politexnik.function.boundary;

public class RegionBetween2And3 {
    private static double[] boundaryRegions2And3Coeffiсiens = {  0,
            0.34805185628969e+3,
            -0.11671859879975e+1,
            0.10192970039326e-2,
            0.57254459862746e+3,
            0.13918839778870e+2 };

    public static double boundaryTemperatureBetweenRegions2And3(double pressure) {
        if (pressure >= 16.5291643e6 && pressure <= 100e6) {
            double[] n = boundaryRegions2And3Coeffiсiens;
            double t_ = 1;   // t* = 1K
            double p_ = 1e+6;   //p* = 1МПа
            double pi = pressure/p_ ;   //относительное давление

            double tetha = n[4] + Math.pow((pi - n[5]) / n[3], 0.5);  //      T/T*
            return tetha*t_;
        }
        return 0;
    }

    public static double boundaryPressureBetweenRegions2And3(double temperature) {
        if (temperature>=623.15 && temperature<=863.15) {
            double[] n = boundaryRegions2And3Coeffiсiens;
            double t_ = 1;   // t* = 1K
            double p_ = 1e+6;   //p* = 1МПа
            double tetha = temperature/t_;

            double pi = n[1] + n[2]* tetha+ n[3]* Math.pow(tetha,2);    //относительное давление
            return pi*p_;
        }
        return 0;
    }
}
