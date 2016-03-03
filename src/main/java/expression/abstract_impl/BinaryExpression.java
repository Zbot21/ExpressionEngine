package expression.abstract_impl;

import expression.intf.Expression;
import knowledge.KnowledgeEngine;
import knowledge.Value;

/**
 * Abstract Binary Expression
 * Requires that the operate function is overridden to combine two values returned by the component expressions.
 * Created by chris on 2/24/16.
 */
public abstract class BinaryExpression implements Expression {
    protected Expression expr1;
    protected Expression expr2;

    public BinaryExpression(Expression e1, Expression e2){
        this.expr1 = e1;
        this.expr2 = e2;
    }

    public Value getValue(KnowledgeEngine e) {
        Value v1 = expr1.getValue(e);
        Value v2 = expr2.getValue(e);

        return operate(v1, v2);
    }

    protected abstract Value operate(Value v1, Value v2);

    public String toString(){
        String temp = "";
        temp += "Type: " + getClass().getName() + "\n";
        temp += "Expression1: " + expr1.getClass().getName() + "\n";
        temp += "Expression2: " + expr2.getClass().getName() + "\n";
        return temp;
    }
}
