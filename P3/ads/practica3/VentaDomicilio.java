package ads.practica3;

public class VentaDomicilio extends Venta {
    public VentaDomicilio(Electrodomestico electrodomestico) {
        super(electrodomestico);
    }

    public VentaDomicilio(Electrodomestico electrodomestico, Electrodomestico electrodomesticoViejo) {
        super(electrodomestico, electrodomesticoViejo);
    }

    @Override
    public double precioFinal() {
        return super.precioFinal() + electrodomestico.costeDomicilio();
    }

    @Override
    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + electrodomestico +
                "\n--------------------------------------------\n" +
                "Precio producto: " + electrodomestico.getPrecioBase() +
                "\nDescuento entrega: " + electrodomestico.descuentoViejo(electrodomesticoViejo) +
                "\nCoste porte: " + electrodomestico.costeDomicilio() +
                "\nTOTAL: " + precioFinal()+ "\n";
    }
}