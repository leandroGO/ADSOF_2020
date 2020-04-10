package metricSystems.si.length.converters;

import metricSystems.MetricSystemConverter;
import metricSystems.imperial.length.ImperialLengthMetricSystem;
import metricSystems.si.length.SiLengthMetricSystem;

public class SiLength2ImperialConverter extends MetricSystemConverter {
    public SiLength2ImperialConverter() {
        super(3.280839895, SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM);
    }
}
