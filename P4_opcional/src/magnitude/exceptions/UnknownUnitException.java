package magnitude.exceptions;

import units.IPhysicalUnit;
import units.Quantity;

public class UnknownUnitException extends QuantityException {
    String a1;
    String a2;

    public UnknownUnitException(IPhysicalUnit u1, IPhysicalUnit u2) {
        super(u1.getQuantity(), u2.getQuantity());
        a1 = u1.abbrev();
        a2 = u2.abbrev();
    }

    @Override
    public String toString() {
        return "Cannot transform " + a1 + " " + q1 + " to " + a2 + " " + q2;
    }
}
