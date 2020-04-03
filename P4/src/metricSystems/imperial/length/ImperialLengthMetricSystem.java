package metricSystems.imperial.length;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Length;

import java.util.Arrays;

public class ImperialLengthMetricSystem extends Length {
    public static final IPhysicalUnit MILE = new ImperialLengthMetricSystem("mi", 5280);
    public static final IPhysicalUnit FOOT = new ImperialLengthMetricSystem("ft", 1);
    public static final IPhysicalUnit INCH = new ImperialLengthMetricSystem("in", 1./12);
    public static final IMetricSystem SYSTEM = new MetricSystem(INCH, Arrays.asList(INCH, FOOT, MILE));

    private ImperialLengthMetricSystem(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SYSTEM;
    }
}
