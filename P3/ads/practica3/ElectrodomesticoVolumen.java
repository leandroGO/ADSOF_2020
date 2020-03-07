package ads.practica3;

import ads.practica3.Electrodomestico;

public abstract class ElectrodomesticoVolumen extends Electrodomestico{
    Dimension dimension;
    private double peso;

    public ElectrodomesticoVolumen(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica, Dimension dimension, double peso) {
        super(marca, modelo, precioBase, claseEnergetica);
        this.dimension = dimension;
        this.peso = peso;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public java.lang.String toString() {
        return "ElectrodomesticoVolumen{" +
                "dimension=" + dimension +
                ", peso=" + peso +
                '}';
    }
}