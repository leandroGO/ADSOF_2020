package units;

/**
 * Extends PhysicalUnit definition to support length units.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public abstract class Length extends PhysicalUnit {
    public Length(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.L;
    }
}
