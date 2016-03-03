package propositional_logic;

import expression.intf.Expression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import propositional_logic.strategies.LogicStrategies;

/**
 * Created by chris on 3/2/16.
 */
public class Negator extends UnaryPropositionalExpression {
    public Negator(Expression e1) {
        super(e1, LogicStrategies.Negator.UNARY_EXPR_STRAT, LogicStrategies.Negator.TRAVERSAL_STRAT);
    }
}
