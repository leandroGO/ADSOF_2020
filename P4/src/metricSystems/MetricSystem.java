package metricSystems;

import units.IPhysicalUnit;

import java.util.Collection;

public class MetricSystem implements IMetricSystem {
    private IPhysicalUnit base;
    private Collection<IPhysicalUnit> units;

    public MetricSystem(IPhysicalUnit base, Collection<IPhysicalUnit> units){
        this.base = base;
        this.units = units;
    }

    @Override
    public IPhysicalUnit base(){
        return base;
    }

    @Override
    public Collection<IPhysicalUnit> units(){
        return units;
    }
}
