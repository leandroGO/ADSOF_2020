package magnitude;

import magnitude.exceptions.QuantityException;
import units.IPhysicalUnit;

/**
 * Defines IMagnitude interface.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public interface IMagnitude {
    /**
     * Adds magnitude to this magnitude (in this magnitude's units)
     * @param m the magnitude to be added to this
     * @return new magnitude with the result
     * @throws QuantityException in case of incompatibility of magnitudes
     */
    IMagnitude add (IMagnitude m) throws QuantityException;

    /**
     * Subtracts magnitude from this magnitude (in this magnitude's units)
     * @param m the magnitude to be subtracted from this
     * @return new magnitude with the result
     * @throws QuantityException in case of incompatibility of magnitudes
     */
    IMagnitude subs(IMagnitude m) throws QuantityException;

    /**
     * Transforms this magnitude to a given IPhysicalUnit
     * @param c the target unit
     * @return the magnitude transformed to c
     * @throws QuantityException in case of incompatibility
     */
    IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;

    /**
     * Returns the unit of magnitude
     * @return the unit
     */
    IPhysicalUnit getUnit();

    /**
     * Returns the numerical value of the magnitude
     * @return the numerical value
     */
    double getValue();
}
