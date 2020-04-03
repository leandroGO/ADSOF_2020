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
        return new Magnitude(this.getValue() + m.transformTo(this.getUnit()).getValue(),
                this.getUnit());
    }

    @Override
    public IMagnitude subs(IMagnitude m) throws QuantityException {
        return new Magnitude(this.getValue() - m.transformTo(this.getUnit()).getValue(),
                this.getUnit());
    }

    @Override
    public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException {
        return new Magnitude(getUnit().transformTo(value,c), c);    //transformTo does error control
    }

    @Override
    public IPhysicalUnit getUnit() {
        return unit;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " [" + unit + "]";
    }
}
