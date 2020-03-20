package units;

public enum Quantity {
    L, t;

    @Override
    public String toString() {
        switch (this) {
            case L: return "L";
            case t: return "t";
            default: return "Unknown";
        }
    }
}
