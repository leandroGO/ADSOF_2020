package ads.practica3;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la informacion asociada a una venta de electrodomesticos (ademas de llevar un registro
 * de las ventas realizadas) e implementa los metodos de calculo de precio
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public class Venta {
    private static final List<Venta> pilaVentas = new ArrayList<>();
    private static int top = 0;
    private Electrodomestico electrodomestico;
    private Electrodomestico electrodomesticoViejo;
    private boolean valida;

    public Venta(Electrodomestico electrodomestico) {
        valida = Almacen.extract(electrodomestico.parse(), electrodomestico.getModelo());
        this.electrodomestico = electrodomestico;
        pilaVentas.add(this);
        top++;
    }

    public Venta(Electrodomestico electrodomestico, Electrodomestico electrodomesticoViejo) {
        valida = Almacen.extract(electrodomestico.parse(), electrodomestico.getModelo());
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

    /**
     * Calcula el precio final de la venta
     * @return el precio final calculado
     */
    public double precioFinal() {
        return electrodomestico.getPrecioBase() - electrodomestico.descuentoViejo(electrodomesticoViejo);
    }

    /**
     * Compone la cadena de caracteres con la que se indica el precio base
     * @return la cadena asociada al precio base
     */
    protected String printPrecioBase() {
        return String.format("Precio producto:%15.2f Euros\n", electrodomestico.getPrecioBase());
    }

    /**
     * Compone la cadena de caracteres con la que se indica el descuento a aplicar por
     * la entrega de un electrodomestico viejo
     * @return la cadena asociada al descuento
     */
    protected String printDescuentoViejo() {
        return String.format("Descuento entrega:%13.2f Euros\n", electrodomestico.descuentoViejo(electrodomesticoViejo));
    }

    /**
     * Compone la cadena de caracteres con la que se indica el precio final
     * @return la cadena asociada al precio final
     */
    protected String printPrecioFinal() {
        return String.format("TOTAL:%25.2f Euros\n", precioFinal());
    }

    /**
     * Compone el recibo de la venta
     * @return el recibo generado
     */
    public String getTicket() {
        if (!valida) {
            return  "--------------------------------------------\n" +
                    "Venta no valida\n" +
                    "--------------------------------------------\n";
        }

        return  "--------------------------------------------\n" +
                "Producto vendido: " + electrodomestico +
                "\n--------------------------------------------\n" +
                printPrecioBase() + printDescuentoViejo() + printPrecioFinal();
    }

    /**
     * Genera un resumen de las ventas realizadas
     * @return el resumen generado
     */
    public static String resumenVentas() {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
        }
        return resumen.toString();
    }

    /**
     * Genera un resumen de las ventas realizadas cuyo precio final supere un minimo
     * @param min el importe minimo de las ventas a mostrar
     * @return el resumen generado
     */
    public static String resumenVentas(int min) {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            if (v.precioFinal() >= min) {
                resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
            }
        }
        return resumen.toString();
    }

    /**
     * Genera un resumen de las ventas realizadas cuya marca contenga la palabra clave
     * @param clave la palabra clave a buscar en las marcas
     * @return el resumen generado
     */
    public static String resumenVentas(String clave) {
        StringBuilder resumen = new StringBuilder("RESUMEN DE VENTAS\n");
        for (Venta v : pilaVentas) {
            if (v.getElectrodomestico().getMarca().contains(clave)) {
                resumen.append(v.printPrecioFinal());   //alternativa a hacer resumen += v.printPrecioFinal()
            }
        }
        return resumen.toString();
    }

    /**
     * Devuelve la ultima venta realizada
     * @return la ultima venta realizada
     */
    public static Venta ultima() {
        return pilaVentas.get(top - 1);
    }

    /**
     * Anula la ultima venta realizada
     * @return la ultima venta realizada (el sistema de ventas ya no la almacena)
     */
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