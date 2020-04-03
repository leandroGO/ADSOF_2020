package metricSystems.imperial.length;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Length;

import java.util.Arrays;

public class ImperialLengthMetricSystem extends Length {
    public static final IPhysicalUnit MILE = new ImperialLengthMetricSystem("mi");
    public static final IPhysicalUnit FOOT = new ImperialLengthMetricSystem("ft");
    public static final IPhysicalUnit INCH = new ImperialLengthMetricSystem("in");
    public static final IMetricSystem SYSTEM = new MetricSystem(INCH, Arrays.asList(INCH, FOOT, MILE));

    private ImperialLengthMetricSystem(String abbr) {
        super(abbr);
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        super.transformTo(d,u); //hace comprobaciones generales arriba
        return 0;
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SYSTEM;
    }
}
