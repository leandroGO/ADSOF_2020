package ads.practica3;

public class TelevisionCurva extends Television {
    private double peso;
    private Dimension dimension;

    public TelevisionCurva(String marca,
                           String modelo,
                           double precioBase,
                           ClaseEnergetica claseEnergetica,
                           int tamPantalla,
                           double peso,
                           Dimension dimension) {
        super(marca, modelo, precioBase, claseEnergetica, tamPantalla);
        this.peso = peso;
        this.dimension = dimension;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public double costeDomicilio() {
        return super.costeDomicilio() + 25.0*dimension.calcularVolumen(); //Se calcula el suplemento por m^3 "flotante"
    }
}
