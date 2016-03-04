package propositional_logic.junctors;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import expression.strategy_impl.BinaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.expressions.BinaryPropositionalExpression;
import propositional_logic.LogicUtilites;
import propositional_logic.intf.PropositionalExpression;
import propositional_logic.intf.PropositionalExpressionStrategy;

/**
 * Created by chris on 3/2/16.
 */
public class Conjunctor extends BinaryPropositionalExpression {

    public static BinaryExpressionStrategy BINARY_EXPR_STRAT = (v1, v2) -> {
        boolean value1 = (boolean)v1.getValue();
        boolean value2 = (boolean)v2.getValue();
        return Value.of(value1 && value2);
    };

    public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
        switch(name){
            case LogicUtilites.TraversalProperties.NORMAL:
                return TraversableExpression.ExpressionGroup.simultaneousOf(expressionsPresent);
            case LogicUtilites.TraversalProperties.NEGATE:
                // need the negator
                return TraversableExpression.ExpressionGroup.seperateOf(LogicUtilites.negateExpressions(expressionsPresent));
        }
        return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
    };

    public static PropositionalExpressionStrategy PROP_EXPR_STRAT = () -> ExpressionType.Conjunctor;

    /**
     * Constructs a Binary Expression with two Expressions and a strategy.
     *
     * @param e1 - Expression
     * @param e2 - Expression
     */
    public Conjunctor(Expression e1, Expression e2) {
        super(e1, e2, BINARY_EXPR_STRAT, TRAVERSAL_STRAT, PROP_EXPR_STRAT);
    }

    public static Conjunctor of(Expression e1, Expression e2){
        return new Conjunctor(e1, e2);
    }

    public static Conjunctor of(Expression... expressions){
        if(expressions.length < 2)
            throw new IllegalArgumentException("Must have two expressions!");

        Conjunctor c = Conjunctor.of(expressions[0], expressions[1]);
        for(int i = 2; i < expressions.length; i++){
            c = Conjunctor.of(c, expressions[i]);
        }
        return c;
    }
}
