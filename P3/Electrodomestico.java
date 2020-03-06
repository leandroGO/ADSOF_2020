package ads.practica3;

public abstract class Electrodomestico {
    private String marca;
    private String modelo;
    private double precioBase;
    ClaseEnergetica claseEnergetica;

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
        d = viejo.claseEnergetica - this.claseEnergetica;

        if (viejo.claseEnergetica == Desconocido) {
            return 10;
        }

        if (d == 0) {
            return 25;
        } else if (d > 0) {
            return 25 + 10 * d;
        } else {
            return 25 + 5 * d;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Electrodomestico)) {
            return false;
        }
        Electrodomestico electrodomestico = (Electrodomestico) o;
        return Objects.equals(marca, electrodomestico.marca) && Objects.equals(modelo, electrodomestico.modelo)
                && precioBase == electrodomestico.precioBase
                && Objects.equals(claseEnergetica, electrodomestico.claseEnergetica);
    }

    @Override
    public String toString() {
        return "{" + " marca='" + getMarca() + "'" + ", modelo='" + getModelo() + "'" + ", precioBase='"
                + getPrecioBase() + "'" + ", claseEnergetica='" + getClaseEnergetica() + "'" + "}";
    }

}
