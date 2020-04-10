package metricSystems;

import units.IPhysicalUnit;

import java.util.Collection;

public interface IMetricSystem {
    IPhysicalUnit base();
    Collection<IPhysicalUnit> units();
    IMetricSystemConverter getConverter(IMetricSystem to);
    boolean addConverter(IMetricSystemConverter c);
}
