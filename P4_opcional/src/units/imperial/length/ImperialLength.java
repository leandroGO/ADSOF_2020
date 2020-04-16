package units.imperial.length;

import metricSystems.IMetricSystem;
import metricSystems.imperial.length.ImperialLengthMetricSystem;
import units.Length;

public class ImperialLength extends Length {
    public ImperialLength(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return ImperialLengthMetricSystem.SYSTEM;
    }
}
