package propositional_logic;

import expression.intf.Expression;
import propositional_logic.strategies.LogicStrategies;

/**
 * Created by chris on 3/2/16.
 */
public class Conjunctor extends BinaryPropositionalExpression {

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1 - Expression
     * @param e2 - Expression
     */
    public Conjunctor(Expression e1, Expression e2) {
        super(e1, e2, LogicStrategies.Conjunctor.BINARY_EXPR_STRAT, LogicStrategies.Conjunctor.TRAVERSAL_STRAT);
    }
}
