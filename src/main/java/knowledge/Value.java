package knowledge;

/**
 * Value. Generic class for defining values
 * Created by chris on 2/24/16.
 */
public class Value<T> {
    private T myValue;

    /**
     * Get the value
     * @return value
     */
    public T getValue(){
        return myValue;
    }

    /**
     * Set the value
     * @param value - value ot set to
     */
    public void setValue(T value){
        myValue = value;
    }
}
