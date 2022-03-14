package drawing.exceptions;

public class IsAGroupException extends Exception {
    public IsAGroupException(){
        super("Selection contains a group of shape, impossible to add text");
    }
}
