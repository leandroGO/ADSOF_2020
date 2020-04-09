package metricSystems;

import units.IPhysicalUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMetricSystem implements IMetricSystem {
    private IPhysicalUnit base;
    private Collection<IPhysicalUnit> units;
    private Set<IMetricSystemConverter> conversores;

    protected AbstractMetricSystem(IPhysicalUnit base, Collection<IPhysicalUnit> units) {
        this.base = base;
        this.units = units;
        conversores = new HashSet<IMetricSystemConverter>();
    }

    @Override
    public boolean addConverter(IMetricSystemConverter c) {
        return conversores.add(c);
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
        for (IMetricSystemConverter c : conversores) {
            if (c.targetSystem() == to) {
                return c;
            }
        }
        return null;
    }
}
