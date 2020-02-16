package ads.p2.facturacion;

/**
 * Esta clase contiene la información asociada a un artículo
 * de venta en grandes superficies. Incluye los métodos que
 * permiten obtener el tipo de IVA, los descuentos aplicables
 * y el precio total de las unidades de un artículo.
 * 
 * @author Leandro García y Fabián Gutiérrez
 */
public abstract class Articulo {
    private long identificador;
    private String descripcion;
    private double precioUnitario;
    
    public Articulo(long id, String desc, double precio) {
        identificador = id; descripcion = desc; precioUnitario = precio;
    }
    public long getIdentificador() { return identificador; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public void setDescripcion(String desc) { descripcion = desc; }
    public void setPrecioUnitario(double precio) { precioUnitario = precio; }

    /**
     * Devuelve el tipo de IVA a aplicar sobre el artículo.
     * El tipo IVA general es 21% aplicable salvo que se redefina en
     * una subclase.
     * @return el tipo de IVA.
     */
    public double tipoIVA() { return 0.21; }
    
    /**
     * Calcula el descuento a aplicar sobre la compra del artículo.
     * Cada subclase de articulo calculará el descuento que corresponda.
     * @param unidades las unidades a comprar del artículo.
     * @return el monto a descontar del precio bruto.
     */
    public abstract double descuento(double unidades);
    
    
    /**
     * Calcula el precio total de la compra.
     * @param unidades las unidades a comprar del artículo.
     * @return el precio final a pagar.
     */
    public double precioTotal(double unidades) {    // el precio total siempre se calcula de la misma forma
        return ((precioUnitario * unidades) - descuento(unidades)) 
                     * (1.0 + tipoIVA());
    }

    public String toString() {
        return "Id:" + identificador + " " + descripcion + " " +
        "Precio final: " + precioUnitario;
    }
}
