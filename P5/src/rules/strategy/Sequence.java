package rules.strategy;

import rules.Rule;

import java.util.Collection;

public class Sequence<T> implements Strategy<T> {
    @Override
    public void algorithm(Rule<T> rule, Collection<T> context) {
        context.stream().filter(rule.getCond()).forEach(rule.getAccion());
    }
}
