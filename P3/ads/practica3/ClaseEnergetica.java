package ads.practica3;

public enum ClaseEnergetica {
    A (1), B (2), C (3), D (4), Desconocida (-1);

    private final int valor;
    ClaseEnergetica(int valor) {
        this.valor = valor;
    }

    public int valor() {
        return valor;
    }

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
            case "Desconocida":
                return ClaseEnergetica.Desconocida;
            default:
                return null;
        }
    }
}
