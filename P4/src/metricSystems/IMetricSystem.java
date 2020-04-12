package metricSystems;

import units.IPhysicalUnit;

import java.util.Collection;

/**
 * Defines IMetricSystem interface.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public interface IMetricSystem {
    /**
     * Returns the base unit of the system
     * @return the base unit
     */
    IPhysicalUnit base();

    /**
     * Returns the collection of units of the system
     * @return the units
     */
    Collection<IPhysicalUnit> units();

    /**
     * Retrieves a registered converter from this system to another one
     * @param to the target system of the converter
     * @return the converter if found, null otherwise
     */
    IMetricSystemConverter getConverter(IMetricSystem to);

    /**
     * Registers a converter from this system to another
     * @param c the converter
     * @return if the addition was successful
     */
    boolean addConverter(IMetricSystemConverter c);
}
