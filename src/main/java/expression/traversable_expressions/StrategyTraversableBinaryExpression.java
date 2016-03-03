package expression.traversable_expressions;

import expression.BinaryExpressionStrategy;
import expression.StrategyBinaryExpression;
import expression.intf.Expression;
import expression.intf.TraversableExpression;

import java.util.List;

/**
 * Strategy implemented Traversable Binary Expression.
 * Created by chris on 3/2/16.
 */
public class StrategyTraversableBinaryExpression extends StrategyBinaryExpression implements TraversableExpression {
    TraversableExpressionStrategy tStrategy;

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1        - Expression
     * @param e2        - Expression
     * @param strategy  - Strategy for combining values.
     * @param tStrategy - Strategy for allowing for traversal of the expression, returning more expressions.
     */
    public StrategyTraversableBinaryExpression(Expression e1, Expression e2, BinaryExpressionStrategy strategy, TraversableExpressionStrategy tStrategy) {
        super(e1, e2, strategy);
        this.tStrategy = tStrategy;
    }

    @Override
    public List<Expression> getSubExpressions(String name) {
        return tStrategy.getSubExpressions(name, expr1, expr2);
    }

    // TODO: Add a TRAVERSE method here, figure out what it should have as its root, or we create a traverser
}
