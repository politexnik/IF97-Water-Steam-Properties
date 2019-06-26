package ru.politexnik.IF97Library.function;

import java.util.HashMap;
import java.util.Map;

public enum Units {
    PRESSURE_KGS_SM2_gauge("PRESSURE", "кгс/см2(изб)"),
    PRESSURE_KGS_SM2_abs("PRESSURE", "кгс/см2(абс)"),
    PRESSURE_MPA_abs("PRESSURE", "МПа(абс)"),
    PRESSURE_MPA_gauge("PRESSURE", "МПа(изб)"),

    TEMPERATURE_C("TEMPERATURE", "C"),
    TEMPERATURE_K("TEMPERATURE", "K"),

    ENTALPHY_KKAL_KG("ENTALPHY", "ккал/кг"),
    ENTALPHY_KJ_KG("ENTALPHY", "кДж/кг"),

    ENTROPY_KKAL_KG_C("ENTROPY", "ккал/кг·C"),
    ENTROPY_KJ_KG_C("ENTROPY", "кДж/кг·C");

private String unit;
private String unitType;
private double indexA;
private double indexB;

private static Map<String, Double> indexMapA = new HashMap();
private static Map<String, Double> indexMapB = new HashMap();

static {
    indexMapA.put("кгс/см2(изб)", 98066.5);     //Па = A*кгс/см2 + B
    indexMapB.put("кгс/см2(изб)", 101325.0);

    indexMapA.put("кгс/см2(абс)", 98066.5);
    indexMapB.put("кгс/см2(абс)", 0.0);

    indexMapA.put("МПа(изб)", 1000000.0);
    indexMapB.put("МПа(изб)", 101325.0);

    indexMapA.put("МПа(абс)", 98066.5);
    indexMapB.put("МПа(абс)", 0.0);

    indexMapA.put("C", 1.0);
    indexMapB.put("C", 273.15);

    indexMapA.put("K", 1.0);
    indexMapB.put("K", 0.0);

    indexMapA.put("ккал/кг", 4186.8);
    indexMapB.put("ккал/кг", 0.0);

    indexMapA.put("кДж/кг", 1000.0);
    indexMapB.put("кДж/кг", 0.0);

    indexMapA.put("ккал/кг·C", 4186.8);
    indexMapB.put("ккал/кг·C", 0.0);

    indexMapA.put("кДж/кг·C", 1000.0);
    indexMapB.put("кДж/кг·C", 0.0);
}

Units(String unitType, String unit){
    this.unitType = unitType;
    this.unit = unit;
    this.indexA = indexMapA.get(unit);
    this.indexB = indexMapB.get(unit);
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
