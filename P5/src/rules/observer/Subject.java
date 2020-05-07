package rules.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    private Set<Observer> observers = new HashSet<>();

    public Set<Observer> getObservers() {
        return observers;
    }

    public boolean addObserver(Observer o) {
        return observers.add(o);
    }

    public boolean removeObserver(Observer o) {
        return observers.remove(o);
    }

    public abstract void notifyEvent(String attr);
}
