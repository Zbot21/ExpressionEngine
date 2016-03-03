package expression.strategy_impl;

import knowledge.Value;

/**
 * Created by chris on 3/2/16.
 */
public interface UnaryExpressionStrategy {
    Value operate(Value v1);
}
