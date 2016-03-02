package expression;

import expression.intf.Expression;
import knowledge.KnowledgeEngine;
import knowledge.Value;

/**
 * Expression that returns a single value. The value cannot be changed.
 * Created by chris on 2/24/16.
 */
public class ConstExpression implements Expression {
    Value myValue;

    /**
     * Constructs an expression with values.
     * @param val - initialization value
     */
    public ConstExpression(Value val) {
        myValue = val;
    }

    public Value getValue(KnowledgeEngine e) {
        return myValue;
    }
}
