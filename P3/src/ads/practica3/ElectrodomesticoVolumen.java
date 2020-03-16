package ads.practica3;

/**
 * Define un electrodomestico que tiene un cierto volumen
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public abstract class ElectrodomesticoVolumen extends Electrodomestico {
    Dimension dimension;
    private double peso;

    public ElectrodomesticoVolumen(String marca,
                                   String modelo,
                                   double precioBase,
                                   ClaseEnergetica claseEnergetica,
                                   Dimension dimension,
                                   double peso) {
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
}