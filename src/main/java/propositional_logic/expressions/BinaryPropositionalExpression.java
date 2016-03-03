package propositional_logic.expressions;

import expression.strategy_impl.BinaryExpressionStrategy;
import expression.intf.Expression;
import expression.traversable_expressions.StrategyTraversableBinaryExpression;
import expression.traversable_expressions.TraversableExpressionStrategy;
import propositional_logic.intf.PropositionalExpression;
import propositional_logic.intf.PropositionalExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class BinaryPropositionalExpression extends StrategyTraversableBinaryExpression implements PropositionalExpression {
    private PropositionalExpressionStrategy sStrategy;

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1        - Expression
     * @param e2        - Expression
     * @param strategy  - Strategy for combining values.
     * @param tStrategy - Strategy for allowing for traversal of the expression, returning more expressions.
     */
    public BinaryPropositionalExpression(Expression e1, Expression e2, BinaryExpressionStrategy strategy, TraversableExpressionStrategy tStrategy, PropositionalExpressionStrategy sStrategy) {
        super(e1, e2, strategy, tStrategy);
        this.sStrategy = sStrategy;
    }

    @Override
    public ExpressionType getExpressionType() {
        return sStrategy.getExpressionType();
    }
}
