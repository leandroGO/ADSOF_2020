package magnitude;

import magnitude.exceptions.QuantityException;
import magnitude.exceptions.UnknownUnitException;
import metricSystems.IMetricSystemConverter;
import units.IPhysicalUnit;

/**
 * Defines a concrete Magnitude (value and unit).
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
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
        IMetricSystemConverter conv;

        if (!unit.getQuantity().equals(c.getQuantity())) {
            throw new QuantityException(unit.getQuantity(), c.getQuantity());
        }

        if (unit.getMetricSystem().equals(c.getMetricSystem())) {
            return new Magnitude(getUnit().transformTo(value,c), c);    //transformTo does error control
        }

        if ((conv = unit.getMetricSystem().getConverter(c.getMetricSystem())) == null) {
            throw new UnknownUnitException(getUnit(), c);
        }
        return conv.transformTo(this, c);
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
