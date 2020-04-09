package metricSystems.si.time;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.SiTime;

import java.util.Arrays;

public class SiTimeMetricSystem extends MetricSystem {
    public static final IPhysicalUnit HOUR = new SiTime("h", 60);
    public static final IPhysicalUnit SECOND = new SiTime("s", 1);
    public static final IPhysicalUnit MILISECOND = new SiTime("ms", 0.001);
    public static final IMetricSystem SYSTEM = new SiTimeMetricSystem();

    private SiTimeMetricSystem() {
        super(SECOND, Arrays.asList(HOUR, SECOND, MILISECOND));
    }

    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == SYSTEM) {
            return SiTimeMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
