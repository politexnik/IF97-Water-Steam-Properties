package ru.politexnik.IF97Library.function;

import java.util.HashMap;
import java.util.Map;

public enum Units {
    PRESSURE_KGS_SM2_gauge("PRESSURE", "кгс/см2(изб)", 98066.5, 101325.0),
    PRESSURE_KGS_SM2_abs("PRESSURE", "кгс/см2(абс)", 98066.5,101325.0),
    PRESSURE_MPA_abs("PRESSURE", "МПа(абс)", 1000000.0, 101325.0),
    PRESSURE_MPA_gauge("PRESSURE", "МПа(изб)", 98066.5, 0.0),

    TEMPERATURE_C("TEMPERATURE", "C", 1.0, 273.15),
    TEMPERATURE_K("TEMPERATURE", "K", 1.0, 0.0),

    ENTALPHY_KKAL_KG("ENTALPHY", "ккал/кг", 4186.8, 0.0),
    ENTALPHY_KJ_KG("ENTALPHY", "кДж/кг", 1000.0, 0.0),

    ENTROPY_KKAL_KG_C("ENTROPY", "ккал/кг·C", 4186.8, 0.0),
    ENTROPY_KJ_KG_C("ENTROPY", "кДж/кг·C", 1000.0, 0.0);

private String unit;
private String unitType;
private double indexA;
private double indexB;

Units(String unitType, String unit, double indexA, double indexB){
    this.unitType = unitType;
    this.unit = unit;
    this.indexA = indexA;
    this.indexB = indexB;
}

    public String getUnit() {
        return unit;
    }

    public String getUnitType() {
        return unitType;
    }

    public double getIndexA() {
        return indexA;
    }

    public double getIndexB() {
        return indexB;
    }
}
