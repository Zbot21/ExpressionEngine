package propositional_logic;

import expression.intf.Expression;
import expression.strategy_impl.StrategyUnaryExpression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.StrategyTraversableUnaryExpression;
import expression.traversable_expressions.TraversableExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class UnaryPropositionalExpression extends StrategyTraversableUnaryExpression {

    public UnaryPropositionalExpression(Expression e1, UnaryExpressionStrategy strategy, TraversableExpressionStrategy tStrategy) {
        super(e1, strategy, tStrategy);
    }
}
