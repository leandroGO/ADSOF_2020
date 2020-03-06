package ads.practica3;

import ads.practica3.ElectrodomesticoVolumen;

public class Frigorifico extends ElectrodomesticoVolumen {
    private boolean noFrost;

    public Frigorifico(boolean noFrost) {
        super();
        this.noFrost = noFrost;
    }

    public boolean isNoFrost() {
        return this.noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }

    public double costeDomiciclio() {
        return 70 * this.dimension.calcularVolumen();
    }

    @Override
    public String toString() {
        return "{" +
            " noFrost='" + isNoFrost() + "'" +
            "}";
    }
}