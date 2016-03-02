package expression.intf;

import knowledge.KnowledgeEngine;
import knowledge.Value;

/**
 * Expression interface. This is how you get the value of an expression.
 * Created by chris on 2/24/16.
 */
public interface Expression {
    Value getValue(KnowledgeEngine e); // Get the value based on a knowledge engine
}
