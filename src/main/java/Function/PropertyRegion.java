package Function;

public enum PropertyRegion  {Region1("1"), Region2("2"), Region3("3"), Region4("4"), Region5("5");

    private String name;
    private PropertyRegion(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static public PropertyRegion find(double p, double t) {
        return PropertyRegion.Region1;
    }
}
