package ads.practica3;

/**
 * Define un electrodomestico
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public abstract class Electrodomestico {
    private String marca;
    private String modelo;
    private double precioBase;
    private ClaseEnergetica claseEnergetica;

    public Electrodomestico(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.claseEnergetica = claseEnergetica;
        Almacen.add(this.parse(), modelo);
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public ClaseEnergetica getClaseEnergetica() {
        return this.claseEnergetica;
    }

    public void setClaseEnergetica(ClaseEnergetica claseEnergetica) {
        this.claseEnergetica = claseEnergetica;
    }

    /**
     * Calcula el coste de envio a domicilio del electrodomestico
     * @return el coste de envio
     */
    public abstract double costeDomicilio();

    /**
     * Calcula el descuento a aplicar por la entrega de un electrodomestico viejo
     * en el momento de la venta
     * @param viejo el electrodomestico viejo entregado
     * @return el descuento a sustraer
     */
    public double descuentoViejo(Electrodomestico viejo) {
        int desc = 25;

        if (viejo == null) {
            return 0;
        }

        int d = ClaseEnergetica.compareClase(this.claseEnergetica, viejo.claseEnergetica);

        if (viejo.claseEnergetica == ClaseEnergetica.Desconocida) {
            return 10;
        }

        if (d > 0) {
            desc += 15 * d;
        } else if (d < 0) {
            desc += 5 * d;
        }

        return desc;
    }

    public abstract String parse();

    @Override
    public String toString() {
        return String.format("%s %s, %.2f Euros", getMarca(), getModelo(), getPrecioBase());
    }

    @Override
    public boolean equals(Object o) {
        Electrodomestico e;

        if (!(o instanceof Electrodomestico)) {
            return false;
        }

        e = (Electrodomestico)o;

        if ((this instanceof Television && !(e instanceof Television)) ||
                (this instanceof Lavadora && !(e instanceof Lavadora)) ||
                (this instanceof Frigorifico && !(e instanceof Frigorifico))) {
            return false;
        }
        else {
            return this.marca.equals(e.marca) && this.modelo.equals(e.modelo);
        }
    }
}
