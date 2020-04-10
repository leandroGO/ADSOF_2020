package units;

import metricSystems.IMetricSystem;
import metricSystems.imperial.length.ImperialLengthMetricSystem;

public class ImperialLength extends Length{
    public ImperialLength(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return ImperialLengthMetricSystem.SYSTEM;
    }
}
