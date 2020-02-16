package ads.p2.facturacion;

/**
 * Esta clase extiende la clase Articulo para tabaco.
 * 
 * @author Leandro García y Fabián Gutiérrez
 */
public class Tabaco extends Articulo {   
    public Tabaco(long id, String desc, double precio) {
        super(id, desc, precio);
    }
    
    public double descuento(double unidades) {
        return 0.0;
    }
}