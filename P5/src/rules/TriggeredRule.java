package rules;

import rules.observer.Observer;
import rules.observer.Subject;

public class TriggeredRule<T extends Subject> extends Rule<T> implements Observer {
    Subject subject;
    String attr;

    private TriggeredRule(String nombre){
        super(nombre);
    }

    public static <T extends Subject> TriggeredRule<T> trigRule(String nombre) {
        return new TriggeredRule<>(nombre);
    }

    public TriggeredRule<T> trigger(T p, String attr) {
        this.subject = p;
        this.attr = attr;
        p.addObserver(this);
        return this;
    }

    @Override
    public Subject getSubject() {
        return subject;
    }

    @Override
    public String getAttr() {
        return attr;
    }

    @Override
    public void process() {
        if (getCond().test(((T) getSubject()))) {
            getAccion().accept(((T) getSubject()));
        }
    }
}
