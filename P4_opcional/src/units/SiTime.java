package units;

import metricSystems.IMetricSystem;
import metricSystems.si.time.SiTimeMetricSystem;

public class SiTime extends Time {
    public SiTime(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SiTimeMetricSystem.SYSTEM;
    }
}
