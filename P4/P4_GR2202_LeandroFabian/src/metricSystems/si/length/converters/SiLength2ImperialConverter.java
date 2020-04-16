package metricSystems.si.length.converters;

import metricSystems.MetricSystemConverter;
import metricSystems.imperial.length.ImperialLengthMetricSystem;
import metricSystems.si.length.SiLengthMetricSystem;

/**
 * Implements a converter from SI length metric system to Imperial length metric system.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class SiLength2ImperialConverter extends MetricSystemConverter {
    public SiLength2ImperialConverter() {
        super(3.280839895, SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM);
    }
}
