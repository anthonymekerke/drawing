package drawing.exceptions;

public class BadEdgeStrategyException extends Exception {
    public BadEdgeStrategyException(){
        super("Edge Strategy selected is incorrect");
    }
}
