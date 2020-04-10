package units;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;

public interface IPhysicalUnit {
    boolean canTransformTo(IPhysicalUnit u);
    double transformTo(double d, IPhysicalUnit u) throws QuantityException;
    Quantity getQuantity();
    String abbrev();
    IMetricSystem getMetricSystem();
}
