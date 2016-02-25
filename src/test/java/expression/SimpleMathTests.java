package expression;

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

/** 
* 
* Method: getValue(KnowledgeEngine e) 
* 
*/ 
@Test
public void testSimpleMath() throws Exception {

    // Build a little knowledge base
    KnowledgeEngine engine = new KeyValueKnowledgeEngine();
    engine.insertNamedValue("value1", Value.of(4));
    engine.insertNamedValue("value2", Value.of(5));

    StrategyBinaryExpression expr = new StrategyBinaryExpression(new NamedExpression("value1"), new NamedExpression("value2"), (v1, v2) -> {
        return Value.of((Integer)v1.getValue() + (Integer)v2.getValue()); // Icky nasty casting needed, working on making this cleaner.
    });

    Value result = expr.getValue(engine);
    Assert.assertEquals(result, Value.of(9));
}


} 
