package units;

import magnitude.exceptions.QuantityException;

public abstract class PhysicalUnit implements IPhysicalUnit {
    private String abbr;

    public PhysicalUnit(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public boolean canTransformTo(IPhysicalUnit u) {
        return this.getQuantity() == u.getQuantity();
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        //Si u no es unidad conocida
        if (this.getQuantity() != u.getQuantity()) {
            //algo con la exception
        }
        return 0;
    }

    @Override
    public String abbrev() {
        return abbr;
    }

    @Override
    public String toString() {
        return abbrev() + " " + getQuantity();
    }
}
