package graphs;

public class Edge<T> {
    private Node origin;
    private Node destination;
    private T info;

    public Edge(Node origin, T info, Node destination) {
        this.origin = origin;
        this.destination = destination;
        this.info = info;
    }

    public Node getOrigin() {
        return origin;
    }

    public void setOrigin(Node origin) {
        this.origin = origin;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
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
