package ads.practica3;

public class Frigorifico extends ElectrodomesticoVolumen {
    private boolean noFrost;

    public Frigorifico(String marca,
                       String modelo,
                       double precioBase,
                       ClaseEnergetica claseEnergetica,
                       Dimension dimension,
                       double peso,
                       boolean noFrost) {
        super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
        this.noFrost = noFrost;
    }

    public boolean isNoFrost() {
        return this.noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }

    @Override
    public double costeDomicilio() {
        return Math.round(70 * this.dimension.calcularVolumen());
    }
}