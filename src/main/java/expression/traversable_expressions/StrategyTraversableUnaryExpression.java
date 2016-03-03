package expression.traversable_expressions;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.StrategyUnaryExpression;
import expression.strategy_impl.UnaryExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class StrategyTraversableUnaryExpression extends StrategyUnaryExpression implements TraversableExpression {
    private TraversableExpressionStrategy tStrategy;

    public StrategyTraversableUnaryExpression(Expression e1, UnaryExpressionStrategy strategy, TraversableExpressionStrategy tStrategy) {
        super(e1, strategy);
        this.tStrategy = tStrategy;
    }

    @Override
    public ExpressionGroup getSubExpressions(String name) {
        return tStrategy.getSubExpressions(name, expr1);
    }
}
