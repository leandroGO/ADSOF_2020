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

    public double getAlto() {
        return this.alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return this.ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return this.largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "{" +
            " alto='" + getAlto() + "'" +
            ", ancho='" + getAncho() + "'" +
            ", largo='" + getLargo() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }
}