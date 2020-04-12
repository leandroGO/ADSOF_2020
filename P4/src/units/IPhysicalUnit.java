package units;

import magnitude.exceptions.QuantityException;
import metricSystems.IMetricSystem;

/**
 * Defines IPhysicalUnit interface.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public interface IPhysicalUnit {
    boolean canTransformTo(IPhysicalUnit u);
    double transformTo(double d, IPhysicalUnit u) throws QuantityException;
    Quantity getQuantity();
    String abbrev();
    IMetricSystem getMetricSystem();
}
