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
        List<Node<N>> n = stream().filter(predicate).collect(Collectors.toList());
        return size() == n.size();
    }

    public boolean one(Predicate<? super Node<N>> predicate) {
        List<Node<N>> n = stream().filter(predicate).collect(Collectors.toList());
        return n.size() == 1;
    }

    public boolean exists(Predicate<? super Node<N>> predicate) {
        List<Node<N>> n = stream().filter(predicate).collect(Collectors.toList());
        if (n.size() >= 1) {
            witness = Optional.of(n.get(0));
            return true;
        }
        else {
            witness = Optional.empty();
            return false;
        }
    }
}
