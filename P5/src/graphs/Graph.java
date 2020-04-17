package graphs;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Graph<N, E> extends AbstractList<Node<N>> {
    private List<N> nodes = new ArrayList<>();
    private List<E> edges = new ArrayList<>();

    public Graph() {
    }

    @Override
    public Node<N> get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Node<N> remove(int index) {

        return super.remove(index);
    }


    public void connect(Node<N> from, E weight, Node<N> to) {
    }
}
