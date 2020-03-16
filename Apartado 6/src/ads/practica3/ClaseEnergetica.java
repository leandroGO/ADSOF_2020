package ads.practica3;

/**
 * Define las distintas clases energeticas de los electrodomesticos.
 * Ademas, establece entre estas una relacion de orden que permite compararlas
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public enum ClaseEnergetica {
    A (1), B (2), C (3), D (4), Desconocida (-1);

    private final int valor;
    ClaseEnergetica(int valor) {    //Es un metodo privado por definicion (constructor de enum)
        this.valor = valor;
    }

    public int valor() {
        return valor;
    }

    /**
     * Devuelve la clase energetica correspondiente a partir de un string
     * @param nombre el nombre de la clase energetica en cadena de caracteres
     * @return la clase energetica asociada a nombre
     */
    public static ClaseEnergetica parseClase(String nombre) {
        switch (nombre) {
            case "A":
                return ClaseEnergetica.A;
            case "B":
                return ClaseEnergetica.B;
            case "C":
                return ClaseEnergetica.C;
            case "D":
                return ClaseEnergetica.D;
            default:
                return ClaseEnergetica.Desconocida;
        }
    }
}
