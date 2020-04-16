package units;

public abstract class Time extends PhysicalUnit {
    public Time(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.t;
    }
}
