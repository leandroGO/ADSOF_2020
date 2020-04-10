package metricSystems;

import units.IPhysicalUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class MetricSystem implements IMetricSystem {
    private IPhysicalUnit base;
    private Collection<IPhysicalUnit> units;
    private Set<IMetricSystemConverter> converters;

    protected MetricSystem(IPhysicalUnit base, Collection<IPhysicalUnit> units) {
        this.base = base;
        this.units = units;
        converters = new HashSet<>();
    }

    @Override
    public boolean addConverter(IMetricSystemConverter c) {
        return converters.add(c);
    }

    @Override
    public IPhysicalUnit base() {
        return base;
    }

    @Override
    public Collection<IPhysicalUnit> units() {
        return units;
    }

    @Override
    public IMetricSystemConverter getConverter(IMetricSystem to) {
        for (IMetricSystemConverter c : converters) {
            if (c.targetSystem() == to) {
                return c;
            }
        }
        return null;
    }
}
