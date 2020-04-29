package rules;

import rules.strategy.Strategy;

public class RuleSetWithStrategy<T> extends RuleSet<T>{
    private Strategy<T> strategy;

    public RuleSetWithStrategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process() {
        getRules().forEach(r -> strategy.algorithm(r, getExecContext()));
    }
}
