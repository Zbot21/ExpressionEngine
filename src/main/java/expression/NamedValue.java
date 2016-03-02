package expression;

import expression.intf.Expression;
import knowledge.KnowledgeEngine;
import knowledge.Value;

/**
 * An expression with a name, the value can be determined from the KnowledgeEngine
 * Created by chris on 2/24/16.
 */
public class NamedValue implements Expression {
    private String name;

    /**
     * Constructs an expression with a name.
     * @param name - The name of the expression
     */
    public NamedValue(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Value getValue(KnowledgeEngine e) {
        return e.getNamedValue(name);
    }

    public static NamedValue of(String name){
        return new NamedValue(name);
    }
}
