package drawing.exceptions;

public class TooMuchShapesException extends Exception {
    public TooMuchShapesException(){
        super("Too much shapes in selection, please choose one group");
    }
}
