package units.si.length;

import metricSystems.IMetricSystem;
import metricSystems.si.length.SiLengthMetricSystem;
import units.Length;

public class SiLength extends Length {
    public SiLength(String abbr, double cFactor) {
        super(abbr, cFactor);
    }

    @Override
    public IMetricSystem getMetricSystem() {
        return SiLengthMetricSystem.SYSTEM;
    }
}
