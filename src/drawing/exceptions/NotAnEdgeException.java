package drawing.exceptions;

public class NotAnEdgeException extends Exception {
    public NotAnEdgeException(){
        super("No edge Shape in selection, please select one");
    }
}
