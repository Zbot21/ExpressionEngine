package propositional_logic;

import expression.intf.Expression;
import expression.intf.TraversableExpression;
import propositional_logic.junctors.Negator;
import sun.misc.RegexpPool;

/**
 * Created by chris on 3/2/16.
 */
public class LogicUtilites {
    public static Expression[] negateExpressions(Expression... expressions){
        for(int i = 0; i<expressions.length; i++){
            expressions[i] = new propositional_logic.junctors.Negator(expressions[i]);
        }
        return expressions;
    }

    public static TraversableExpression.ExpressionGroup basicNegatedWrapper(String name, Expression e){
        switch(name){
            case LogicUtilites.TraversalProperties.NORMAL:
                return TraversableExpression.ExpressionGroup.simultaneousOf(e);
            case LogicUtilites.TraversalProperties.NEGATE:
                return TraversableExpression.ExpressionGroup.simultaneousOf(Negator.of(e));
        }
        return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
    }

    /**
     * Created by chris on 3/2/16.
     */
    public static class TraversalProperties {

        public static final String NORMAL = "NORMAL";
        public static final String NEGATE = "NEGATE";

        private TraversalProperties(){}
    }
}
