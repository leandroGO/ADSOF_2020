package magnitude.exceptions;

import units.IPhysicalUnit;
import units.Quantity;

public class NotCompositeException extends QuantityException {
    IPhysicalUnit u;

    public NotCompositeException(IPhysicalUnit u) {
        super(u.getQuantity(), u.getQuantity());
        this.u = u;
    }

    @Override
    public String toString() {
        return "Cannot transform " + u + " to composite unit";
    }
}
