package ads.practica3;

/**
 * Extiende la definicion de ventas para ventas a Canarias
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public class VentaCanarias extends Venta {
    private static final double tasaPorte = .07;

    public VentaCanarias(Electrodomestico electrodomestico) {
        super(electrodomestico);
    }

    /**
     * No hace nada. Las ventas a Canarias no admiten recogida de electrodomesticos
     * @param electrodomesticoViejo el electrodomestico que se pretende recoger
     */
    @Override
    public void setElectrodomesticoViejo(Electrodomestico electrodomesticoViejo) {}

    @Override
    public double precioFinal() {
        return super.precioFinal()*(1.0 + tasaPorte);
    }

    /**
     * Compone la cadena de caracteres con la que se indica el coste de envio
     * @return la cadena asociada al coste de envio
     */
    protected String printCostePorte() {
        return String.format("Coste porte:%19.2f Euros\n", super.precioFinal()*tasaPorte);
    }

    @Override
    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + getElectrodomestico() +
                "\n--------------------------------------------\n" +
                printPrecioBase() + printCostePorte() + printPrecioFinal(); //No tiene un descuento por entrega
    }
}
