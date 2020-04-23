package graphs.exceptions;

import graphs.Node;

public class NotInGraphException extends Exception{
    private Node<?> nd;

    public NotInGraphException(Node<?> nd) {
        this.nd = nd;
    }

    @Override
    public String toString() {
        return "Node " + nd + " not in graph";
    }
}
