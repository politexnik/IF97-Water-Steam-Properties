package Function;

import Function.Region1.BasicEquation;


public class Test {
    public static void main(String[] args) {

        //PropertyRegion e = PropertyRegion.find(123, 123);

        //System.out.println(RegionBetween2And3.boundaryPressureBetweenRegions2And3(623.15));
        //System.out.println(RegionBetween2And3.boundaryTemperatureBetweenRegions2And3(0.165291643e+8));
//        System.out.println(SaturationLine.pressure(300));
//        System.out.println(SaturationLine.pressure(500));
//        System.out.println(SaturationLine.pressure(600));
//        System.out.println(SaturationLine.temperature(0.1e+6));
//        System.out.println(SaturationLine.temperature(1.0e+6));
//        System.out.println(SaturationLine.temperature(10.0e+6));
//        System.out.println(PropertyRegion.find(50e+6,623));

        System.out.println(BasicEquation.isobaricHeatCapacity(3e+6, 300));
        System.out.println(BasicEquation.isobaricHeatCapacity(80e+6, 300));
        System.out.println(BasicEquation.isobaricHeatCapacity(3000000, 500));
    }

}
