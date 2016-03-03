package expression.traversable_expressions;

import expression.intf.Expression;
import expression.intf.TraversableExpression;

/**
 * Created by chris on 3/2/16.
 */
public interface TraversableExpressionStrategy {
    TraversableExpression.ExpressionGroup getSubExpressions(String name, Expression... expressionsPresent);
}
