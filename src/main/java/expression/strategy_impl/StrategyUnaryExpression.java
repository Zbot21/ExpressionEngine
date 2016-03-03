package expression.strategy_impl;

import expression.abstract_impl.UnaryExpression;
import expression.intf.Expression;
import knowledge.Value;

/**
 * Created by chris on 3/2/16.
 */
public class StrategyUnaryExpression extends UnaryExpression {
    private UnaryExpressionStrategy strategy;
    public StrategyUnaryExpression(Expression e1, UnaryExpressionStrategy strategy) {
        super(e1);
        this.strategy = strategy;
    }

    @Override
    protected Value operate(Value v1) {
        return strategy.operate(v1);
    }

    public String toString(){
        String temp = super.toString();
        temp += "Strategy: " + strategy.getClass().getName() + "\n";
        return temp;
    }
}
