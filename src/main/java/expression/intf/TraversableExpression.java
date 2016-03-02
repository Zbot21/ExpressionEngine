package expression.intf;

import java.util.List;

/**
 * Created by chris on 3/2/16.
 */
public interface TraversableExpression extends Expression {
    List<Expression> getSubExpressions(String name);
}
