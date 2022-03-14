package drawing.exceptions;

public class NotValidSelectionException extends Exception {
    public NotValidSelectionException(){
        super("Selection is not valid, please select two different shapes");
    }
}
