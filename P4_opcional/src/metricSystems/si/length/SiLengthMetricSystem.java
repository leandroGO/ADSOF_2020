package metricSystems.si.length;

import metricSystems.IMetricSystem;
import metricSystems.IMetricSystemConverter;
import metricSystems.MetricSystem;
import units.IPhysicalUnit;
import units.si.length.SiLength;

import java.util.Arrays;

public class SiLengthMetricSystem extends MetricSystem {
    public static final IPhysicalUnit KILOMETER = new SiLength("km", 1000);
    public static final IPhysicalUnit METER = new SiLength("m", 1);
    public static final IPhysicalUnit MILIMETER = new SiLength("mm", 0.001);
    public static final IMetricSystem SYSTEM = new SiLengthMetricSystem();

    private SiLengthMetricSystem() {
        super(METER, Arrays.asList(KILOMETER, METER, MILIMETER));
    }

    public static boolean registerConverter(IMetricSystemConverter c) {
        if (c.sourceSystem() == SYSTEM) {
            return SiLengthMetricSystem.SYSTEM.addConverter(c) && c.targetSystem().addConverter(c.reverse());
        }
        return false;
    }
}
