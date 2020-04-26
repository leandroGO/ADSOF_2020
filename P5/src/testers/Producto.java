package testers;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class Producto { // Una clase para probar las reglas
    private double precio;
    private Date caducidad; // Otra opción es usar Calendar
    public Producto (double p, Date c) {
        this.precio = p;
        this.caducidad = c;
    }
    public double getPrecio() { return this.precio; }
    public void setPrecio(double p) { this.precio = p; }
    public Date getCaducidad() { return this.caducidad; }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    @Override public String toString() { return this.precio+", caducidad: "+this.caducidad; }
}
