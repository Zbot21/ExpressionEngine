package expression.intf;

import expression.ConstExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chris on 3/2/16.
 */
public interface TraversableExpression extends Expression {
    ExpressionGroup getSubExpressions(String name);

    /**
     * Created by chris on 3/2/16.
     */
    class ExpressionGroup {
        public final ExpressionGroupType type;
        private List<Expression> expressionList;
        public ExpressionGroup(ExpressionGroupType type, Expression...expressions){
            this.type = type;
            expressionList = Arrays.asList(expressions);
        }

        public List<Expression> getExpressionList(){
            return new ArrayList<>(expressionList);
        }

        // Simultaenously or seperately true
        public enum ExpressionGroupType { SIMULTANEOUS, SEPERATELY, EMPTY }

        public static final ExpressionGroup EMPTY_GROUP = new ExpressionGroup(ExpressionGroupType.EMPTY);

        public static ExpressionGroup simultaneousOf(Expression... expressions){
            return new ExpressionGroup(ExpressionGroupType.SIMULTANEOUS, expressions);
        }

        public static ExpressionGroup seperateOf(Expression... expressions){
            return new ExpressionGroup(ExpressionGroupType.SEPERATELY, expressions);
        }
    }
}
