package graphs;

import java.util.function.Predicate;

public class Property<N> {
    private Criteria crt;
    private Predicate<? super Node<N>> predicate;

    public Property(Criteria crt, Predicate<? super Node<N>> predicate) {
        this.crt = crt;
        this.predicate = predicate;
    }

    public boolean test(ConstrainedGraph<N,?> g) {
        switch (crt) {
            case UNIVERSAL:
                return g.forAll(predicate);

            case EXISTENTIAL:
                return g.exists(predicate);

            case UNITARY:
                return g.one(predicate);

            default:
                return false;
        }
    }
}
