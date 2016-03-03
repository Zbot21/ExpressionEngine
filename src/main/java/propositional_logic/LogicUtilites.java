package propositional_logic;

import expression.intf.Expression;

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

    /**
     * Created by chris on 3/2/16.
     */
    public static class TraversalProperties {

        public static final String NORMAL = "NORMAL";
        public static final String NEGATE = "NEGATE";

        private TraversalProperties(){}
    }
}
