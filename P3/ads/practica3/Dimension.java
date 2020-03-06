package ads.practica3;

public class Dimension {
    private double ancho;
    private double largo;
    private double alto;

    public Dimension(double ancho, double largo, double alto) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
    }

    public double getAncho() {
        return this.ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return this.largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAlto() {
        return this.alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public calcularVolumen() {
        return ancho * largo * alto;
    }

    @Override
    public String toString() {
        return "{" + ", ancho='" + getAncho() + "'" + ", largo='" + getLargo() + "'" + " alto='" + getAlto() + "'"
                + "}";
    }

}