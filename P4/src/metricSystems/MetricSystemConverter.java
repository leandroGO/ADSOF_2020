package metricSystems;

import magnitude.IMagnitude;
import magnitude.Magnitude;
import magnitude.exceptions.QuantityException;
import magnitude.exceptions.UnknownUnitException;
import units.IPhysicalUnit;

public class MetricSystemConverter implements IMetricSystemConverter{
    IMetricSystem source;
    IMetricSystem target;
    private double factor;

    public MetricSystemConverter(double factor, IMetricSystem source, IMetricSystem target) {
        this.source = source;
        this.target = target;
        this.factor = factor;
    }

    @Override
    public IMetricSystem sourceSystem() {
        return source;
    }

    @Override
    public IMetricSystem targetSystem() {
        return target;
    }

    @Override
    public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException {
        IMagnitude a, b;
        IMetricSystemConverter c;

        try {
            a = from.transformTo(from.getUnit().getMetricSystem().base());
        } catch (QuantityException e) {
            throw new UnknownUnitException(from.getUnit(), to);
        }

        b = new Magnitude(a.getValue()*factor, to.getMetricSystem().base());

        try {
            return b.transformTo(to);
        } catch(QuantityException e) {
            throw new UnknownUnitException(from.getUnit(), to);
        }
    }

    @Override
    public IMetricSystemConverter reverse() {
        return new MetricSystemConverter(1/factor, target, source);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IMetricSystemConverter) {
            return source == ((IMetricSystemConverter)o).sourceSystem() &&
                    target == ((IMetricSystemConverter)o).targetSystem();
        }
        return false;
    }
}
