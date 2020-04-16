package metricSystems.imperial.length;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.imperial.length.ImperialLength;

import java.util.Arrays;

/**
 * Implements the Imperial length metric system.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class ImperialLengthMetricSystem extends MetricSystem {
    public static final IPhysicalUnit MILE = new ImperialLength("mi", 5280);
    public static final IPhysicalUnit FOOT = new ImperialLength("ft", 1);
    public static final IPhysicalUnit INCH = new ImperialLength("in", 1./12);
    public static final IMetricSystem SYSTEM = new ImperialLengthMetricSystem();

    private ImperialLengthMetricSystem() {
        super(FOOT, Arrays.asList(MILE, FOOT, INCH));
    }

    /**
     * Registers a converter between the ImperialLengthMetricSystem and another length metric system.
     * The converter is added to both systems' converters set
     * @param c the converter to register
     * @return if the converter was registered successfully
     */
    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == ImperialLengthMetricSystem.SYSTEM) {
            return ImperialLengthMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
