package rules.observer;

public interface Observer {
    Subject getSubject();
    String getAttr();
    void process();
}
