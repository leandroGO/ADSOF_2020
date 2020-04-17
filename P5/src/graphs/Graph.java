package graphs;

import java.util.AbstractList;

public class Graph<N, E> extends AbstractList<Node<N>> {

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
}
