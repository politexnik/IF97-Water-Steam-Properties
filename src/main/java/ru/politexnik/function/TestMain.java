package ru.politexnik.function;

public class TestMain {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println(calc.enthalpy(13e+5, 273.15+280));
    }
}
