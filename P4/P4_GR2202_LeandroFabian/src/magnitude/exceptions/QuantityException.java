package magnitude.exceptions;

import units.Quantity;

/**
 * Defines a QuantityException, an Exception associated to two Quantities.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public class QuantityException extends Exception {
    protected Quantity q1;
    protected Quantity q2;

    public QuantityException(Quantity q1, Quantity q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    @Override
    public String toString() {
        return "Quantities "+ q1 + " and " + q2 + " are not compatible";
    }
}
