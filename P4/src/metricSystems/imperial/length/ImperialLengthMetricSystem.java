package metricSystems.imperial.length;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;
import units.Length;

public class ImperialLengthMetricSystem extends Length {
    public static final IPhysicalUnit FOOT = new ImperialLengthMetricSystem("ft");

    private ImperialLengthMetricSystem(String abbr) {
        super(abbr);
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        super.transformTo(d,u); //hace comprobaciones generales arriba
        return 0;
    }
}
