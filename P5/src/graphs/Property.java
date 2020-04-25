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
        if (crt == Criteria.UNIVERSAL) {
            return g.forAll(predicate);
        }
        if (crt == Criteria.EXISTENTIAL) {
            return g.exists(predicate);
        }
        if (crt == Criteria.UNITARY) {
            return g.one(predicate);
        }
        return false;
    }
}
