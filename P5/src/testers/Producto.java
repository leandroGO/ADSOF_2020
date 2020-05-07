package testers;

import rules.observer.Observer;
import rules.observer.Subject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Producto extends Subject { // Una clase para probar las reglas
    private double precio;
    private Date caducidad; // Otra opción es usar Calendar

    public Producto (double p, Date c) {
        this.precio = p;
        this.caducidad = c;
    }
    public double getPrecio() { return this.precio; }
    public void setPrecio(double p) {
        this.precio = p;
        notifyEvent("precio");
    }
    public Date getCaducidad() { return this.caducidad; }
    public void setCaducidad(Date cad) {
        this.caducidad = cad;
        notifyEvent("caducidad");
    }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @Override public String toString() { return this.precio+", caducidad: "+this.caducidad; }

    @Override
    public void notifyEvent(String attr) {
        getObservers().stream().filter(o -> o.getAttr().equals(attr)).forEach(Observer::process);
    }
}
