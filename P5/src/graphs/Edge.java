package graphs;

public class Edge<N, T> {
    private Node<N> origin;
    private Node<N> destination;
    private T info;

    public Edge(Node<N> origin, T info, Node<N> destination) {
        this.origin = origin;
        this.destination = destination;
        this.info = info;
    }

    public Node<N> getOrigin() {
        return origin;
    }

    public void setOrigin(Node<N> origin) {
        this.origin = origin;
    }

    public Node<N> getDestination() {
        return destination;
    }

    public void setDestination(Node<N> destination) {
        this.destination = destination;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "( " + origin.getId() + " --" + info + "--> " +destination.getId() + " )";
    }
}
