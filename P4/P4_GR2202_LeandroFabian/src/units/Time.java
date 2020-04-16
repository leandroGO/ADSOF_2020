package units;

/**
 * Extends PhysicalUnit definition to support time units.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public abstract class Time extends PhysicalUnit {
    public Time(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.t;
    }
}
