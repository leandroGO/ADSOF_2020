package units;

public enum Quantity {
    L, t, Composite, Unknown;

    @Override
    public String toString() {
        switch (this) {
            case L: return "L";
            case t: return "t";
            case Composite: return "Composite";
            default: return "Unknown";
        }
    }
}
