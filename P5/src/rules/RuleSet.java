package rules;

import java.util.*;

public class RuleSet<T> {
    private Set<Rule<T>> rules = new HashSet<>();
    private Collection<T> execContext;

    public Collection<T> getExecContext() {
        return execContext;
    }

    public void setExecContext(Collection<T> execContext) {
        this.execContext = execContext;
    }

    public RuleSet<T> add(Rule<T> r) {
        rules.add(r);
        return this;
    }

    public RuleSet<T> remove(Rule<T> r) {
        rules.remove(r);
        return this;
    }

    public Set<Rule<T>> getRules() {
        return rules;
    }

    public void process() {
        rules.forEach(r -> execContext.stream().filter(r.getCond()).forEach(r.getAccion()));
    }
}
