package expression.abstract_impl;

import expression.intf.Expression;
import knowledge.KnowledgeEngine;
import knowledge.Value;

/**
 * Created by chris on 3/2/16.
 */
public abstract class UnaryExpression implements Expression {
    protected Expression expr1;
    public UnaryExpression(Expression e1){
        this.expr1 = e1;
    }

    public Value getValue(KnowledgeEngine e){
        Value v = expr1.getValue(e);

        return operate(v);
    }

    protected abstract Value operate(Value v1);

    public String toString(){
        String temp = "";
        temp += "Type: " + getClass().getName() + "\n";
        temp += "Expression: " + getClass().getName() + "\n";
        return temp;
    }
}
