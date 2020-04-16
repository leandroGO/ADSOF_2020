package units;

public enum Operator {
    PROD, DIV;

    public double operate(double o1, double o2) {
        switch (this) {
            case PROD: return o1*o2;
            case DIV: return o1/o2;
            default: return o1;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case PROD: return "*";
            case DIV: return "/";
            default: return "?";
        }
    }
}
