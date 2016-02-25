package knowledge;

import expression.NamedValue;

/**
 * Knowledge engine defines the mechanism for geting named values within a system
 * Created by chris on 2/24/16.
 */
public interface KnowledgeEngine {
    Value getNamedValue(String name);
    NamedValue insertNamedValue(String name, Value v);
}
