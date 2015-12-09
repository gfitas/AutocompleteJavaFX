package AutocompleteJavaFX;

/**
 * Created by gfitas on 09/12/15.
 */
import java.util.List;

public abstract class Action {
    public abstract List<? extends Object> methodForGettingItem(String search);
    public abstract void methodWhenAnItemIsSelected(Object object);
}
