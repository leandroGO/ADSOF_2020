package ads.practica3;

public class VentaCanarias extends Venta {
    private static final double tasaPorte = .07;

    public VentaCanarias(Electrodomestico electrodomestico) {
        super(electrodomestico);
    }

    @Override
    public void setElectrodomesticoViejo(Electrodomestico electrodomesticoViejo) {} //No admite electrodomestico viejo

    @Override
    public double precioFinal() {
        return super.precioFinal()*(1.0 + tasaPorte);
    }

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
