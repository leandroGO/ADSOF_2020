package ads.practica3;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private static final List<Venta> pilaVentas = new ArrayList<>();
    private static int top = 0;
    private Electrodomestico electrodomestico;
    private Electrodomestico electrodomesticoViejo;

    public Venta(Electrodomestico electrodomestico) {
        this.electrodomestico = electrodomestico;
        pilaVentas.add(this);
        top++;
    }

    public Venta(Electrodomestico electrodomestico, Electrodomestico electrodomesticoViejo) {
        this.electrodomestico = electrodomestico;
        this.electrodomesticoViejo = electrodomesticoViejo;
        pilaVentas.add(this);
        top++;
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

    protected String printPrecioBase() {
        return String.format("Precio producto:%15.2f Euros\n", electrodomestico.getPrecioBase());
    }

    protected String printDescuentoViejo() {
        return String.format("Descuento entrega:%13.2f Euros\n", electrodomestico.descuentoViejo(electrodomesticoViejo));
    }

    protected String printPrecioFinal() {
        return String.format("TOTAL:%25.2f Euros\n", precioFinal());
    }

    public String getTicket() {
        return  "--------------------------------------------\n" +
                "Producto vendido: " + electrodomestico +
                "\n--------------------------------------------\n" +
                printPrecioBase() + printDescuentoViejo() + printPrecioFinal();
    }

    public static String resumenVentas() {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
        }
        return resumen.toString();
    }

    public static String resumenVentas(int min) {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            if (v.precioFinal() >= min) {
                resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
            }
        }
        return resumen.toString();
    }

    public static String resumenVentas(String clave) {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            if (v.getElectrodomestico().getMarca().contains(clave)) {
                resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
            }
        }
        return resumen.toString();
    }

    public static Venta ultima() {
        return pilaVentas.get(top - 1);
    }

    public static Venta anular() {
        if (top == 0) {
            return null;
        }

        top--;
        return pilaVentas.remove(top);
    }

    @Override
    public String toString() {
        return "{" + " electrodomestico='" + getElectrodomestico() + "'" + ", electrodomesticoViejo='"
                + getElectrodomesticoViejo() + "'" + "}";
    }

}