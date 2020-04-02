package metricSystems.si.time;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Time;

import java.util.Arrays;
import java.util.HashSet;

public class SiTimeMetricSystem extends Time {
    public static final IPhysicalUnit HOUR = new SiTimeMetricSystem("h");
    public static final IPhysicalUnit SECOND = new SiTimeMetricSystem("s");
    public static final IPhysicalUnit MILISECOND = new SiTimeMetricSystem("ms");
    public static final IMetricSystem SYSTEM = new MetricSystem(SECOND, new HashSet(Arrays.asList(HOUR, SECOND, MILISECOND)));

    public SiTimeMetricSystem(String abbr) {
        super(abbr);
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        super.transformTo(d,u); //hace comprobaciones generales arriba
        return 0;
    }
}
