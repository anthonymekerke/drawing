package drawing.exceptions;

public class EmptySelectionException extends Exception {
    public EmptySelectionException(){
        super("Empty selection:: nothing to group");
    }
}
