package rules;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Rule<T> {
    private String nombre;
    private String desc;
    private Predicate<T> cond;
    private Consumer<T> accion;

    protected Rule(String nombre, String desc) {
        this.nombre = nombre;
        this.desc = desc;
    }

    protected Rule(String nombre) {
        this.nombre = nombre;
    }

    public Predicate<T> getCond() {
        return cond;
    }

    public Consumer<T> getAccion() {
        return accion;
    }

    public static <T> Rule<T> rule(String nombre, String desc) {
        return new Rule<>(nombre, desc);
    }

    public Rule<T> when(Predicate<T> cond) {
        this.cond = cond;
        return this;
    }

    public Rule<T> exec(Consumer<T> accion) {
        this.accion = accion;
        return this;
    }
}
