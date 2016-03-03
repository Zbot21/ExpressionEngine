package expression;

import expression.strategy_impl.StrategyBinaryExpression;
import knowledge.KeyValueKnowledgeEngine;
import knowledge.KnowledgeEngine;
import knowledge.Value;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import org.junit.Assert;

/** 
* BinaryExpression Tester. 
* 
* @author Chris Bellis
* @since <pre>Feb 24, 2016</pre> 
* @version 1.0 
*/ 
public class SimpleMathTests {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSimpleMath() throws Exception {

        // Build a little knowledge base
        KnowledgeEngine engine = new KeyValueKnowledgeEngine();
        NamedValue val1 = engine.insertNamedValue("value1", Value.of(4));
        NamedValue val2 = engine.insertNamedValue("value2", Value.of(5));

        // Binary expression for addition
        StrategyBinaryExpression expr = new StrategyBinaryExpression(val1, val2, (v1, v2) -> {
            return Value.of((Integer)v1.getValue() + (Integer)v2.getValue()); // Icky nasty casting needed, working on making this cleaner.
        });

        Value result = expr.getValue(engine);
        Assert.assertEquals(result, Value.of(9));
    }

    @Test
    public void testMultipleExpressions() throws Exception {

        // Build a small knowledge engine
        KnowledgeEngine engine = new KeyValueKnowledgeEngine();
        NamedValue val1 = engine.insertNamedValue("value1", Value.of(5));
        NamedValue val2 = engine.insertNamedValue("value2", Value.of(3));
        NamedValue val3 = engine.insertNamedValue("value3", Value.of(7));
        NamedValue val4 = engine.insertNamedValue("value4", Value.of(11));

        // Multiply v1 and v2
        StrategyBinaryExpression expr1 = new StrategyBinaryExpression(val1, val2, (v1, v2) -> Value.of((int)v1.getValue() * (int)v2.getValue()));

        // Multiply v3 and v4
        StrategyBinaryExpression expr2 = new StrategyBinaryExpression(val3, val4, (v1, v2) -> Value.of((int)v1.getValue() * (int)v2.getValue()));

        // Add the two expressions
        StrategyBinaryExpression expr3 = new StrategyBinaryExpression(expr1, expr2, (e1, e2) -> Value.of((int)e1.getValue() + (int)e2.getValue()));

        Value result = expr3.getValue(engine);
        Assert.assertEquals(result, Value.of(92));
    }

} 
