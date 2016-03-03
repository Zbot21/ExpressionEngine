package propositional_logic.intf;

import expression.intf.TraversableExpression;

/**
 * Created by chris on 3/3/16.
 */
public interface PropositionalExpression extends TraversableExpression {
    ExpressionType getExpressionType();

    enum ExpressionType {Conjunctor, Negator, Disjunctor, Subjunctor, BiSubjunctor}
}
