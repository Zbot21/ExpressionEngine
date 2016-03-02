package expression.traversable_expressions;

import expression.intf.Expression;

import java.util.List;

/**
 * Created by chris on 3/2/16.
 */
public interface TraversableExpressionStrategy {
    List<Expression> getSubExpressions(String name, Expression... expressionsPresent);
}
