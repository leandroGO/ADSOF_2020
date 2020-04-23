package graphs;

import graphs.exceptions.NotInGraphException;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph<N, E> extends AbstractList<Node<N>> {
    private List<Node<N>> nodes = new ArrayList<>();
    private List<Edge<N, E>> edges = new ArrayList<>();

    @Override
    public Node<N> get(int index) {
        return nodes.get(index);
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public boolean add(Node<N> nd) {
        if (nodes.contains(nd)) {
            return false;
        }
        nodes.add(nd);
        nd.setGraph(this);
        return true;
    }

    @Override
    public Node<N> remove(int index) {
        Node<N> nd = nodes.get(index);  //throws IndexOutOfBoundsException
        edges.removeIf(e -> e.getOrigin().equals(nd) || e.getDestination().equals(nd));
        return nd;
    }

    public void connect(Node<N> from, E weight, Node<N> to) throws NotInGraphException {
        if (!nodes.contains(from)) {
            throw new NotInGraphException(from);
        } else if (!nodes.contains(to)) {
            throw new NotInGraphException(to);
        } else {
            edges.add(new Edge<>(from, weight, to));
        }
    }

    public List<Edge<N, E>> getEdgesFrom(Node<N> nd) {
        return edges.stream().filter(e -> e.getOrigin().equals(nd)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Nodes:\n");
        for (Node<N> nd : nodes) {
            out.append(nd).append("\n");
        }
        out.append("Edges:\n");
        for (Edge<N,E> e : edges) {
            out.append(e).append("\n");
        }
        return out.toString();
    }
}
