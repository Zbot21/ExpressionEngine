package propositional_logic.junctors;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.LogicUtilites;
import propositional_logic.expressions.UnaryPropositionalExpression;
import propositional_logic.intf.PropositionalExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class Negator extends UnaryPropositionalExpression {
    public static UnaryExpressionStrategy UNARY_EXPR_STRAT = (v) -> Value.of(!(boolean)v.getValue());

    public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
        switch (name){
            case LogicUtilites.TraversalProperties.NORMAL:
                return TraversableExpression.ExpressionGroup.simultaneousOf(expressionsPresent);
            case LogicUtilites.TraversalProperties.NEGATE:
                return TraversableExpression.ExpressionGroup.simultaneousOf(LogicUtilites.negateExpressions(expressionsPresent));
        }
        return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
    };

    public static PropositionalExpressionStrategy PROP_EXPR_STRAT = () -> ExpressionType.Negator;

    public Negator(Expression e1) {
        super(e1, UNARY_EXPR_STRAT, TRAVERSAL_STRAT, PROP_EXPR_STRAT);
    }

    public static Negator of(Expression e){
        return new Negator(e);
    }
}
