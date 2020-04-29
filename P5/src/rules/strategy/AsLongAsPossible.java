package rules.strategy;

import rules.Rule;

import java.util.Collection;

public class AsLongAsPossible<T> implements Strategy<T> {

    @Override
    public void algorithm(Rule<T> rule, Collection<T> context) {
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = false;
            for (T elem : context) {
                if (rule.getCond().test(elem)) {
                    keepGoing = true;
                    rule.getAccion().accept(elem);
                }
            }
        }
    }
}
