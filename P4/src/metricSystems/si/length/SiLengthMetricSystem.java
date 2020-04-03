package metricSystems.si.length;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Length;

import java.util.Arrays;

public class SiLengthMetricSystem extends Length {
    public static final IPhysicalUnit KILOMETER = new SiLengthMetricSystem("km", 1000);
    public static final IPhysicalUnit METER = new SiLengthMetricSystem("m", 1);
    public static final IPhysicalUnit MILIMETER = new SiLengthMetricSystem("mm", 0.001);
    public static final IMetricSystem SYSTEM = new MetricSystem(METER, Arrays.asList(KILOMETER, METER, MILIMETER));

    private SiLengthMetricSystem(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SYSTEM;
    }
}
