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
        return String.format("--------------------------------------------\n" +
                "Producto vendido: %s\n" +
                "--------------------------------------------\n" +
                "Precio producto:%15.2f Euros\n" +
                "Descuento entrega:%13.2f Euros\n" +
                "Coste porte:%19.2f Euros\n" +
                "TOTAL:%25.2f Euros\n",
                getElectrodomestico(), getElectrodomestico().getPrecioBase(),
                getElectrodomestico().descuentoViejo(getElectrodomesticoViejo()),
                getElectrodomestico().costeDomicilio(), precioFinal());
    }
}