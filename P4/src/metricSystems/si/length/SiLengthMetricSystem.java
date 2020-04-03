package metricSystems.si.length;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.Length;

import java.util.Arrays;

public class SiLengthMetricSystem extends Length {
    public static final IPhysicalUnit KILOMETER = new SiLengthMetricSystem("km");
    public static final IPhysicalUnit METER = new SiLengthMetricSystem("m");
    public static final IPhysicalUnit MILIMETER = new SiLengthMetricSystem("mm");
    public static final IMetricSystem SYSTEM = new MetricSystem(METER, Arrays.asList(KILOMETER, METER, MILIMETER));

    private SiLengthMetricSystem(String abbr) {
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
