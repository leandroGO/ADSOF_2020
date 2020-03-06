package ads.practica3;

public abstract class Electrodomestico {
    private String marca;
    private String modelo;
    private double precioBase;
    ClaseEnergetica claseEnergetica;


    public abstract double costeDomicilio();

    public double descuentoViejo(Electrodomestico viejo) {
        if (viejo.claseEnergetica == Desconocido) {
            return 10;
        }

        if (viejo.claseEnergetica == this.claseEnergetica) {
            return 25;
        }

        if ()
    }
}

