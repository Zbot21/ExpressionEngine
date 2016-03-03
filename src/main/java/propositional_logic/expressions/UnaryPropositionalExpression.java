package propositional_logic.expressions;

import expression.intf.Expression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.StrategyTraversableUnaryExpression;
import expression.traversable_expressions.TraversableExpressionStrategy;
import propositional_logic.intf.PropositionalExpression;
import propositional_logic.intf.PropositionalExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class UnaryPropositionalExpression extends StrategyTraversableUnaryExpression implements PropositionalExpression {

    private PropositionalExpressionStrategy pStrategy;

    public UnaryPropositionalExpression(Expression e1, UnaryExpressionStrategy strategy,
                                        TraversableExpressionStrategy tStrategy,
                                        PropositionalExpressionStrategy pStrategy) {
        super(e1, strategy, tStrategy);
        this.pStrategy = pStrategy;
    }

    @Override
    public ExpressionType getExpressionType() {
        return pStrategy.getExpressionType();
    }
}
