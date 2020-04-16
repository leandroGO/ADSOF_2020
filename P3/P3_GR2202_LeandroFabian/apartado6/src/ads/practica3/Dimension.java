package ads.practica3;

/**
 * Define las dimensiones (alto, largo, ancho) de volumenes
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public class Dimension {
    private double ancho;
    private double largo;
    private double alto;

    /**
     * Constructor de un objeto de tipo Dimension
     * @param ancho el ancho en metros
     * @param largo el largo en metros
     * @param alto el alto en metros
     */
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

    /**
     * Calcula el volumen en metros cubicos
     * @return el volumen en metros cubicos
     */
    public double calcularVolumen() {
        return (ancho * largo * alto) / 1000000; //En metros cubicos
    }

    @Override
    public String toString() {
        return "{" + ", ancho='" + getAncho() + "'" + ", largo='" + getLargo() + "'" + " alto='" + getAlto() + "'"
                + "}";
    }

}