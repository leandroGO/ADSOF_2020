package graphs;

import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {
    private static int globalId = 0;
    private int id;
    private T info;
    private Graph<T, ?> graph;

    public Node(T info) {
        this.info = info;
        id = globalId;
        globalId++;
    }

    public int getId() {
        return id;
    }

    public void setGraph(Graph<T, ?> graph) {
        this.graph = graph;
    }

    public T getValue() {
        return info;
    }

    public List<Node<T>> neighbours() {
        return graph.getEdgesFrom(this).stream()
                .map(Edge::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean isConnectedTo(T value) {
        return graph.getEdgesFrom(this).stream().anyMatch(e -> e.getDestination().info.equals(value));
    }

    public boolean isConnectedTo(Node<T> node) {
        return graph.getEdgesFrom(this).stream().anyMatch(e -> e.getDestination().equals(node));
    }

    public List<?> getEdgeValues(Node<T> n2) {
        return graph.getEdgesFrom(this).stream()
                .filter(e -> e.getDestination().equals(n2))
                .map(Edge::getInfo)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node<?>)) {
            return false;
        }
        return ((Node<?>) obj).id == this.id;
    }

    @Override
    public String toString() {
        return id + " [" + info.toString() + "]";
    }
}
