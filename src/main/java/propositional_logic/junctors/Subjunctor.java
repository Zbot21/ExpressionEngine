package propositional_logic.junctors;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.BinaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.LogicUtilites;
import propositional_logic.expressions.BinaryPropositionalExpression;
import propositional_logic.intf.PropositionalExpressionStrategy;

/**
 * Created by chris on 3/3/16.
 */
public class Subjunctor extends BinaryPropositionalExpression {

    public static BinaryExpressionStrategy BINARY_EXPR_STRAT = (v1, v2) -> {
        boolean value1 = (boolean)v1.getValue();
        boolean value2 = (boolean)v2.getValue();
        return Value.of(!value1 || value2);
    };

    public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, ep) -> {
        BinaryPropositionalExpression expr = Disjunctor.of(Negator.of(ep[0]), ep[0]);
        return LogicUtilites.basicNegatedWrapper(name, expr);
    };

    public static PropositionalExpressionStrategy PROP_EXPR_STRAT = () -> ExpressionType.Subjunctor;

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1        - Expression
     * @param e2        - Expression
     */
    public Subjunctor(Expression e1, Expression e2) {
        super(e1, e2, BINARY_EXPR_STRAT, TRAVERSAL_STRAT, PROP_EXPR_STRAT);
    }
}
