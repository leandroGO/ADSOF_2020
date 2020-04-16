package units;

import magnitude.Magnitude;
import magnitude.exceptions.NotCompositeException;
import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;

public class CompositeUnit implements ICompositeUnit {
    private IPhysicalUnit leftUnit;
    private IPhysicalUnit rightUnit;
    private Operator oper;

    public CompositeUnit(IPhysicalUnit leftUnit, Operator oper, IPhysicalUnit rightUnit) {
        this.leftUnit = leftUnit;
        this.rightUnit = rightUnit;
        this.oper = oper;
    }

    @Override
    public Operator getOperator() {
        return oper;
    }

    @Override
    public IPhysicalUnit getLeftUnit() {
        return leftUnit;
    }

    @Override
    public IPhysicalUnit getRightUnit() {
        return rightUnit;
    }

    @Override
    public boolean canTransformTo(IPhysicalUnit u) {
        ICompositeUnit target;
        if (!(u instanceof ICompositeUnit)) {
            return false;
        }
        target = (ICompositeUnit) u;
        return getLeftUnit().canTransformTo(target.getLeftUnit()) && getRightUnit().canTransformTo(target.getRightUnit());
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        ICompositeUnit aux;

        if (!(u instanceof ICompositeUnit)) {
            throw new NotCompositeException(u);
        }

        aux = (ICompositeUnit) u;
        return d*oper.operate(new Magnitude(1, leftUnit).transformTo(aux.getLeftUnit()).getValue(),
                new Magnitude(1, rightUnit).transformTo(aux.getRightUnit()).getValue());
    }

    @Override
    public Quantity getQuantity() {
        return Quantity.Composite;
    }

    @Override
    public String abbrev() {
        return leftUnit.abbrev() + " " + oper + " " + rightUnit.abbrev();
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return null;
    }

    @Override
    public String toString() {
        return abbrev();
    }
}
