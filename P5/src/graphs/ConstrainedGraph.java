package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConstrainedGraph<N,E> extends Graph<N,E> {
    private Optional<Node<N>> witness;

    public Optional<Node<N>> getWitness() {
        return witness;
    }

    public boolean forAll(Predicate<? super Node<N>> predicate) {
        return stream().allMatch(predicate);
    }

    public boolean one(Predicate<? super Node<N>> predicate) {
        return stream().filter(predicate).count() == 1;
    }

    public boolean exists(Predicate<? super Node<N>> predicate) {
        witness = stream().filter(predicate).findAny();
        return witness.isPresent();
    }
}
