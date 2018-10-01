import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {
    private double[] arrIn;
    private double[] arrOut;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                {new double[]{3e+6, 500e+3}, new double[]{0.391798503e+3}},
//                {new double[]{80e+6, 500e+3}, new double[]{0.378108626e+3}},
//                {new double[]{80e+6, 1500e+3}, new double[]{0.611041229e+3}}
//                {new double[]{3e+6, 0.5e+3}, new double[]{0.307842258e+3}},
//                {new double[]{80e+6, 0.5e+3}, new double[]{0.309979785e+3}},
//                {new double[]{80e+6, 3e+3}, new double[]{0.565899909e+3}}
                //Тест Зоны 2 основное уравнение
//                {new double[]{0.0035e+6, 300}, new double[]{0.394913866e+2, 0.254991145e+4, 0.241169160e+4, 0.852238967e+1, 0.191300162e+1, 0.427920172e+3}},
//                {new double[]{0.0035e+6, 700}, new double[]{0.923015898e+2, 0.333568375e+4, 0.301262819e+4, 0.101749996e+2, 0.208141274e+1, 0.644289068e+3}},
//                {new double[]{30e+6, 700}, new double[]{0.542946619e-2, 0.263149474e+4, 0.246861076e+4, 0.517540298e+1, 0.103505092e+2, 0.480386523e+3}}
                //Тест Зоны 2 Метастабильная область основное уравнение
//                {new double[]{1e+6, 450}, new double[]{0.192516540, 0.276881115e+4, 0.257629461e+4, 0.656660377e+1, 0.276349265e+1, 0.498408101e+3}},
//                {new double[]{1e+6, 440}, new double[]{0.186212297, 0.274015123e+4, 0.255393894e+4, 0.650218759e+1, 0.298166443e+1, 0.489363295e+3}},
//                {new double[]{1.5e+6, 450}, new double[]{0.121685206, 0.272134539e+4, 0.253881758e+4, 0.629170440e+1, 0.362795578e+1, 0.481941819e+3}}
                //Тест Зоны 2 вспомогательное уравнение PH зоны 2А
//                {new double[]{0.001e+6, 3e+6}, new double[]{0.534433241e+3}},
//                {new double[]{3e+6, 3e+6}, new double[]{0.575373370e+3}},
//                {new double[]{3e+6, 4e+6}, new double[]{0.101077577e+4}},
//                //Тест Зоны 2 вспомогательное уравнение PH зоны 2B
//                {new double[]{5e+6, 3.5e+6}, new double[]{0.801299102e+3}},
//                {new double[]{5e+6, 4e+6}, new double[]{0.101531583e+4}},
//                {new double[]{25e+6, 3.5e+6}, new double[]{0.875279054e+3}},
//                //Тест Зоны 2 вспомогательное уравнение PH зоны 2C
//                {new double[]{40e+6, 2.7e+6}, new double[]{0.743056411e+3}},
//                {new double[]{60e+6, 2.7e+6}, new double[]{0.791137067e+3}},
//                {new double[]{60e+6, 3.2e+6}, new double[]{0.882756860e+3}}
//                //Тест Зоны 2 вспомогательное уравнение PS зоны 2A
//                {new double[]{0.1e+6, 7.5e+3}, new double[]{0.399517097e+3 }},
//                {new double[]{0.1e+6, 8e+3}, new double[]{0.514127081e+3}},
//                {new double[]{2.5e+6, 8e+3}, new double[]{0.103984917e+4}},
//                //Тест Зоны 2 вспомогательное уравнение PS зоны 2B
//                {new double[]{8e+6, 6e+3}, new double[]{0.600484040e+3 }},
//                {new double[]{8e+6, 7.5e+3}, new double[]{0.106495556e+4}},
//                {new double[]{90e+6, 6e+3}, new double[]{0.103801126e+4}},
//                //Тест Зоны 2 вспомогательное уравнение PS зоны 2C
//                {new double[]{20e+6, 5.75e+3}, new double[]{0.697992849e+3 }},
//                {new double[]{80e+6, 5.25e+3}, new double[]{0.854011484e+3}},
//                {new double[]{80e+6, 5.75e+3}, new double[]{0.949017998e+3}}
//                //Тест Зоны 3 основное уравнение Ro T
//                {new double[]{500, 650}, new double[]{0.255837018e+8, 0.186343019e+7, 0.181226279e+7, 0.405427273e+4, 0.138935717e+5, 0.502005554e+3}},
//                {new double[]{200, 650}, new double[]{0.222930643e+8, 0.237512401e+7, 0.226365868e+7, 0.485438792e+4, 0.446579342e+5, 0.383444594e+3}},
//                {new double[]{500, 750}, new double[]{0.783095639e+8, 0.225868845e+7, 0.210206932e+7, 0.446971906e+4, 0.634165359e+4, 0.760696041e+3}}
                //Тест Зоны 5 основное уравнение P T
//                {new double[]{0.5e+6, 1500}, new double[]{0.138455090e+1, 0.521976855e+7, 0.452749310e+7, 0.965408875e+4, 0.261609445e+4, 0.917068690e+3}},
//                {new double[]{30e+6, 1500}, new double[]{0.230761299e-1, 0.516723514e+7,  0.447495124e+7, 0.772970133e+4, 0.272724317e+4, 0.928548002e+3}},
//                {new double[]{30e+6, 2000}, new double[]{0.311385219e-1, 0.657122604e+7,  0.563707038e+7, 0.853640523e+4, 0.288569882e+4, 0.106736948e+4}}
        });
    }

    public Test1(double[] arrIn, double[] arrOut) {
        this.arrIn = arrIn;
        this.arrOut = arrOut;
    }

//    Tusk tusk;
//
//    @Before
//    public void init(){
//        tusk = new Tusk();
//    }

    @Test
    public void test1() {
//        Assert.assertEquals( tusk.arrOutAfter4(arrIn), arrOut);
//        Assert.assertArrayEquals(tusk.arrOutAfter4(arrIn), arrOut);
//        Assert.assertEquals(Function.Region1.BackwardEquationTPH.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-5);
//        Assert.assertEquals(Function.Region1.BackwardEquationTPS.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-7);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.volume(arrIn[0], arrIn[1]), arrOut[0], 1e-5);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.enthalpy(arrIn[0], arrIn[1]) / 1000, arrOut[1], 1e-5);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.internalEnergy(arrIn[0], arrIn[1]) / 1000, arrOut[2], 1e-5);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.entropy(arrIn[0], arrIn[1]) / 1000, arrOut[3], 1e-5);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.isobaricHeatCapacity(arrIn[0], arrIn[1]) / 1000, arrOut[4], 1e-5);
//        Assert.assertEquals(Function.Region2.MetastableVaporRegionSupplEquation.speedOfSound(arrIn[0], arrIn[1]), arrOut[5], 1e-5);
        //Тест Зоны 2 вспомогательное уравнение PH зоны 2А
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePH.Zone2A.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-5);
//        //Тест Зоны 2 вспомогательное уравнение PH зоны 2B
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePH.Zone2B.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-7);
//        //Тест Зоны 2 вспомогательное уравнение PH зоны 2C
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePH.Zone2C.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-8);
//        //Тест Зоны 2 вспомогательное уравнение PS зоны 2A
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePS.Zone2A.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-8);
//        //Тест Зоны 2 вспомогательное уравнение PS зоны 2B
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePS.Zone2B.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-8);
//        //Тест Зоны 2 вспомогательное уравнение PS зоны 2С
//        Assert.assertEquals(Function.Region2.BackwardEquation.temperaturePS.Zone2B.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-8);
//        //Тест Зоны 2 вспомогательное уравнение PS
//        Assert.assertEquals(Function.Region2.BackwardEquationTPS.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-5);
//        //Тест Зоны 2 вспомогательное уравнение PH
//        Assert.assertEquals(Function.Region2.BackwardEquationTPH.temperature(arrIn[0], arrIn[1]), arrOut[0], 1e-5);

        //Тест Зоны 2 основное уравнение Ro T
//        Assert.assertEquals(Function.Region3.BasicEquation.pressure(arrIn[0], arrIn[1]), arrOut[0], 1e-1);
//        Assert.assertEquals(Function.Region3.BasicEquation.enthalpy(arrIn[0], arrIn[1]), arrOut[1], 1e-2);
//        Assert.assertEquals(Function.Region3.BasicEquation.internalEnergy(arrIn[0], arrIn[1]), arrOut[2], 1e-2);
//        Assert.assertEquals(Function.Region3.BasicEquation.entropy(arrIn[0], arrIn[1]), arrOut[3], 1e-5);
//        Assert.assertEquals(Function.Region3.BasicEquation.isobaricHeatCapacity(arrIn[0], arrIn[1]), arrOut[4], 1e-3);
//        Assert.assertEquals(Function.Region3.BasicEquation.speedOfSound(arrIn[0], arrIn[1]), arrOut[5], 1e-5);

        //Тест Зоны 5 основное уравнение P T
//        Assert.assertEquals(Function.Region5.BasicEquation.volume(arrIn[0], arrIn[1]), arrOut[0], 1e-8);
//        Assert.assertEquals(Function.Region5.BasicEquation.enthalpy(arrIn[0], arrIn[1]), arrOut[1], 1e-5);
//        Assert.assertEquals(Function.Region5.BasicEquation.internalEnergy(arrIn[0], arrIn[1]), arrOut[2], 1e-5);
//        Assert.assertEquals(Function.Region5.BasicEquation.entropy(arrIn[0], arrIn[1]), arrOut[3], 1e-5);
//        Assert.assertEquals(Function.Region5.BasicEquation.isobaricHeatCapacity(arrIn[0], arrIn[1]), arrOut[4], 1e-8);
//        Assert.assertEquals(Function.Region5.BasicEquation.speedOfSound(arrIn[0], arrIn[1]), arrOut[5], 1e-9);

    }
}