/**
 * Created by gfitas on 03/12/15.
 */
public class Value {
    private String name;
    private String symbol;

    public Value(String name,String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public String symbol(){
        return this.symbol;
    }
    @Override
    public String toString() {
        return this.name+" "+this.symbol;
    }
}
