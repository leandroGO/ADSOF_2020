package metricSystems.imperial.length;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.AbstractMetricSystem;
import units.IPhysicalUnit;
import units.ImperialLength;

import java.util.Arrays;

public class ImperialLengthMetricSystem extends AbstractMetricSystem {
    public static final IPhysicalUnit MILE = new ImperialLength("ml", 5280);
    public static final IPhysicalUnit FOOT = new ImperialLength("ft", 1);
    public static final IPhysicalUnit INCH = new ImperialLength("in", 1./12);
    public static final IMetricSystem SYSTEM = new ImperialLengthMetricSystem();

    private ImperialLengthMetricSystem() {
        super(FOOT, Arrays.asList(MILE, FOOT, INCH));
    }

    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == ImperialLengthMetricSystem.SYSTEM) {
            return ImperialLengthMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
