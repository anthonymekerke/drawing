package drawing.exceptions;

public class EmptyPaneException extends Exception {
    public EmptyPaneException(){
        super("No shapes to clear");
    }
}
