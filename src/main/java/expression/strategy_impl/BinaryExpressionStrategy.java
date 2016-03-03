package expression.strategy_impl;

import knowledge.Value;

/**
 * Interface for strategies on binary expressions.
 * Created by chris on 2/24/16.
 */
public interface BinaryExpressionStrategy {
    Value operate(Value v1, Value v2);
}
