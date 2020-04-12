package metricSystems.si.length;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.si.length.SiLength;

import java.util.Arrays;

/**
 * Implements the SI length metric system.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class SiLengthMetricSystem extends MetricSystem {
    public static final IPhysicalUnit KILOMETER = new SiLength("km", 1000);
    public static final IPhysicalUnit METER = new SiLength("m", 1);
    public static final IPhysicalUnit MILIMETER = new SiLength("mm", 0.001);
    public static final IMetricSystem SYSTEM = new SiLengthMetricSystem();

    private SiLengthMetricSystem() {
        super(METER, Arrays.asList(KILOMETER, METER, MILIMETER));
    }

    /**
     * Registers a converter between the SILengthMetricSystem and another length metric system.
     * The converter is added to both systems' converters set
     * @param c the converter to register
     * @return if the converter was registered successfully
     */
    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == SYSTEM) {
            return SiLengthMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
