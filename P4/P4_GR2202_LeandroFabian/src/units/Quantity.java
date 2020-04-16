package units;

/**
 * Defines multiple physical quantities.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
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
