package propositional_logic.junctors;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.BinaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.BinaryPropositionalExpression;
import propositional_logic.LogicUtilites;
import propositional_logic.TraversalProperties;

/**
 * Created by chris on 3/2/16.
 */
public class Disjunctor extends BinaryPropositionalExpression {

    public static BinaryExpressionStrategy BINARY_EXPR_STRAT = (v1, v2) -> {
        boolean value1 = (boolean)v1.getValue();
        boolean value2 = (boolean)v2.getValue();
        return Value.of(value1 || value2);
    };

    public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
        switch (name){
            case TraversalProperties.NORMAL:
                return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SEPERATELY, expressionsPresent);
            case TraversalProperties.NEGATE:
                return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, LogicUtilites.negateExpressions(expressionsPresent));
        }
        return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
    };

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1        - Expression
     * @param e2        - Expression
     */
    public Disjunctor(Expression e1, Expression e2) {
        super(e1, e2, BINARY_EXPR_STRAT, TRAVERSAL_STRAT);
    }
}
