package metricSystems.si.length;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;
import units.Length;
import units.PhysicalUnit;
import units.Quantity;

public class SiLengthMetricSystem extends Length {
    public static final IPhysicalUnit KILOMETER = new SiLengthMetricSystem("km");
    public static final IPhysicalUnit METER = new SiLengthMetricSystem("m");
    public static final IPhysicalUnit MILIMETER = new SiLengthMetricSystem("mm");

    private SiLengthMetricSystem(String abbr) {
        super(abbr);
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        super.transformTo(d,u); //hace comprobaciones generales arriba
        return 0;
    }
}
