package propositional_logic;

import expression.strategy_impl.BinaryExpressionStrategy;
import expression.intf.Expression;
import expression.traversable_expressions.StrategyTraversableBinaryExpression;
import expression.traversable_expressions.TraversableExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class BinaryPropositionalExpression extends StrategyTraversableBinaryExpression {

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1        - Expression
     * @param e2        - Expression
     * @param strategy  - Strategy for combining values.
     * @param tStrategy - Strategy for allowing for traversal of the expression, returning more expressions.
     */
    public BinaryPropositionalExpression(Expression e1, Expression e2, BinaryExpressionStrategy strategy, TraversableExpressionStrategy tStrategy) {
        super(e1, e2, strategy, tStrategy);
    }
}
