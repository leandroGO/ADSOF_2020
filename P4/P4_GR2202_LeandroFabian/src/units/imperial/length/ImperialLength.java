package units.imperial.length;

import metricSystems.IMetricSystem;
import metricSystems.imperial.length.ImperialLengthMetricSystem;
import units.Length;

/**
 * Implements an Imperial System length unit.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class ImperialLength extends Length {
    public ImperialLength(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return ImperialLengthMetricSystem.SYSTEM;
    }
}
