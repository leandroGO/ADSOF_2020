package ads.practica3;

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

    public abstract double costeDomicilio();

    public double descuentoViejo(Electrodomestico viejo) {
        int desc = 25;

        if (viejo == null) {
            return 0;
        }

        int d = viejo.claseEnergetica.valor() - this.claseEnergetica.valor();

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

    @Override
    public String toString() {
        return String.format("%s %s, %.2f Euros", getMarca(), getModelo(), getPrecioBase());
    }

    @Override
    public boolean equals(Object o) {
        Electrodomestico e = (Electrodomestico)o;

        if ((this instanceof Television && !(e instanceof Television)) ||
                (this instanceof Lavadora && !(e instanceof Lavadora)) ||
                (this instanceof Frigorifico && !(e instanceof Frigorifico))) {
            return false;
        }
        else {
            if (this.marca.equals(e.marca) && this.modelo.equals(e.modelo)) {
                return true;
            }
        }
        return false;
    }
}
