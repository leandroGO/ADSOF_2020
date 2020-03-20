package units;

public abstract class Time extends PhysicalUnit {
    public Time(String abbr) {
        super(abbr);
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.t;
    }
}
