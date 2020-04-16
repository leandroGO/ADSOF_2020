package units;

import magnitude.exceptions.QuantityException;

/**
 * Defines an abstract physical unit.
 *
 * @author Leandro Garcia, Fabian Gutierrez
 */
public abstract class PhysicalUnit implements IPhysicalUnit {
    private String abbr;
    private double cFactor;

    /**
     * Creates a new physical unit.
     * @param abbr the unit's abbreviation
     * @param cFactor the conversion factor with respect to the base unit of its metric system
     */
    public PhysicalUnit(String abbr, double cFactor) {
        this.abbr = abbr;
        this.cFactor = cFactor;
    }

    @Override
    public boolean canTransformTo(IPhysicalUnit u){
        return this.getMetricSystem() == u.getMetricSystem();
    }

    @Override
    public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
        PhysicalUnit aux;

        if (!this.canTransformTo(u)) {
            throw new QuantityException(this.getQuantity(), u.getQuantity());
        }

        aux = (PhysicalUnit) u;
        return d*this.cFactor/aux.cFactor;
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
