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

    protected String printCosteDomicilio() {
        return String.format("Coste porte:%19.2f Euros\n", getElectrodomestico().costeDomicilio());
    }

    @Override
    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + getElectrodomestico() +
                "\n--------------------------------------------\n" +
                printPrecioBase() + printDescuentoViejo() + printCosteDomicilio() + printPrecioFinal();
    }
}