package propositional_logic.junctors;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.LogicUtilites;
import propositional_logic.TraversalProperties;
import propositional_logic.UnaryPropositionalExpression;
import propositional_logic.strategies.LogicStrategies;

/**
 * Created by chris on 3/2/16.
 */
public class Negator extends UnaryPropositionalExpression {
    public static UnaryExpressionStrategy UNARY_EXPR_STRAT = (v) -> Value.of(!(boolean)v.getValue());

    public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
        switch (name){
            case TraversalProperties.NORMAL:
                return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, expressionsPresent);
            case TraversalProperties.NEGATE:
                return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, LogicUtilites.negateExpressions(expressionsPresent));
        }
        return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
    };

    public Negator(Expression e1) {
        super(e1, UNARY_EXPR_STRAT, TRAVERSAL_STRAT);
    }
}
