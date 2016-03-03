package expression;

import expression.intf.Expression;
import knowledge.Value;

/**
 * Binary expression implemented by a strategy.
 * You can arbitrarily determine what kind of binary expression you have, based on a strategy.
 * Created by chris on 2/24/16.
 */
public class StrategyBinaryExpression extends BinaryExpression{
    private BinaryExpressionStrategy strat;

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     * @param e1 - Expression
     * @param e2 - Expression
     * @param strategy - Strategy for combining values.
     */
    public StrategyBinaryExpression(Expression e1, Expression e2, BinaryExpressionStrategy strategy){
        super(e1, e2);
        this.strat = strategy;
    }

    @Override
    public Value operate(Value v1, Value v2) {
        return strat.operate(v1, v2);
    }

    public String toString(){
        String temp = super.toString();
        temp += "Strategy: " + strat.getClass().getName() + "\n";
        return temp;
    }
} 
