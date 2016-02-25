package knowledge;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple Key-Value knowledge engine for storing world states
 * Created by chris on 2/24/16.
 */
public class KeyValueKnowledgeEngine implements KnowledgeEngine {
    private Map<String, Value> values;

    public KeyValueKnowledgeEngine(){
        values = new HashMap<>();
    }

    public void insertNamedValue(String name, Value value){
        values.put(name, value);
    }

    public Value getNamedValue(String name) {
        return values.get(name);
    }
}
