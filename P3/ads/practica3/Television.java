package ads.practica3;

public class Television extends Electrodomestico {
    private int tamPantalla;

    public Television(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
            int tamPantalla) {
        super(marca, modelo, precioBase, claseEnergetica);
        this.tamPantalla = tamPantalla;
    }

    public int getTamPantalla() {
        return this.tamPantalla;
    }

    public void setTamPantalla(int tamPantalla) {
        this.tamPantalla = tamPantalla;
    }
}