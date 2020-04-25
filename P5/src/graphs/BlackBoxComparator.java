package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BlackBoxComparator<N,E> implements Comparator<ConstrainedGraph<N,E>> {
    private List<Property<N>> properties = new ArrayList<>();

    public BlackBoxComparator<N,E> addCriteria(Criteria crt, Predicate<? super Node<N>> predicate) {
        this.properties.add(new Property<>(crt, predicate));
        return this;
    }

    @Override
    public int compare(ConstrainedGraph<N,E> o1, ConstrainedGraph<N,E> o2) {
        long n1 = properties.stream().filter(p -> p.test(o1)).count();
        long n2 = properties.stream().filter(p -> p.test(o2)).count();
        return (int)(n1-n2);
    }
}
