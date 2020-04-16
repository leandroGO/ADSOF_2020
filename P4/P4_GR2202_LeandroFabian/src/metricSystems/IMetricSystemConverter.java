package metricSystems;

import magnitude.IMagnitude;
import magnitude.exceptions.UnknownUnitException;
import units.IPhysicalUnit;

/**
 * Defines IMetricSystemConverter interface.
 * It enables transformations between IMetricSystems.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public interface IMetricSystemConverter {
    /**
     * Returns the converter's source system
     * @return the source system
     */
    IMetricSystem sourceSystem();

    /**
     * Returns the converter's target system
     * @return the target system
     */
    IMetricSystem targetSystem();

    /**
     * Transforms a Magnitude to a given IPhyisicalUnit
     * @param from the magnitude
     * @param to the target unit
     * @return the transformed magnitude
     * @throws UnknownUnitException in case of unsupported units by the converter
     */
    IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;

    /**
     * Returns the reverse converter, that is, one that converts from this converter's
     * target system to this converter's source system
     * @return the reverse converter
     */
    IMetricSystemConverter reverse();
}