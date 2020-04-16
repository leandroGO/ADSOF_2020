package units.si.time;

import metricSystems.IMetricSystem;
import metricSystems.si.time.SiTimeMetricSystem;
import units.Time;

public class SiTime extends Time {
    public SiTime(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SiTimeMetricSystem.SYSTEM;
    }
}
