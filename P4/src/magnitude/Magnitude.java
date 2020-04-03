package magnitude;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;

public class Magnitude implements IMagnitude {
    private double value;
    private IPhysicalUnit unit;

    public Magnitude(double value, IPhysicalUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public IMagnitude add(IMagnitude m) throws QuantityException {
        return new Magnitude(m.transformTo(this.getUnit()).getValue() + this.getValue(),
                this.getUnit());
    }

    @Override
    public IMagnitude subs(IMagnitude m) throws QuantityException {
        return new Magnitude(m.transformTo(this.getUnit()).getValue() - this.getValue(),
                this.getUnit());
    }

    @Override
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException {
        return new Magnitude(getUnit().transformTo(value,c), c);
    }

    @Override
    public IPhysicalUnit getUnit() {
        return unit;
    }

    @Override
    public double getValue() {
        return value;
    }
}
