package ads.practica3;

public class Venta {
    private Electrodomestico electrodomestico;
    private Electrodomestico electrodomesticoViejo;

    public Venta(Electrodomestico electrodomestico) {
        this.electrodomestico = electrodomestico;
    }

    public Venta(Electrodomestico electrodomestico, Electrodomestico electrodomesticoViejo) {
        this.electrodomestico = electrodomestico;
        this.electrodomesticoViejo = electrodomesticoViejo;
    }

    public Electrodomestico getElectrodomestico() {
        return this.electrodomestico;
    }

    public void setElectrodomestico(Electrodomestico electrodomestico) {
        this.electrodomestico = electrodomestico;
    }

    public Electrodomestico getElectrodomesticoViejo() {
        return this.electrodomesticoViejo;
    }

    public void setElectrodomesticoViejo(Electrodomestico electrodomesticoViejo) {
        this.electrodomesticoViejo = electrodomesticoViejo;
    }

    public double precioFinal() {
        return electrodomestico.getPrecioBase() - electrodomestico.descuentoViejo(electrodomesticoViejo);
    }

    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + electrodomestico +
                "\n--------------------------------------------\n" +
                "Precio producto: " + electrodomestico.getPrecioBase() +
                "\nDescuento entrega: " + electrodomestico.descuentoViejo(electrodomesticoViejo) +
                "\nTOTAL: " + precioFinal()+ "\n";
    }

    @Override
    public String toString() {
        return "{" + " electrodomestico='" + getElectrodomestico() + "'" + ", electrodomesticoViejo='"
                + getElectrodomesticoViejo() + "'" + "}";
    }

}