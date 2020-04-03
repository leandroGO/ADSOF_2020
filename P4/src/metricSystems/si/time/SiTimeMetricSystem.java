package metricSystems.si.time;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Time;

import java.util.Arrays;

public class SiTimeMetricSystem extends Time {
    public static final IPhysicalUnit HOUR = new SiTimeMetricSystem("h", 60);
    public static final IPhysicalUnit SECOND = new SiTimeMetricSystem("s", 1);
    public static final IPhysicalUnit MILISECOND = new SiTimeMetricSystem("ms", 0.001);
    public static final IMetricSystem SYSTEM = new MetricSystem(SECOND, Arrays.asList(HOUR, SECOND, MILISECOND));

    public SiTimeMetricSystem(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SYSTEM;
    }
}
