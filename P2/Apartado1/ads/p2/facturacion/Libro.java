package ads.p2.facturacion;

/**
 * Esta clase extiende la clase Articulo para libros.
 * 
 * @author Leandro García y Fabián Gutiérrez
 */
public class Libro extends Articulo {
    private String categoria; 

    public Libro(long id, String desc, double precio, String categoria) {
        super(id, desc, precio);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double tipoIVA() {
        return 0.04;
    }

    public double descuento(double unidades) {
        if (categoria == "LibroDeTexto") {
            return unidades * getPrecioUnitario() * 0.15;
        } else if ((categoria == "Coleccion") && (unidades >= 3)) {
            return (unidades - 2) * getPrecioUnitario() * 0.5;
        }

        return 0.0;
    }
}