package propositional_logic.strategies;

import expression.intf.Expression;
import expression.strategy_impl.BinaryExpressionStrategy;
import expression.intf.TraversableExpression;
import expression.strategy_impl.UnaryExpressionStrategy;
import expression.traversable_expressions.TraversableExpressionStrategy;
import knowledge.Value;
import propositional_logic.Negator;
import propositional_logic.TraversalProperties;

/**
 * Created by chris on 3/2/16.
 */
public interface LogicStrategies {
    class Negator {
        public static UnaryExpressionStrategy UNARY_EXPR_STRAT = (v) -> Value.of(!(boolean)v.getValue());

        public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
            switch (name){
                case TraversalProperties.NORMAL:
                    return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, expressionsPresent);
                case TraversalProperties.NEGATE:
                    return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, Util.negateExpressions(expressionsPresent));
            }
            return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
        };
    }

    class Conjunctor {
        public static BinaryExpressionStrategy BINARY_EXPR_STRAT = (v1, v2) -> {
            boolean value1 = (boolean)v1.getValue();
            boolean value2 = (boolean)v2.getValue();
            return Value.of(value1 && value2);
        };

        public static TraversableExpressionStrategy TRAVERSAL_STRAT = (name, expressionsPresent) -> {
            switch(name){
                case TraversalProperties.NORMAL:
                    return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, expressionsPresent);
                case TraversalProperties.NEGATE:
                    // need the negator
                    return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SEPERATELY, Util.negateExpressions(expressionsPresent));
            }
            return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
        };
    }

    class Disjunctor {
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
                    return new TraversableExpression.ExpressionGroup(TraversableExpression.ExpressionGroup.ExpressionGroupType.SIMULTANEOUS, Util.negateExpressions(expressionsPresent));
            }
            return TraversableExpression.ExpressionGroup.EMPTY_GROUP;
        };
    }

    class Util {
        public static Expression[] negateExpressions(Expression... expressions){
            for(int i = 0; i<expressions.length; i++){
                expressions[i] = new propositional_logic.Negator(expressions[i]);
            }
            return expressions;
        }
    }
}
