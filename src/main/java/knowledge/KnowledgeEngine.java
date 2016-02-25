package knowledge;

/**
 * Knowledge engine defines the mechanism for geting named values within a system
 * Created by chris on 2/24/16.
 */
public interface KnowledgeEngine {
    Value getNamedValue(String name);
    void insertNamedValue(String name, Value v);
}
