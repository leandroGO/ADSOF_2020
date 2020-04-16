package ads.practica3;

/**
 * Extiende la definicion de ventas para ventas a domicilio
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
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

    /**
     * Compone la cadena de caracteres con la que se indica el coste de envio
     * @return la cadena asociada al coste de envio
     */
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