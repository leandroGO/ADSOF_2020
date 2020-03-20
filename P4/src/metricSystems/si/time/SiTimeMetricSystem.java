package metricSystems.si.time;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;
import units.Time;

public class SiTimeMetricSystem extends Time {
    public static final IPhysicalUnit HOUR = new SiTimeMetricSystem("h");
    public static final IPhysicalUnit SECOND = new SiTimeMetricSystem("s");
    public static final IPhysicalUnit MILISECOND = new SiTimeMetricSystem("ms");

    public SiTimeMetricSystem(String abbr) {
        super(abbr);
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        super.transformTo(d,u); //hace comprobaciones generales arriba
        return 0;
    }
}
