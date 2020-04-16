package metricSystems.si.time;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.si.time.SiTime;

import java.util.Arrays;

/**
 * Implements the SI time metric system.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class SiTimeMetricSystem extends MetricSystem {
    public static final IPhysicalUnit HOUR = new SiTime("h", 3600);
    public static final IPhysicalUnit SECOND = new SiTime("s", 1);
    public static final IPhysicalUnit MILISECOND = new SiTime("ms", 0.001);
    public static final IMetricSystem SYSTEM = new SiTimeMetricSystem();

    private SiTimeMetricSystem() {
        super(SECOND, Arrays.asList(HOUR, SECOND, MILISECOND));
    }

    /**
     * Registers a converter between the SITimeMetricSystem and another time metric system.
     * The converter is added to both systems' converters set
     * @param c the converter to register
     * @return if the converter was registered successfully
     */
    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == SYSTEM) {
            return SiTimeMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
