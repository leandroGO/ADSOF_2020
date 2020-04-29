package rules.strategy;

import rules.Rule;

import java.util.Collection;

public interface Strategy<T> {
    void algorithm(Rule<T> rule, Collection<T> context);
}
