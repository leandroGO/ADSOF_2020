package metricSystems.si.length;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;
import units.Quantity;

public enum SiLengthMetricSystem implements IPhysicalUnit {
    METER("m"), MILIMETER("mm"), KILOMETER("km");

    private final String abbr;
    private final Quantity q = Quantity.L;
    SiLengthMetricSystem(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public boolean canTransformTo(IPhysicalUnit u) {
        return false;
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        return 0;
    }

    @Override
    public Quantity getQuantity() {
        return q;
    }

    @Override
    public String abbrev() {
        return abbr;
    }
}
