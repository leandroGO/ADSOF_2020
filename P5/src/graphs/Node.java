package graphs;

import java.util.ArrayList;
import java.util.List;

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

    public List<T> neighbours() {

    }

    public boolean isConnectedTo(T value) {

    }

    public boolean isConnectedTo(Node<T> node) {

    }

    @Override
    public String toString() {
        return id + info.toString();
    }
}
