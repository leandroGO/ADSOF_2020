package ads.practica3;

/**
 * Extiende la definicion de electrodomestico voluminoso para lavadoras
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public class Lavadora extends ElectrodomesticoVolumen {
    private double kilosDeCarga;
    private int rpmCentrifugado;

    public Lavadora(String marca,
                    String modelo,
                    double precioBase,
                    ClaseEnergetica claseEnergetica,
                    Dimension dimension,
                    double peso) {
        super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
    }

    public Lavadora(String marca,
                    String modelo,
                    double precioBase,
                    ClaseEnergetica claseEnergetica,
                    Dimension dimension,
                    double peso,
                    double kilosDeCarga,
                    int rpmCentrifugado) {
        super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
        this.kilosDeCarga = kilosDeCarga;
        this.rpmCentrifugado = rpmCentrifugado;
    }

    public double getKilosDeCarga() {
        return this.kilosDeCarga;
    }

    public void setKilosDeCarga(double kilosDeCarga) {
        this.kilosDeCarga = kilosDeCarga;
    }

    public int getRpmCentrifugado() {
        return this.rpmCentrifugado;
    }

    public void setRpmCentrifugado(int rpmCentrifugado) {
        this.rpmCentrifugado = rpmCentrifugado;
    }

    @Override
    public double costeDomicilio() {
        if (getPeso() <= 50) {
            return 35;
        }
        else {
            return 35 + 0.5 * (Math.ceil(getPeso()) - 50);
        }
    }

    @Override
    public String parse() {
        return "Lavadora";
    }
}