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
        return super.precioFinal() + getElectrodomestico().costeDomicilio();
    }

    @Override
    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + getElectrodomestico() +
                "\n--------------------------------------------\n" +
                "Precio producto: " + getElectrodomestico().getPrecioBase() +
                "\nDescuento entrega: " + getElectrodomestico().descuentoViejo(getElectrodomesticoViejo()) +
                "\nCoste porte: " + getElectrodomestico().costeDomicilio() +
                "\nTOTAL: " + precioFinal()+ "\n";
    }
}