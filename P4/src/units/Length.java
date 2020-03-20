package units;

public abstract class Length extends PhysicalUnit {
    public Length(String abbr) {
        super(abbr);
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.L;
    }
}
